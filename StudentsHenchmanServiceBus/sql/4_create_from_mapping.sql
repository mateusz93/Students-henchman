use students_henchman; #kazdy musi sobie usatwic swoja nazwe schematu
SET foreign_key_checks = 0;

drop view if exists v;

#Przeniesiony insert z pliku nr 5 poniewaz teraz wplywa on na wartosci w widoku wiec musi byc wykonany przed tworzeniem widoku
INSERT INTO TEACHER (NAME)
  SELECT DISTINCT PLAN_MAPPING.Surname
  FROM PLAN_MAPPING WHERE Surname is not null and Surname not in('Surname','');
  


#tworzenie widoku z tabeli PLAN_MAPPING joinowanej z TEACHER oraz DEAN_GROUP (jak na razie)

create view v AS 
(
select 
p.id AS id,
p.Ref AS ref,
p.Day AS day,
p.Time AS time,
p.Weeks AS weeks,
p.EventCat AS event_type,
t.ID AS teacher_id,
p.Module AS module_name,
g.ID AS dean_group_id
from (PLAN_MAPPING p
join DEAN_GROUP g
on ((g.ABBREVIATION = p.Group) or (g.ABBREVIATION = p.Student)))
join TEACHER t
on p.Surname = t.NAME);

#Po utworzeniu widoku v nalezy wykonac tego inserta w celu uzupelnienia tabeli COURSE
INSERT INTO COURSE (EXTERNAL_ID, NAME, TIME, DAY, WEEKS, DEAN_GROUP_ID, TEACHER_ID)
  SELECT v.ref, v.module_name, v.time, v.day, v.weeks, v.dean_group_id, v.teacher_id
   FROM v;
  

SET foreign_key_checks = 1;
