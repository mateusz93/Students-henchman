use students_henchman; #kazdy musi sobie usatwic swoja nazwe schematu
SET foreign_key_checks = 0;

#***************************************************************************WYDZIALY*************************************************************************** 
INSERT INTO DEPARTMENT(NAME) VALUES ("Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki");
INSERT INTO DEPARTMENT(NAME) VALUES ("Wydzial Mechaniczny");
INSERT INTO DEPARTMENT(NAME) VALUES ("Wydzial Chemiczny");
INSERT INTO DEPARTMENT(NAME) VALUES ("Wydzial Technologii Materialowych i Wzornictwa Tekstyliow");
INSERT INTO DEPARTMENT(NAME) VALUES ("Wydzial Biotechnologii i Nauk o Zywnosci");
INSERT INTO DEPARTMENT(NAME) VALUES ("Wydzial Budownictwa, Architektury i Inzynierii Srodowiska");
INSERT INTO DEPARTMENT(NAME) VALUES ("Wydzial Fizyki Technicznej, Informatyki i Matematyki Stosowanej");
INSERT INTO DEPARTMENT(NAME) VALUES ("Wydzial Organizacji i Zarzadzania");
INSERT INTO DEPARTMENT(NAME) VALUES ("Wydzial Inzynierii Procesowej i Ochrony Srodowiska");
INSERT INTO DEPARTMENT(NAME) VALUES ("Instytut Papiernictwa i Poligrafii");
INSERT INTO DEPARTMENT(NAME) VALUES ("Kolegium Gospodarki Przestrzennej");
INSERT INTO DEPARTMENT(NAME) VALUES ("Kolegium Logistyki");
INSERT INTO DEPARTMENT(NAME) VALUES ("Kolegium Towaroznawstwa");


