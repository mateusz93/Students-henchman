UPDATE PLAN_MAPPING set EventCat = 'c' where EventCat like 'c%';
UPDATE PLAN_MAPPING set EventCat = 'l' where EventCat like 'l%' AND EventCat <> '%lekt%';
UPDATE PLAN_MAPPING set EventCat = 'p' where EventCat like 'p%';
UPDATE PLAN_MAPPING set EventCat = 'sem' where EventCat like 'sem.';
UPDATE PLAN_MAPPING set EventCat = 'w' where EventCat like 'w%';