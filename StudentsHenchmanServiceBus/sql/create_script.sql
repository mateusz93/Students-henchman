#use henchman;
SET foreign_key_checks = 0;

CREATE TABLE `plan_maping` (
  `Ref` varchar(100) DEFAULT NULL,
  `Day` varchar(100) DEFAULT NULL,
  `Time` varchar(100) DEFAULT NULL,
  `Weeks` varchar(100) DEFAULT NULL,
  `EventCat` varchar(100) DEFAULT NULL,
  `Weighting` varchar(100) DEFAULT NULL,
  `Module` varchar(100) DEFAULT NULL,
  `ModCode` varchar(100) DEFAULT NULL,
  `Room` varchar(100) DEFAULT NULL,
  `Surname` varchar(100) DEFAULT NULL,
  `Forenames` varchar(100) DEFAULT NULL,
  `StaffCode` varchar(100) DEFAULT NULL,
  `Group` varchar(100) DEFAULT NULL,
  `Student` varchar(100) DEFAULT NULL,
  `StudCode` varchar(100) DEFAULT NULL,
  `Protected` varchar(100) DEFAULT NULL,
  `Global` varchar(100) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `DateChanged` varchar(100) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2469 DEFAULT CHARSET=utf8


create view v AS 
(
select `p`.`id` AS `id`,
`p`.`Ref` AS `Ref`,
`p`.`Day` AS `Day`,
`p`.`Time` AS `Time`,
`p`.`Weeks` AS `Weeks`,
`p`.`EventCat` AS `EventCat`,
`p`.`Surname` AS `Surname`,
`p`.`Module` AS `Module`,
`g`.`ABBREVIATION` AS `abbreviation`,
`g`.`NAME` AS `group_name`
from (`plan_maping` `p` join `dean_group` `g` 
on(((`g`.`ABBREVIATION` = `p`.`Group`) or (`g`.`ABBREVIATION` = `p`.`Student`)))));


CREATE table course as 
select 
id as ID,
Ref as EXTERNAL_ID,
Day as DAY,
Time as TIME,
Weeks as WEEKS,
Module as NAME,
Surname as TEACHER_NAME,
abbreviation as ABBREVIATION,
group_name as GROUP_NAME
from v;


CREATE TABLE `build` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `LATITUDE` double DEFAULT NULL,
  `LONGITUDE` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_ec9eug3irmodmalsunrtutg9m` (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `date` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CYCLE` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `DAY_OF_WEEK` varchar(255) NOT NULL,
  `WEEK_NO` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_ao4pxo3mp65jj1t0wgo4557bj` (`DATE`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;


CREATE TABLE `dean_group` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ABBREVIATION` varchar(255) NOT NULL,
  `DEGREE` int(11) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `TERM` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_jvw32tgk6buimr8i3jncvcyke` (`ABBREVIATION`)
) ENGINE=InnoDB AUTO_INCREMENT=199 DEFAULT CHARSET=utf8;


CREATE TABLE `department` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;


CREATE TABLE `field` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DEPARTMENT_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_hh72378lgxdmb49mp701pg1n0` (`DEPARTMENT_ID`),
  CONSTRAINT `FK_hh72378lgxdmb49mp701pg1n0` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `department` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;


CREATE TABLE `field_subject` (
  `SUBJECT_ID` bigint(20) NOT NULL,
  `FIELD_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`FIELD_ID`,`SUBJECT_ID`),
  KEY `FK_rnwuk7rhowi9p8n02iulqfn4s` (`SUBJECT_ID`),
  CONSTRAINT `FK_96pus40qrhrggje8r98wnrv76` FOREIGN KEY (`FIELD_ID`) REFERENCES `field` (`ID`),
  CONSTRAINT `FK_rnwuk7rhowi9p8n02iulqfn4s` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subject` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `room` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `specialization` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `FIELD_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_4r7widpmh2cdh7pvw2f854ms1` (`FIELD_ID`),
  CONSTRAINT `FK_4r7widpmh2cdh7pvw2f854ms1` FOREIGN KEY (`FIELD_ID`) REFERENCES `field` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `subject` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_de8h7o6ncpxchba7jjvagsvva` (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `subject_type` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_s097ub0jnw9mfncm858k6vnb4` (`TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `teacher` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) NOT NULL,
  `FIRST_NAME` varchar(255) NOT NULL,
  `LAST_NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_al3ku1wrpfx7sc1py7vn99doi` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