#***************************************************************************KIERUNKI*************************************************************************** 
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Architektura", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Budownictwa, Architektury i Inzynierii Srodowiska"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Automatyka i robotyka", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Mechaniczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Automatyka i robotyka", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Biogospodarka", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Biotechnologii i Nauk o Zywnosci"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Biotechnologia", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Biotechnologii i Nauk o Zywnosci"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Biotechnologia srodowiska", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Biotechnologii i Nauk o Zywnosci"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Budownictwo", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Budownictwa, Architektury i Inzynierii Srodowiska"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Chemia", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Chemiczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Chemia budowlana", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Chemiczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Chemia i inzynieria materialow specjalnego przeznaczenia", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Chemiczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Edukacja techniczno-informatyczna", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Technologii Materialowych i Wzornictwa Tekstyliow"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Elektronika i telekomunikacja", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Elektrotechnika", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki"));
#*************************************************************************** 
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Energetyka", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")); #kierunek miedzywydzialowy WYJATEK
#*************************************************************************** 
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Europeistyka", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Organizacji i Zarzadzania"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Fizyka techniczna", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Fizyki Technicznej, Informatyki i Matematyki Stosowanej"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Gospodarka przestrzenna", (SELECT ID FROM DEPARTMENT WHERE NAME = "Kolegium Gospodarki Przestrzennej"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Gospodarka przestrzenna", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Budownictwa, Architektury i Inzynierii Srodowiska"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Informatyka", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Informatyka", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Fizyki Technicznej, Informatyki i Matematyki Stosowanej"));
#*************************************************************************** 
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Inzynieria bezpieczenstwa pracy", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")); #kierunek miedzywydzialowy WYJATEK
#*************************************************************************** 
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Inzynieria biochemiczna", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Inzynierii Procesowej i Ochrony Srodowiska"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Inzynieria biomedyczna", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Inzynieria kosmiczna", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Mechaniczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Inzynieria materialowa", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Mechaniczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Inzynieria materialowa", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Chemiczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Inzynieria materialowa", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Technologii Materialowych i Wzornictwa Tekstyliow"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Inzynieria procesowa", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Inzynierii Procesowej i Ochrony Srodowiska"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Inzynieria produkcji", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Mechaniczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Inzynieria zarzadzania", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Organizacji i Zarzadzania"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Inzynieria srodowiska", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Inzynierii Procesowej i Ochrony Srodowiska"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Inzynieria srodowiska", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Budownictwa, Architektury i Inzynierii Srodowiska"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Logistyka", (SELECT ID FROM DEPARTMENT WHERE NAME = "Kolegium Logistyki"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Matematyka", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Fizyki Technicznej, Informatyki i Matematyki Stosowanej"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Mechanika i budowa maszyn", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Mechaniczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Mechatronika", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Mechaniczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Mechatronika", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Nanotechnologia", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Chemiczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Ochrona srodowiska", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Chemiczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Ochrona srodowiska", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Biotechnologii i Nauk o Zywnosci"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Papiernictwo i poligrafia", (SELECT ID FROM DEPARTMENT WHERE NAME = "Instytut Papiernictwa i Poligrafii"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Systemy sterowania inteligentnymi budynkami", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Technologia chemiczna", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Chemiczny"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Technologia kosmetykow", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Biotechnologii i Nauk o Zywnosci"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Technologia zywnosci i zywienie czlowieka", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Biotechnologii i Nauk o Zywnosci"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Towaroznawstwo", (SELECT ID FROM DEPARTMENT WHERE NAME = "Kolegium Towaroznawstwa"));
#*************************************************************************** 
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Transport", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki"));
#*************************************************************************** 
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Wzornictwo", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Technologii Materialowych i Wzornictwa Tekstyliow"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Wlokiennictwo", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Technologii Materialowych i Wzornictwa Tekstyliow"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Wlokiennictwo i przemysl mody", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Technologii Materialowych i Wzornictwa Tekstyliow"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Zarzadzanie", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Organizacji i Zarzadzania"));
INSERT INTO	FIELD(NAME,DEPARTMENT_ID) VALUES("Zarzadzanie i inzynieria produkcji", (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Organizacji i Zarzadzania"));



#***************************************************************************GRUPY DZIEKANSKIE*************************************************************************** 
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1AiR1",1,"Automatyka i robotyka",1, (SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND (DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki"))));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1AiR2",1,"Automatyka i robotyka",1, (SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1AiR3",1,"Automatyka i robotyka",1, (SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1AiR4",1,"Automatyka i robotyka",1, (SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1AiR5",1,"Automatyka i robotyka",1, (SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1AiR6",1,"Automatyka i robotyka",1, (SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1AiR7",1,"Automatyka i robotyka",1, (SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1AiR8",1,"Automatyka i robotyka",1, (SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1AiR9",1,"Automatyka i robotyka",1, (SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1EiT1",1,"Elektronika i telekomunikacja",1,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1EiT2",1,"Elektronika i telekomunikacja",1,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1EiT3",1,"Elektronika i telekomunikacja",1,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1EiT4",1,"Elektronika i telekomunikacja",1,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1EiT5",1,"Elektronika i telekomunikacja",1,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1EiT6",1,"Elektronika i telekomunikacja",1,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1EiT7",1,"Elektronika i telekomunikacja",1,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1EiT8",1,"Elektronika i telekomunikacja",1,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1ET1",1,"Elektrotechnika",1,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1ET2",1,"Elektrotechnika",1,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1ET3",1,"Elektrotechnika",1,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1ET4",1,"Elektrotechnika",1,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1ET5",1,"Elektrotechnika",1,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1ET6",1,"Elektrotechnika",1,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1ET s2",2,"Elektrotechnika",1,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I01",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I02",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I03",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I04",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I05",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I06",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I07",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I08",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I09",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I010",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I011",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I012",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I013",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I014",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I015",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I016",1,"Informatyka",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I ISBD s2",2,"Inteligentne systemy baz danych D20",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I SRiPM s2",2,"Systemy rozproszone i platformy mobilne D60",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1I SAdPJEE s2",2,"Srodowiska aplikacyjne dla platformy Java EE D50",1,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1IB 1",1,"Inzynieria biomedyczna",1,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1IB 2",1,"Inzynieria biomedyczna",1,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1IB 3",1,"Inzynieria biomedyczna",1,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1IB 4",1,"Inzynieria biomedyczna",1,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1IB 5",1,"Inzynieria biomedyczna",1,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1IB s2",2,"Inzynieria biomedyczna",1,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1M1",1,"Mechatronika",1,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1M2",1,"Mechatronika",1,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1M3",1,"Mechatronika",1,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1M4",1,"Mechatronika",1,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1M5",1,"Mechatronika",1,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1M6",1,"Mechatronika",1,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1S1",1,"Systemy sterowania inteligentnymi budynkami",1,(SELECT ID FROM FIELD WHERE NAME = "Systemy sterowania inteligentnymi budynkami" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1S2",1,"Systemy sterowania inteligentnymi budynkami",1,(SELECT ID FROM FIELD WHERE NAME = "Systemy sterowania inteligentnymi budynkami" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1S3",1,"Systemy sterowania inteligentnymi budynkami",1,(SELECT ID FROM FIELD WHERE NAME = "Systemy sterowania inteligentnymi budynkami" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1S4",1,"Systemy sterowania inteligentnymi budynkami",1,(SELECT ID FROM FIELD WHERE NAME = "Systemy sterowania inteligentnymi budynkami" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1_E1e",1,"Energetyka",1,(SELECT ID FROM FIELD WHERE NAME = "Energetyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1_E2e",1,"Energetyka",1,(SELECT ID FROM FIELD WHERE NAME = "Energetyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("1_T1e",1,"Transport",1,(SELECT ID FROM FIELD WHERE NAME = "Transport" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2AiR1",2,"Automatyka i robotyka",2,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2AiR2",2,"Automatyka i robotyka",2,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2EiT 1",2,"Elektronika i telekomunikacja",2,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2EiT 2",2,"Elektronika i telekomunikacja",2,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2EiT-E",2,"Elektronika i telekomunikacja - Elektronika",2,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2EiT-T",2,"Elektronika i telekomunikacja - Telekomunikacja",2,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2ET AiM",2,"Elektrotechnika - Automatyka i metrologia",2,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2ET E1",2,"Elektrotechnika - Elektroenergetyka",2,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2ET E2",2,"Elektrotechnika - Elektroenergetyka",2,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2ET IiDE-1",2,"Elektrotechnika - Informatyka i diagnostyka el-en",2,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2ET IiDE-2",2,"Elektrotechnika - Informatyka i diagnostyka el-en",2,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2ET MPD",2,"Elektrotechnika - Metody przetwarzania danych",2,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2I",2,"Informatyka",2,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2I CS",2,"Informatyka - Computer Science D70",2,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2I ISBD",2,"Informatyka - Inteligentne systemy baz danych D20",2,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2I SRiPM",2,"Informatyka - Systemy rozproszone i platformy mobilne D60",2,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2I SAdPJEE",2,"Informatyka - Srodowiska aplikacyjne dla platformy Java EE D50",2,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("2IB",2,"Inzynieria biomedyczna",2,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3AiR1",1,"Automatyka i robotyka",3,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3AiR2",1,"Automatyka i robotyka",3,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3AiR3",1,"Automatyka i robotyka",3,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3AiR4",1,"Automatyka i robotyka",3,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3AiR5",1,"Automatyka i robotyka",3,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3AiR6",1,"Automatyka i robotyka",3,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3EiT1",1,"Elektronika i telekomunikacja",3,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3EiT2",1,"Elektronika i telekomunikacja",3,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3EiT3",1,"Elektronika i telekomunikacja",3,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3EiT4",1,"Elektronika i telekomunikacja",3,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3EiT5",1,"Elektronika i telekomunikacja",3,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3ET1",1,"Elektrotechnika",3,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3ET2",1,"Elektrotechnika",3,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3ET3",1,"Elektrotechnika",3,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3ET4",1,"Elektrotechnika",3,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3Is2",2,"Informatyka",3,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3I1",1,"Informatyka",3,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3I2",1,"Informatyka",3,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3I3",1,"Informatyka",3,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3I4",1,"Informatyka",3,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3I5",1,"Informatyka",3,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3I6",1,"Informatyka",3,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3I7",1,"Informatyka",3,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3I8",1,"Informatyka",3,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3I9",1,"Informatyka",3,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3IBs2",2,"Inzynieria biomedyczna",3,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3IB1",1,"Inzynieria biomedyczna",3,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3IB2",1,"Inzynieria biomedyczna",3,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3M1",1,"Mechatronika",3,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3M2",1,"Mechatronika",3,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3M3",1,"Mechatronika",3,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3M4",1,"Mechatronika",3,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3M5",1,"Mechatronika",3,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3S1",1,"Systemy sterowania inteligentnymi budynkami",3,(SELECT ID FROM FIELD WHERE NAME = "Systemy sterowania inteligentnymi budynkami" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3S2",1,"Systemy sterowania inteligentnymi budynkami",3,(SELECT ID FROM FIELD WHERE NAME = "Systemy sterowania inteligentnymi budynkami" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3_E1e1",1,"Energetyka",3,(SELECT ID FROM FIELD WHERE NAME = "Energetyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3_E1e2",1,"Energetyka",3,(SELECT ID FROM FIELD WHERE NAME = "Energetyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3_E2e",1,"Energetyka",3,(SELECT ID FROM FIELD WHERE NAME = "Energetyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3_IBP W2",1,"Inzynieria bezpieczenstwa pracy",3,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria bezpieczenstwa pracy" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("3_Te",1,"Transport",3,(SELECT ID FROM FIELD WHERE NAME = "Transport" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5AiR1",1,"Automatyka i robotyka",5,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5AiR2",1,"Automatyka i robotyka",5,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5AiR3",1,"Automatyka i robotyka",5,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5AiR4",1,"Automatyka i robotyka",5,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5AiR5",1,"Automatyka i robotyka",5,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5EiT.",1,"Elektronika i telekomunikacja",5,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5EiT.EM",1,"Elektronika i telekomunikacja - Elektronika motoryzacyjna",5,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5EiT.MSPLC",1,"Elektronika i telekomunikacja - Mikrokontrolery i sterowniki PLC",5,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5EiT.SISS 1",1,"Elektronika i telekomunikacja - Systemy i sieci swiatlowodowe",5,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5EiT.SISS 2",1,"Elektronika i telekomunikacja - Systemy i sieci swiatlowodowe",5,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5ET AiM",1,"Elektrotechnika - Automatyka i metrologia",5,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5ET E",1,"Elektrotechnika - Elektroenergetyka",5,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5ET PE",1,"Elektrotechnika - Przetworniki elektromechaniczne",5,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5I",1,"Informatyka",5,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5I BDiSE",1,"Informatyka -  Bazy danych i systemy ekspertowe D10",5,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5I IO1",1,"Informatyka -  Inżynieria oprogramowania D30",5,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5I IO2",1,"Informatyka -  Inżynieria oprogramowania D30",5,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5I SS",1,"Informatyka -  Systemy sieciowe D20",5,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5I TI1",1,"Informatyka -  Technologie internetowe D40",5,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5I TI2",1,"Informatyka -  Technologie internetowe D40",5,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5I TI3",1,"Informatyka -  Technologie internetowe D40",5,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5IB1",1,"Inzynieria biomedyczna",5,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5IB2",1,"Inzynieria biomedyczna",5,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5M 1",1,"Mechatronika",5,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5M 2",1,"Mechatronika",5,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5M 3",1,"Mechatronika",5,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5M 4",1,"Mechatronika",5,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5M.HŁE",1,"Mechatronika - Hybrydowe laczeniowe elementy",5,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5M.MP",1,"Mechatronika - Mechanika pojazdowa",5,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5M.MUN",1,"Mechatronika - Mechatroniczne układy napedowe",5,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5M.SEM",1,"Mechatronika - Systemy elektroniczne w mechatronice",5,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5M.SMAGD",1,"Mechatronika - Systemy mechatroniczne w AGD",5,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));

INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5_E1e1",1,"Energetyka",5,(SELECT ID FROM FIELD WHERE NAME = "Energetyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5_E1e2",1,"Energetyka",5,(SELECT ID FROM FIELD WHERE NAME = "Energetyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("5_T2e",1,"Transport",5,(SELECT ID FROM FIELD WHERE NAME = "Transport" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7AiR1",1,"Automatyka i robotyka",7,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7AiR2",1,"Automatyka i robotyka",7,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7AiR3",1,"Automatyka i robotyka",7,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7AiR4",1,"Automatyka i robotyka",7,(SELECT ID FROM FIELD WHERE NAME = "Automatyka i robotyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7EiT.EM",1,"Elektronika i telekomunikacja - Elektronika motoryzacyjna",7,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7EiT.KPiPSCADA",1,"Elektronika i telekomunikacja - Komputery przemyslowe i Pakiety HMI SCADA",7,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7EiT.OZE ",1,"Elektronika i telekomunikacja - Odnawialne zrodla energii",7,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7EiT.PMiPS ",1,"Elektronika i telekomunikacja - Programowanie mikrokontrolerow i procesorow sygnalowych",7,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7EiT.PUMiZ",1,"Elektronika i telekomunikacja - Programowanie urządzeń mobilnych i ich zastosowania",7,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7EiT.URiJHDL ",1,"Elektronika i telekomunikacja - Uklady reknfigurowalne i jezyki HDL",7,(SELECT ID FROM FIELD WHERE NAME = "Elektronika i telekomunikacja" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7ET AiM",1,"Elektrotechnika - Automatyka i metrologia",7,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7ET E-OE",1,"Elektrotechnika - Oswietlenie elektryczne",7,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7ET E-SE1",1,"Elektrotechnika - Sieci elektroenergetyczne",7,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7ET E-SE2 ",1,"Elektrotechnika - Sieci elektroenergetyczne",7,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7ET EO",1,"Elektrotechnika - Energetyka odnawialna",7,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7ET IN-1",1,"Elektrotechnika - Instalacje niskonapieciowe",7,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7ET IN-2",1,"Elektrotechnika - Instalacje niskonapieciowe",7,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7ET PE",1,"Elektrotechnika - Przetworniki elektromechaniczne",7,(SELECT ID FROM FIELD WHERE NAME = "Elektrotechnika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I GiM1",1,"Informatyka - Grafika i multimedia",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I GiM2",1,"Informatyka - Grafika i multimedia",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I PG",1,"Informatyka - Programowanie gier",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I TiZJO",1,"Informatyka - Testowanie i zapewnienie jakosci oprogramowania",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I TM1",1,"Informatyka - Technologie mobilne",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I TM2",1,"Informatyka - Technologie mobilne",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I TM3",1,"Informatyka - Technologie mobilne",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I TM4",1,"Informatyka - Technologie mobilne",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I ZAB1",1,"Informatyka - Zaawansowane aplikacje bazodanowe",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I ZAB2",1,"Informatyka - Zaawansowane aplikacje bazodanowe",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I ZPS",1,"Informatyka - Zaawansowane programowanie sieciowe",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I ZSK",1,"Informatyka - Zarzadzanie sieciami komputerowymi",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I_BDiSE",1,"Informatyka - Bazy danych i systemy ekspertowe D10",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I_IO",1,"Informatyka - Inżynieria oprogramowania D30",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I_SS",1,"Informatyka - Systemy sieciowe D20",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I_TI1",1,"Informatyka - Technologie internetowe D40",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I_TI2",1,"Informatyka - Technologie internetowe D40",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7I_TI3",1,"Informatyka - Technologie internetowe D40",7,(SELECT ID FROM FIELD WHERE NAME = "Informatyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7IB1",1,"Inzynieria biomedyczna",7,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7IB2",1,"Inzynieria biomedyczna",7,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria biomedyczna" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7M1",1,"Mechatronika",7,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7M2",1,"Mechatronika",7,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7M3",1,"Mechatronika",7,(SELECT ID FROM FIELD WHERE NAME = "Mechatronika" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7_E1e1",1,"Energetyka",7,(SELECT ID FROM FIELD WHERE NAME = "Energetyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));
INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7_E1e2",1,"Energetyka",7,(SELECT ID FROM FIELD WHERE NAME = "Energetyka" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7_IBP",1,"Inzynieria bezpieczenstwa pracy",7,(SELECT ID FROM FIELD WHERE NAME = "Inzynieria bezpieczenstwa pracy" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


INSERT INTO DEAN_GROUP(ABBREVIATION,DEGREE,NAME,TERM,FIELD_ID) VALUES("7_T1e",1,"Transport",7,(SELECT ID FROM FIELD WHERE NAME = "Transport" AND DEPARTMENT_ID = (SELECT ID FROM DEPARTMENT WHERE NAME = "Wydzial Elektrotechniki, Elektroniki, Informatyki i Automatyki")));


#***************************************************************************DATY*************************************************************************** 
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-09-26","MONDAY",1);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-10-03","MONDAY",2);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-10-10","MONDAY",3);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-10-17","MONDAY",4);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-10-24","MONDAY",5);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-11-07","MONDAY",6);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-11-14","MONDAY",7);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-11-21","MONDAY",8);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-11-28","MONDAY",9);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-12-05","MONDAY",10);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-12-12","MONDAY",11);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-12-19","MONDAY",12);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-01-09","MONDAY",13);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-01-16","MONDAY",14);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-01-23","MONDAY",15);


INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-09-27","TUESDAY",1);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-10-04","TUESDAY",2);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-10-11","TUESDAY",3);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-10-18","TUESDAY",4);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-10-25","TUESDAY",5);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-11-08","TUESDAY",6);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-11-15","TUESDAY",7);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-11-22","TUESDAY",8);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-11-29","TUESDAY",9);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-12-06","TUESDAY",10);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-12-13","TUESDAY",11);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-12-20","TUESDAY",12);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-01-10","TUESDAY",13);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-01-17","TUESDAY",14);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-01-24","TUESDAY",15);


INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-09-28","WEDNESDAY",1);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-10-05","WEDNESDAY",2);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-10-12","WEDNESDAY",3);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-10-19","WEDNESDAY",4);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-10-26","WEDNESDAY",5);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-11-02","WEDNESDAY",6);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-11-16","WEDNESDAY",7);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-11-23","WEDNESDAY",8);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-11-30","WEDNESDAY",9);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-12-07","WEDNESDAY",10);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-12-14","WEDNESDAY",11);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-12-21","WEDNESDAY",12);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-01-04","WEDNESDAY",13);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-01-11","WEDNESDAY",14);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-01-18","WEDNESDAY",15);

INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-09-29","THURSTDAY",1);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-10-06","THURSTDAY",2);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-10-13","THURSTDAY",3);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-10-20","THURSTDAY",4);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-10-27","THURSTDAY",5);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-11-03","THURSTDAY",6);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-11-10","THURSTDAY",7);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-11-17","THURSTDAY",8);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-11-24","THURSTDAY",9);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-12-01","THURSTDAY",10);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-12-08","THURSTDAY",11);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-12-15","THURSTDAY",12);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-01-05","THURSTDAY",13);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-01-12","THURSTDAY",14);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-01-19","THURSTDAY",15);

INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-09-30","FRIDAY",1);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-10-07","FRIDAY",2);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-10-14","FRIDAY",3);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-10-21","FRIDAY",4);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-10-28","FRIDAY",5);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-11-04","FRIDAY",6);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-11-09","FRIDAY",7);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-11-18","FRIDAY",8);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-11-25","FRIDAY",9);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-12-02","FRIDAY",10);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-12-09","FRIDAY",11);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-12-16","FRIDAY",12);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-01-03","FRIDAY",13);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(2,"2016-01-13","FRIDAY",14);
INSERT INTO DATE(CYCLE,DATE,DAY_OF_WEEK,WEEK_NO) VALUES(1,"2016-01-20","FRIDAY",15);

#############################################################################################
INSERT INTO USER(EMAIL) VALUES("mobile1@mobile.com");
INSERT INTO USER(EMAIL) VALUES("mobile2@mobile.com");
INSERT INTO USER(EMAIL) VALUES("mobile3@mobile.com");

SET foreign_key_checks = 1;
