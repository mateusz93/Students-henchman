use henchman;
SET foreign_key_checks = 0;

#drop table WYDZIALY;
#drop table KIERUNKI;
#drop table TYPY_ZAJEC;
#drop table ZAJECIA;
#drop table BUDYNKI;
#drop table SALE;
#drop table UZYTKOWNICY;
#drop table WYKLADOWCY;
#drop table PRZEDMIOTY;
#drop table SPECJALIZACJE;
#drop table BLOKI_OBIERALNE;
#drop table GRUPY_DZIEKANSKIE;

CREATE TABLE WYDZIALY (
	id BIGINT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nazwa_wydzialu VARCHAR(300) NOT NULL
);

CREATE TABLE KIERUNKI (
	id BIGINT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	id_wydzialu BIGINT(6) UNSIGNED,
	nazwa_kierunku VARCHAR(300) NOT NULL,
	FOREIGN KEY(id_wydzialu) REFERENCES WYDZIALY(id)
);

CREATE TABLE BUDYNKI (
	id BIGINT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nazwa_budynku VARCHAR(300) NOT NULL,
	kod VARCHAR(60) NOT NULL,
	szerokosc_geograficzna DOUBLE, -- + -> N, - -> S
	dlugosc_geograficzna DOUBLE, -- + -> E, - -> W
	id_wydzialu BIGINT(6) UNSIGNED,
	FOREIGN KEY(id_wydzialu) REFERENCES WYDZIALY(id)
);

CREATE TABLE SALE (
	id BIGINT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	id_budynku BIGINT(6) UNSIGNED,
	nazwa_sali VARCHAR(60) NOT NULL,
	kod VARCHAR(60) NOT NULL,
	FOREIGN KEY(id_budynku) REFERENCES BUDYNKI(id)
);

CREATE TABLE TYPY_ZAJEC (
	id BIGINT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	typ VARCHAR(60) NOT NULL
);

CREATE TABLE WYKLADOWCY (
	id BIGINT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	imie VARCHAR(30) NOT NULL,
	nazwisko VARCHAR(30) NOT NULL,
	email VARCHAR(256) NOT NULL
);

CREATE TABLE UZYTKOWNICY (
	id BIGINT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	id_bloku_obieralnego BIGINT(6) UNSIGNED,
	id_specjalizacji BIGINT(6) UNSIGNED,
	id_kierunku BIGINT(6) UNSIGNED,
	id_przedmiotow VARCHAR(500),
	imie VARCHAR(30) NOT NULL,
	nazwisko VARCHAR(30) NOT NULL,
	email VARCHAR(256) NOT NULL,
	hash_preferencji VARCHAR(256) NOT NULL,
	FOREIGN KEY(id_kierunku) REFERENCES KIERUNKI(id),
	FOREIGN KEY(id_bloku_obieralnego) REFERENCES BLOKI_OBIERALNE(id),
	FOREIGN KEY(id_specjalizacji) REFERENCES SPECJALIZACJE(id)
);

CREATE TABLE PRZEDMIOTY (
	id BIGINT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	id_kierunku BIGINT(6) UNSIGNED,
	id_specjalizacji BIGINT(6) UNSIGNED,
	id_bloku_obieralnego BIGINT(6) UNSIGNED,
	nazwa VARCHAR(60) NOT NULL,
	kod VARCHAR(60) NOT NULL,
	FOREIGN KEY(id_kierunku) REFERENCES KIERUNKI(id),
	FOREIGN KEY(id_bloku_obieralnego) REFERENCES BLOKI_OBIERALNE(id),
	FOREIGN KEY(id_specjalizacji) REFERENCES SPECJALIZACJE(id)
);

