use henchman;
SET foreign_key_checks = 0;

--drop table WYDZIALY;
--drop table KIERUNKI;
--drop table BUDYNKI;
--drop table SALE;
--drop table UZYTKOWNICY;
--drop table PRZEDMIOTY;
--drop table SPECJALIZACJE;
--drop table BLOKI_OBIERALNE;
--drop table GRUPY_DZIEKANSKIE;

CREATE TABLE WYDZIALY (
	id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nazwa_wydzialu VARCHAR(300) NOT NULL
);

CREATE TABLE KIERUNKI (
	id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	id_wydzialu int(6) UNSIGNED,
	nazwa_kierunku VARCHAR(300) NOT NULL,
	FOREIGN KEY(id_wydzialu) REFERENCES WYDZIALY(id)
);

CREATE TABLE BUDYNKI (
	id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nazwa_budynku VARCHAR(300) NOT NULL,
	szerokosc_geograficzna DOUBLE, -- + -> N, - -> S
	dlugosc_geograficzna DOUBLE, -- + -> E, - -> W
	id_wydzialu int(6) UNSIGNED,
	FOREIGN KEY(id_wydzialu) REFERENCES WYDZIALY(id)
);

CREATE TABLE SALE (
	id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	id_budynku int(6) UNSIGNED,
	nazwa_sali VARCHAR(60) NOT NULL,
	FOREIGN KEY(id_budynku) REFERENCES BUDYNKI(id)
);

CREATE TABLE UZYTKOWNICY (
	id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	imie VARCHAR(30) NOT NULL,
	nazwisko VARCHAR(30) NOT NULL,
	email VARCHAR(256) NOT NULL,
	hash_preferencji VARCHAR(256) NOT NULL
);

CREATE TABLE PRZEDMIOTY (
	id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	id_sali int(6) UNSIGNED,
	id_bloku_obieralnego int(6) UNSIGNED,
	id_specjalizacji int(6) UNSIGNED,
	nazwa_przedmiotu VARCHAR(30) NOT NULL,
	ilosc_zajec int(6) UNSIGNED,
	cykl int(6) UNSIGNED, -- co ile tygodni
	pierwszy_tydzien_zajec int(6) UNSIGNED,
	dzien_tygodnia int(6) UNSIGNED, -- 1 poniedzialek, 2 wtorek... 7 niedziela
	godzina int(6) UNSIGNED, -- dla 8 -> 8:15, dla 12 -> 12:15 (a zajęcia zawsze trwają zgodnie z regulaminem 45min.
	czas_trwania int(6) UNSIGNED,
	prowadzacy VARCHAR(60) NOT NULL,
	FOREIGN KEY(id_sali) REFERENCES SALE(id),
	FOREIGN KEY(id_specjalizacji) REFERENCES SPECJALIZACJE(id),
	FOREIGN KEY(id_bloku_obieralnego) REFERENCES BLOKI_OBIERALNE(id)
);

CREATE TABLE SPECJALIZACJE (
	id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nazwa_specjalizacji VARCHAR(60) NOT NULL,
	id_przedmiotu int(6) UNSIGNED,
	id_kierunku int(6) UNSIGNED,
	FOREIGN KEY(id_przedmiotu) REFERENCES PRZEDMIOTY(id),
	FOREIGN KEY(id_kierunku) REFERENCES KIERUNKI(id)
);

CREATE TABLE BLOKI_OBIERALNE (
	id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nazwa_bloku VARCHAR(60) NOT NULL,
	id_kierunku int(6) UNSIGNED,
	FOREIGN KEY(id_kierunku) REFERENCES KIERUNKI(id)
);

CREATE TABLE GRUPY_DZIEKANSKIE (
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nazwa_grupy_dziekanskiej VARCHAR(30) NOT NULL
);

INSERT INTO GRUPY_DZIEKANSKIE (nazwa_grupy_dziekanskiej) VALUES ('1D1');
INSERT INTO WYDZIALY (nazwa_wydzialu) VALUES ('weeia');
INSERT INTO KIERUNKI (nazwa_kierunku, id_wydzialu) VALUES ('Informatyka', (SELECT ID FROM WYDZIALY));
INSERT INTO BUDYNKI (nazwa_budynku, szerokosc_geograficzna,dlugosc_geograficzna, id_wydzialu) VALUES ('Centrum Technologii Informatycznych', 51.7469995, 19.4557481, 1);
INSERT INTO SALE (id_budynku, nazwa_sali) VALUES ((SELECT ID FROM BUDYNKI), '301');
INSERT INTO UZYTKOWNICY (imie,nazwisko,email,hash_preferencji) VALUES ('Janek', 'Kowalski', 'jkowalski93@gmail.com','0x07e547d9586f6a73f73fbac0435ed76951218fb7d0c8d788a309d785436bbb642e93a252a954f23912547d1e8a3b5ed6e1bfd7097821233fa0538f3db854fee6');
INSERT INTO PRZEDMIOTY (id_specjalizacji, id_sali,nazwa_przedmiotu,ilosc_zajec,cykl,pierwszy_tydzien_zajec, dzien_tygodnia,godzina,czas_trwania,prowadzacy) VALUES ((select id from SPECJALIZACJE), (select id from SALE), 'Programowanie sieciowe 2', 15, 1, 1, 3, 12, 2, 'R.Wajman');
INSERT INTO PRZEDMIOTY (id_specjalizacji, id_sali,nazwa_przedmiotu,ilosc_zajec,cykl,pierwszy_tydzien_zajec, dzien_tygodnia,godzina,czas_trwania,prowadzacy) VALUES ((select id from SPECJALIZACJE), (select id from SALE), 'Algorytmy', 15, 1, 1, 2, 8, 2, 'J.Dokimuk');
INSERT INTO PRZEDMIOTY (id_specjalizacji, id_sali,nazwa_przedmiotu,ilosc_zajec,cykl,pierwszy_tydzien_zajec, dzien_tygodnia,godzina,czas_trwania,prowadzacy) VALUES ((select id from SPECJALIZACJE), (select id from SALE), 'Seminarium dyplomowe', 15, 1, 1, 1, 8, 2 , 'A.Napieralski');
INSERT INTO SPECJALIZACJE (nazwa_specjalizacji, id_kierunku) VALUES ('TM1', (SELECT ID FROM KIERUNKI));
INSERT INTO BLOKI_OBIERALNE (nazwa_bloku, id_kierunku) VALUES ('ZPS', (SELECT ID FROM KIERUNKI));

SET foreign_key_checks = 1;
