use henchman; #kazdy musi sobie usatwic swoja nazwe schematu
SET foreign_key_checks = 0;

drop view if exists v;
drop table if exists COURSE;

# ten widok budowany jest z tabel na razie jest tak aby byl poniewaz brakuje danych i na ten sprint raczej nie bedziemy go uzywac
#przed zbudowaniem widoku nalezy wykonac skrypt z inserty_z_csv aby tabela plan_mapping miala wartosci
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
from (`PLAN_MAPPING` `p` join `DEAN_GROUP` `g`
on(((`g`.`ABBREVIATION` = `p`.`Group`) or (`g`.`ABBREVIATION` = `p`.`Student`)))));


# ta tabela budowana z widoku na razie jest tak aby byla poniewaz brakuje danych i na ten sprint raczej jej nie bedziemy uzywac
CREATE table COURSE as
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


#**************************************************
#create tabeli course jakby ktos bardzo potrzebowal ale domyslnie jest wykomentowany ;)
#CREATE TABLE `COURSE` (
#  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
#  `EXTERNAL_ID` varchar(100),
#  `DAY` varchar(100),
#  `TIME` varchar(100),
#  `WEEKS` varchar(100),
#  `NAME` varchar(100),
#  `TEACHER_NAME` varchar(100),
#  `ABBREVIATION` varchar(255),
#  `GROUP_NAME` varchar(255)
#) ENGINE=InnoDB DEFAULT CHARSET=utf8;
#**************************************************

SET foreign_key_checks = 1;