CREATE TABLE WYDZIALY (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nazwa_wydzialu VARCHAR(30) NOT NULL
);
INSERT INTO WYDZIALY (nazwa_wydzialu) VALUES ('weeia');

CREATE TABLE BUDYNKI (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nazwa_budynku VARCHAR(60) NOT NULL,
szerokosc_geograficzna DOUBLE, -- + -> N, - -> S
dlugosc_geograficzna DOUBLE -- + -> E, - -> W
);
INSERT INTO BUDYNKI (nazwa_budynku, szerokosc_geograficzna,dlugosc_geograficzna) VALUES ('Centrum Technologii Informatycznych', 51.7469995, 19.4557481);

CREATE TABLE BUDYNEK_WYDZIAL ( -- jeden do wielu
id_budynku INT(6) UNSIGNED,
id_wydzialu INT(6) UNSIGNED, 
FOREIGN KEY(id_budynku) REFERENCES BUDYNKI(id),
FOREIGN KEY(id_wydzialu) REFERENCES WYDZIALY(id)
);
INSERT INTO BUDYNEK_WYDZIAL (id_budynku, id_wydzialu) VALUES ((SELECT ID FROM WYDZIALY),(SELECT ID FROM BUDYNKI));

CREATE TABLE SALE (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
id_budynku INT(6) UNSIGNED,
nazwa_sali VARCHAR(60) NOT NULL,
FOREIGN KEY(id_budynku) REFERENCES BUDYNKI(id)
);
INSERT INTO SALE (id_budynku, nazwa_sali) VALUES ((SELECT ID FROM BUDYNKI), '301');

CREATE TABLE UZYTKOWNICY (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
imie VARCHAR(30) NOT NULL,
nazwisko VARCHAR(30) NOT NULL,
email VARCHAR(50) NOT NULL,
hash_preferencji VARCHAR(256) NOT NULL
);
INSERT INTO UZYTKOWNICY (imie,nazwisko,email,hash_preferencji) VALUES ('Janek', 'Kowalski', 'jkowalski93@gmail.com','0x07e547d9586f6a73f73fbac0435ed76951218fb7d0c8d788a309d785436bbb642e93a252a954f23912547d1e8a3b5ed6e1bfd7097821233fa0538f3db854fee6');

