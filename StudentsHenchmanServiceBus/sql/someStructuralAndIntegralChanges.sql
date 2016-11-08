ALTER TABLE teacher add NAME varchar(255);
INSERT INTO teacher (NAME)
  SELECT DISTINCT plan_maping.Surname
  FROM plan_maping WHERE Surname is not null and Surname not in('Surname','');

DELIMITER $$
DROP PROCEDURE IF EXISTS insertuj$$
CREATE PROCEDURE insertuj()
BEGIN
	DECLARE all_records INTEGER DEFAULT 0;
    DECLARE roomfullname varchar(255) DEFAULT "";
    DECLARE building varchar(255) DEFAULT "";
    DECLARE roomcode varchar(255) DEFAULT "";
    DECLARE room_cursor CURSOR FOR SELECT Room from plan_maping;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET all_records=1;
    OPEN room_cursor;
    get_record: LOOP
    FETCH room_cursor INTO roomfullname;
    IF all_records = 1 THEN
    LEAVE get_record;
    END IF;
    IF INSTR(roomfullname, ' ')>0 THEN
		BEGIN
        SET building = SUBSTR(roomfullname,1,INSTR(roomfullname, ' '));
        SET roomcode = SUBSTR(roomfullname, INSTR(roomfullname, ' ')+1);
        INSERT INTO room (code,name) VALUES (roomcode,building);
        END;
    ELSE
		INSERT INTO room (code,name) values (roomfullname, '');
	END IF;
    END LOOP get_record;
    CLOSE room_cursor;
END $$
DELIMITER ;
CALL insertuj();

DELIMITER $$
DROP PROCEDURE IF EXISTS swapuj$$
CREATE PROCEDURE swapuj()
BEGIN
	DECLARE all_records INTEGER DEFAULT 0;
    DECLARE weeksfield varchar(255) DEFAULT "";
    DECLARE weeksid bigint(20);
    DECLARE firstpart varchar(255) DEFAULT "";
    DECLARE firstnumber INTEGER;
    DECLARE secondpart varchar(255) DEFAULT "";
    DECLARE secondnumber INTEGER;
    DECLARE helperpart varchar(255) DEFAULT "";
    DECLARE weeks_cursor CURSOR FOR SELECT id FROM TestDB.plan_maping where INSTR(Weeks,'-')>0;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET all_records=1;
    UPDATE plan_maping set Weeks = CONCAT(CONCAT(SUBSTR(Weeks,1,INSTR(Weeks,'10')-1),'A'),SUBSTR(Weeks,INSTR(Weeks,'10')+2)) where INSTR(Weeks,'10')>0;
    UPDATE plan_maping set Weeks = CONCAT(CONCAT(SUBSTR(Weeks,1,INSTR(Weeks,'11')-1),'B'),SUBSTR(Weeks,INSTR(Weeks,'11')+2)) where INSTR(Weeks,'11')>0;
    UPDATE plan_maping set Weeks = CONCAT(CONCAT(SUBSTR(Weeks,1,INSTR(Weeks,'12')-1),'C'),SUBSTR(Weeks,INSTR(Weeks,'12')+2)) where INSTR(Weeks,'12')>0;
    UPDATE plan_maping set Weeks = CONCAT(CONCAT(SUBSTR(Weeks,1,INSTR(Weeks,'13')-1),'D'),SUBSTR(Weeks,INSTR(Weeks,'13')+2)) where INSTR(Weeks,'13')>0;
    UPDATE plan_maping set Weeks = CONCAT(CONCAT(SUBSTR(Weeks,1,INSTR(Weeks,'14')-1),'E'),SUBSTR(Weeks,INSTR(Weeks,'14')+2)) where INSTR(Weeks,'14')>0;
    UPDATE plan_maping set Weeks = CONCAT(CONCAT(SUBSTR(Weeks,1,INSTR(Weeks,'15')-1),'F'),SUBSTR(Weeks,INSTR(Weeks,'15')+2)) where INSTR(Weeks,'15')>0;
    OPEN weeks_cursor;
    get_record: LOOP
    FETCH weeks_cursor INTO weeksid;
    IF all_records = 1 THEN
    LEAVE get_record;
    END IF;
    select weeksfield = Weeks from plan_maping where id = weeksid;
    change_text : LOOP
    IF INSTR(weeksfield, '-')>0 THEN
		BEGIN
        SET firstpart = SUBSTR(weeksfield,INSTR(weeksfield, '-')-1,1);
        IF firstpart = 'A' THEN SET firstnumber = 10;
        ELSEIF firstpart = 'B' THEN SET firstnumber = 11;
        ELSEIF firstpart = 'C' THEN SET firstnumber = 12;
        ELSEIF firstpart = 'D' THEN SET firstnumber = 13;
        ELSEIF firstpart = 'E' THEN SET firstnumber = 14;
        ELSEIF firstpart = 'F' THEN SET firstnumber = 15;
        END IF;
        SET secondpart = SUBSTR(weeksfield,INSTR(weeksfield, '-')+1,1);
        IF secondpart = 'A' THEN SET secondnumber = 10;
        ELSEIF secondpart = 'B' THEN SET secondnumber = 11;
        ELSEIF secondpart = 'C' THEN SET secondnumber = 12;
        ELSEIF secondpart = 'D' THEN SET secondnumber = 13;
        ELSEIF secondpart = 'E' THEN SET secondnumber = 14;
        ELSEIF secondpart = 'F' THEN SET secondnumber = 15;
        END IF;
        SET helperpart='';
        WHILE(firstnumber<secondnumber) DO
            SET helperpart=helperpart+firstnumber+',';
            SET firstnumber = firstnumber+1;
        END WHILE;
        SET helperpart=helperpart+secondnumber;
        SET weeksfield = CONCAT(CONCAT(SUBSTR(weeksfield,1,INSTR(weeksfield,'-'-2)),helperpart),SUBSTR(weeksfield,INSTR(weeksfield,'-'+2)));
        END;
    ELSE UPDATE plan_mapping set Weeks=weeksfield where id=weeksid; LEAVE change_text;
	END IF;
    END LOOP change_text;
    END LOOP get_record;
    CLOSE weeks_cursor;
END $$
DELIMITER ;
CALL swapuj();