CREATE TABLE ZAJECIA (
	id BIGINT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	id_sali BIGINT(6) UNSIGNED,
	id_typu_zajec BIGINT(6) UNSIGNED,
	id_prowadzacego BIGINT(6) UNSIGNED,
	nazwa_przedmiotu VARCHAR(30) NOT NULL,
	ilosc_zajec BIGINT(6) UNSIGNED,
	cykl BIGINT(6) UNSIGNED, -- co ile tygodni
	pierwszy_tydzien_zajec BIGINT(6) UNSIGNED,
	dzien_tygodnia BIGINT(6) UNSIGNED, -- 1 poniedzialek, 2 wtorek... 7 niedziela
	godzina_rozpoczecia BIGINT(6) UNSIGNED, -- dla 8 -> 8:15, dla 12 -> 12:15 (a zajęcia zawsze trwają zgodnie z regulaminem 45min.
	godzina_zakonczenia BIGINT(6) UNSIGNED,
	FOREIGN KEY(id_sali) REFERENCES SALE(id),
	FOREIGN KEY(id_prowadzacego) REFERENCES WYKLADOWCY(id),
	FOREIGN KEY(id_typu_zajec) REFERENCES TYPY_ZAJEC(id)
);

CREATE TABLE SPECJALIZACJE (
	id BIGINT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nazwa_specjalizacji VARCHAR(60) NOT NULL,
	id_kierunku BIGINT(6) UNSIGNED,
	FOREIGN KEY(id_kierunku) REFERENCES KIERUNKI(id)
);

CREATE TABLE BLOKI_OBIERALNE (
	id BIGINT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nazwa_bloku VARCHAR(60) NOT NULL,
	id_kierunku BIGINT(6) UNSIGNED,
	FOREIGN KEY(id_kierunku) REFERENCES KIERUNKI(id)
);

CREATE TABLE GRUPY_DZIEKANSKIE (
	id BIGINT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nazwa_grupy_dziekanskiej VARCHAR(30) NOT NULL
);

INSERT INTO GRUPY_DZIEKANSKIE (nazwa_grupy_dziekanskiej) VALUES ('1D1');
INSERT INTO GRUPY_DZIEKANSKIE (nazwa_grupy_dziekanskiej) VALUES ('1D2');
INSERT INTO GRUPY_DZIEKANSKIE (nazwa_grupy_dziekanskiej) VALUES ('1D3 ');
INSERT INTO WYDZIALY (nazwa_wydzialu) VALUES ('weeia');
INSERT INTO WYDZIALY (nazwa_wydzialu) VALUES ('ftims');
INSERT INTO WYDZIALY (nazwa_wydzialu) VALUES ('baiś');
INSERT INTO KIERUNKI (nazwa_kierunku, id_wydzialu) VALUES ('Informatyka', (SELECT ID FROM WYDZIALY WHERE nazwa_wydzialu='weeia'));
INSERT INTO KIERUNKI (nazwa_kierunku, id_wydzialu) VALUES ('Matematyka', (SELECT ID FROM WYDZIALY WHERE nazwa_wydzialu='ftims'));
INSERT INTO KIERUNKI (nazwa_kierunku, id_wydzialu) VALUES ('Fizyka', (SELECT ID FROM WYDZIALY WHERE nazwa_wydzialu='ftims'));
INSERT INTO TYPY_ZAJEC (typ) VALUES ('Laboratorium');
INSERT INTO TYPY_ZAJEC (typ) VALUES ('Seminarium');
INSERT INTO TYPY_ZAJEC (typ) VALUES ('Wykład');
INSERT INTO WYKLADOWCY (imie,nazwisko,email) VALUES ('Janek', 'Kowalski', 'janek@edu.p.lodz.pl');
INSERT INTO WYKLADOWCY (imie,nazwisko,email) VALUES ('Adam', 'Krucz', 'adam@edu.p.lodz.pl');
INSERT INTO WYKLADOWCY (imie,nazwisko,email) VALUES ('Krzysztof', 'Zbigniew', 'krzys3@edu.p.lodz.pl');
INSERT INTO SPECJALIZACJE (nazwa_specjalizacji, id_kierunku) VALUES ('TM1', (SELECT ID FROM KIERUNKI WHERE nazwa_kierunku = 'Informatyka' and id_wydzialu=(SELECT ID FROM WYDZIALY WHERE nazwa_wydzialu='weeia')));
INSERT INTO SPECJALIZACJE (nazwa_specjalizacji, id_kierunku) VALUES ('TM2', (SELECT ID FROM KIERUNKI WHERE nazwa_kierunku = 'Matematyka'));
INSERT INTO SPECJALIZACJE (nazwa_specjalizacji, id_kierunku) VALUES ('TM3', (SELECT ID FROM KIERUNKI WHERE nazwa_kierunku = 'Informatyka' and id_wydzialu=(SELECT ID FROM WYDZIALY WHERE nazwa_wydzialu='ftims')));
INSERT INTO PRZEDMIOTY (id_specjalizacji, id_kierunku,nazwa,kod) VALUES ((select id from SPECJALIZACJE where nazwa_specjalizacji='TM1'), (SELECT ID FROM KIERUNKI WHERE NAZWA_KIERUNKU='INFORMATYKA' and id_wydzialu=(SELECT ID FROM WYDZIALY WHERE nazwa_wydzialu='weeia')), 'Przetwarzanie w chmurze', 'AM1_INF_WEEIA');
INSERT INTO PRZEDMIOTY (id_specjalizacji, id_kierunku,nazwa,kod) VALUES ((select id from SPECJALIZACJE where nazwa_specjalizacji='TM2'), (SELECT ID FROM KIERUNKI WHERE NAZWA_KIERUNKU='INFORMATYKA' and id_wydzialu=(SELECT ID FROM WYDZIALY WHERE nazwa_wydzialu='ftims')), 'Projektowanie urządzeń mobilnych', 'PUM_INF_WEEIA');
INSERT INTO BUDYNKI (kod, nazwa_budynku, szerokosc_geograficzna,dlugosc_geograficzna, id_wydzialu) VALUES ('CTI', 'Centrum Technologii Informatycznych', 51.7469995, 19.4557481, 1);
INSERT INTO BUDYNKI (kod, nazwa_budynku, szerokosc_geograficzna,dlugosc_geograficzna, id_wydzialu) VALUES ('IIS', 'Instytut Informatyki Stosowanej', 51.7526605,19.4521049, 1);
INSERT INTO BUDYNKI (kod, nazwa_budynku, szerokosc_geograficzna,dlugosc_geograficzna, id_wydzialu) VALUES ('DMCS', 'Katedra Mikroelektroniki i Technik Informatycznych ', 51.7460828,19.4550015, 3);
INSERT INTO SALE (kod, id_budynku, nazwa_sali) VALUES ('CTI301', (SELECT ID FROM BUDYNKI WHERE kod='CTI'), '301');
INSERT INTO SALE (kod, id_budynku, nazwa_sali) VALUES ('IISA1', (SELECT ID FROM BUDYNKI WHERE kod='IIS'), 'A1');
INSERT INTO SALE (kod, id_budynku, nazwa_sali) VALUES ('IIS105', (SELECT ID FROM BUDYNKI WHERE kod='IIS'), '105');
INSERT INTO ZAJECIA (id_sali,nazwa_przedmiotu,ilosc_zajec,cykl,pierwszy_tydzien_zajec, dzien_tygodnia,godzina_rozpoczecia,godzina_zakonczenia, id_typu_zajec, id_prowadzacego) VALUES ((select id from SALE WHERE nazwa_sali='301'), 'Programowanie sieciowe 2', 15, 1, 1, 3, 12, 14, (SELECT ID FROM TYPY_ZAJEC WHERE typ = 'Laboratiorium'), (SELECT ID FROM WYKLADOWCY WHERE NAZWISKO = 'Krucz'));
INSERT INTO ZAJECIA (id_sali,nazwa_przedmiotu,ilosc_zajec,cykl,pierwszy_tydzien_zajec, dzien_tygodnia,godzina_rozpoczecia,godzina_zakonczenia, id_typu_zajec, id_prowadzacego) VALUES ((select id from SALE WHERE nazwa_sali='A1'), 'Algorytmy', 15, 1, 1, 2, 8, 10, (SELECT ID FROM TYPY_ZAJEC WHERE typ = 'Wykład'), (SELECT ID FROM WYKLADOWCY  WHERE NAZWISKO = 'Zbigniew'));
INSERT INTO ZAJECIA (id_sali,nazwa_przedmiotu,ilosc_zajec,cykl,pierwszy_tydzien_zajec, dzien_tygodnia,godzina_rozpoczecia,godzina_zakonczenia, id_typu_zajec, id_prowadzacego) VALUES ((select id from SALE WHERE nazwa_sali='115'), 'Seminarium dyplomowe', 15, 1, 1, 1, 8, 12 , (SELECT ID FROM TYPY_ZAJEC WHERE typ = 'Seminarium'), (SELECT ID FROM WYKLADOWCY  WHERE NAZWISKO = 'Kowalski'));
INSERT INTO UZYTKOWNICY (imie,nazwisko,email,hash_preferencji, id_przedmiotow) VALUES ('Janek', 'Kowalski', 'jkowalski93@gmail.com','0x07e547d9586f6a73f73fbac0435ed76951218fb7d0c8d788a309d785436bbb642e93a252a954f23912547d1e8a3b5ed6e1bfd7097821233fa0538f3db854fee6', '1');
INSERT INTO UZYTKOWNICY (imie,nazwisko,email,hash_preferencji, id_przedmiotow) VALUES ('Andrzej', 'Stonoga', 'jkowalski93@gmail.com','0x2a954f23912547d1e8a3b5ed6e1bfd7097821233fa0538f3db854fee607e547d9586f6a73f73fbac0435ed76951218fb7d0c8d788a309d785436bbb642e93a25', '1');
INSERT INTO UZYTKOWNICY (imie,nazwisko,email,hash_preferencji, id_przedmiotow) VALUES ('Adam', 'Nowak', 'jkowalski93@gmail.com','0x0c8d788a309d785436bbb642e93a252a954f239125407e547d9586f6a73f73fbac0435ed76951218fb7d7d1e8a3b5ed6e1bfd7097821233fa0538f3db854fee6', '1');
INSERT INTO BLOKI_OBIERALNE (nazwa_bloku, id_kierunku) VALUES ('ZPS', (SELECT ID FROM KIERUNKI WHERE nazwa_kierunku = 'Informatyka' and id_wydzialu=(SELECT ID FROM WYDZIALY WHERE nazwa_wydzialu='weeia')));
INSERT INTO BLOKI_OBIERALNE (nazwa_bloku, id_kierunku) VALUES ('PG', (SELECT ID FROM KIERUNKI WHERE nazwa_kierunku = 'Informatyka' and id_wydzialu=(SELECT ID FROM WYDZIALY WHERE nazwa_wydzialu='ftims')));
INSERT INTO BLOKI_OBIERALNE (nazwa_bloku, id_kierunku) VALUES ('TM', (SELECT ID FROM KIERUNKI WHERE nazwa_kierunku = 'Informatyka' and id_wydzialu=(SELECT ID FROM WYDZIALY WHERE nazwa_wydzialu='weeia')));
--dane testowe


SET foreign_key_checks = 1;