CREATE TABLE PRZEDMIOTY (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
id_sali INT(6) UNSIGNED,
nazwa_przedmiotu VARCHAR(30) NOT NULL,
ilosc_zajec INT(2) UNSIGNED,
cykl INT(1) UNSIGNED, -- co ile tygodni
pierwszy_tydzien_zajec INT(2) UNSIGNED,
dzien_tygodnia INTEGER(1) UNSIGNED, -- 1 poniedzialek, 2 wtorek... 7 niedziela
godzina INTEGER(2) UNSIGNED, -- dla 8 -> 8:15, dla 12 -> 12:15 (a zajęcia zawsze trwają zgodnie z regulaminem 45min.
czas_trwania INTEGER(1) UNSIGNED,
prowadzacy VARCHAR(30) NOT NULL,
FOREIGN KEY(id_sali) REFERENCES SALE(id)
);

INSERT INTO PRZEDMIOTY (id_sali,nazwa_przedmiotu,ilosc_zajec,cykl,pierwszy_tydzien_zajec, dzien_tygodnia,godzina,czas_trwania,prowadzacy) VALUES ((select id from SALE), 'Programowanie sieciowe 2', 15, 1, 1, 3, 12, 2, 'R.Wajman');
INSERT INTO PRZEDMIOTY (id_sali,nazwa_przedmiotu,ilosc_zajec,cykl,pierwszy_tydzien_zajec, dzien_tygodnia,godzina,czas_trwania,prowadzacy) VALUES ((select id from SALE), 'Algorytmy', 15, 1, 1, 2, 8, 2, 'J.Dokimuk');
INSERT INTO PRZEDMIOTY (id_sali,nazwa_przedmiotu,ilosc_zajec,cykl,pierwszy_tydzien_zajec, dzien_tygodnia,godzina,czas_trwania,prowadzacy) VALUES ((select id from SALE), 'Seminarium dyplomowe', 15, 1, 1, 1, 8, 2 , 'A.Napieralski');

CREATE TABLE SPECJALIZACJE (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nazwa_specjalizacji VARCHAR(30) NOT NULL
);
INSERT INTO SPECJALIZACJE (nazwa_specjalizacji) VALUES ('TM1');

CREATE TABLE PRZEDMIOT_SPECJALIZACJA(
id_przedmiotu INT(6) UNSIGNED,
id_specjalizacji INT(6) UNSIGNED,
FOREIGN KEY(id_przedmiotu) REFERENCES PRZEDMIOTY(id),
FOREIGN KEY(id_specjalizacji) REFERENCES SPECJALIZACJE(id)
);
INSERT INTO PRZEDMIOT_SPECJALIZACJA (id_przedmiotu, id_specjalizacji) VALUES ((select id from PRZEDMIOTY where nazwa_przedmiotu = 'Seminarium dyplomowe'),(select id from SPECJALIZACJE));

CREATE TABLE BLOKI_OBIERALNE (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nazwa_bloku VARCHAR(30) NOT NULL
);

INSERT INTO BLOKI_OBIERALNE (nazwa_bloku) VALUES ('ZPS');

CREATE TABLE PRZEDMIOT_BLOK(
id_przedmiotu INT(6) UNSIGNED,
id_bloku INT(6) UNSIGNED,
FOREIGN KEY(id_przedmiotu) REFERENCES PRZEDMIOTY(id),
FOREIGN KEY(id_bloku) REFERENCES BLOKI_OBIERALNE(id)
);
INSERT INTO PRZEDMIOT_BLOK (id_przedmiotu, id_bloku) VALUES ((select id from PRZEDMIOTY where nazwa_przedmiotu = 'Programowanie sieciowe 2'),(select id from BLOKI_OBIERALNE));

CREATE TABLE GRUPY_DZIEKANSKIE (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nazwa_grupy_dziekanskiej VARCHAR(30) NOT NULL
);
INSERT INTO GRUPY_DZIEKANSKIE (nazwa_grupy_dziekanskiej) VALUES ('1D1');

CREATE TABLE PRZEDMIOT_GRUPA(
id_przedmiotu INT(6) UNSIGNED,
id_grupy INT(6) UNSIGNED,
FOREIGN KEY(id_przedmiotu) REFERENCES PRZEDMIOTY(id),
FOREIGN KEY(id_grupy) REFERENCES GRUPY_DZIEKANSKIE(id)
);
INSERT INTO PRZEDMIOT_GRUPA (id_przedmiotu, id_grupy) VALUES ((SELECT id from PRZEDMIOTY where nazwa_przedmiotu = 'Algorytmy'),(SELECT id from GRUPY_DZIEKANSKIE));

CREATE TABLE UZYTKOWNIK_PRZEDMIOT ( -- wiele do wielu
id_uzytkownika INT(6) UNSIGNED,
id_przedmiotu INT(6) UNSIGNED,
uprawnienie BOOLEAN, -- dla 0 - wykluczamy ten przedmiot, w przypadku 1 - dodajemy ten przedmiot (ma zastosowanie np. kiedy jestesmy w ramach jakiejs specjalizacji, ale zaliczylismy jakis przedmiot wczesniej albo mamy jakies plecy i jakis przedmiot z poprzedniego semestru dodatkowo do zaliczenia
FOREIGN KEY(id_uzytkownika) REFERENCES UZYTKOWNICY(id),
FOREIGN KEY(id_przedmiotu) REFERENCES PRZEDMIOTY(id)
);
INSERT INTO UZYTKOWNIK_PRZEDMIOT (id_uzytkownika, id_przedmiotu, uprawnienie) VALUES ((SELECT ID FROM UZYTKOWNICY), (SELECT ID FROM PRZEDMIOTY WHERE nazwa_przedmiotu = 'Programowanie sieciowe 2'), 1);
INSERT INTO UZYTKOWNIK_PRZEDMIOT (id_uzytkownika, id_przedmiotu, uprawnienie) VALUES ((SELECT ID FROM UZYTKOWNICY), (SELECT ID FROM PRZEDMIOTY WHERE nazwa_przedmiotu = 'Algorytmy'), 1);
INSERT INTO UZYTKOWNIK_PRZEDMIOT (id_uzytkownika, id_przedmiotu, uprawnienie) VALUES ((SELECT ID FROM UZYTKOWNICY), (SELECT ID FROM PRZEDMIOTY WHERE nazwa_przedmiotu = 'Seminarium dyplomowe'), 1);

CREATE TABLE UZYTKOWNIK_SPECJALIZACJA ( -- jeden do wielu
id_uzytkownika INT(6) UNSIGNED,
id_specjalizacja INT(6) UNSIGNED, -- dla 0 - wykluczamy ten przedmiot, w przypadku 1 - dodajemy ten przedmiot (ma zastosowanie np. kiedy jestesmy w ramach jakiejs specjalizacji, ale zaliczylismy jakis przedmiot wczesniej albo mamy jakies plecy i jakis przedmiot z poprzedniego semestru dodatkowo do zaliczenia
FOREIGN KEY(id_uzytkownika) REFERENCES UZYTKOWNICY(id),
FOREIGN KEY(id_specjalizacja) REFERENCES SPECJALIZACJE(id)
);
INSERT INTO UZYTKOWNIK_SPECJALIZACJA (id_uzytkownika, id_specjalizacja) VALUES ((SELECT id from UZYTKOWNICY), (SELECT ID FROM SPECJALIZACJE));

CREATE TABLE UZYTKOWNIK_BLOK_OBIERALNY ( -- wiele do wielu
id_uzytkownika INT(6) UNSIGNED,
id_bloku INT(6) UNSIGNED,
uprawnienie BOOLEAN, -- dla 0 - wykluczamy ten przedmiot, w przypadku 1 - dodajemy ten przedmiot (ma zastosowanie np. kiedy jestesmy w ramach jakiejs specjalizacji, ale zaliczylismy jakis przedmiot wczesniej albo mamy jakies plecy i jakis przedmiot z poprzedniego semestru dodatkowo do zaliczenia
FOREIGN KEY(id_uzytkownika) REFERENCES UZYTKOWNICY(id),
FOREIGN KEY(id_bloku) REFERENCES BLOKI_OBIERALNE(id)
);

INSERT INTO UZYTKOWNIK_BLOK_OBIERALNY (id_uzytkownika, id_bloku) VALUES ((SELECT id from UZYTKOWNICY), (SELECT ID FROM BLOKI_OBIERALNE));