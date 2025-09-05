CREATE SEQUENCE seq
START WITH 14 
INCREMENT BY 1 
NOCYCLE
NOCACHE;

CREATE OR REPLACE PROCEDURE calc_result IS 
BEGIN 
    UPDATE STUDENTS 
    SET RESULT = CASE 
        WHEN (maths + english + science) >= 150 THEN 'PASS'
        ELSE 'FAIL'
      END;
END;

Create table Students(
ID INT not null,
name varchar(20) not null,
maths int,
english int,
science int,
result varchar(10),
PRIMARY KEY (ID)
);

INSERT INTO STUDENTS (ID, NAME, MATHS, ENGLISH, SCIENCE) 
VALUES (seq.nextval, 'A', 75, 78, 71);

INSERT INTO STUDENTS (ID, NAME, MATHS, ENGLISH, SCIENCE) 
VALUES (seq.nextval, 'B', 65, 79, 81);

INSERT INTO STUDENTS (ID, NAME, MATHS, ENGLISH, SCIENCE) 
VALUES (seq.nextval, 'C', 85, 89, 91);

INSERT INTO STUDENTS (ID, NAME, MATHS, ENGLISH, SCIENCE) 
VALUES (seq.nextval, 'H', 85, 89, 91);

INSERT INTO STUDENTS (ID, NAME, MATHS, ENGLISH, SCIENCE) 
VALUES (seq.nextval, 'I', 85, 89, 91);

BEGIN
    calc_result;
END;
/

SELECT * FROM STUDENTS;

COMMIT;



