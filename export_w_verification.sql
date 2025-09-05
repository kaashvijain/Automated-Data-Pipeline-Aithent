CREATE OR REPLACE DIRECTORY MY_DIR AS 'C:/Users/Kaashvi Jain/SQLORACLE';

CREATE OR REPLACE PROCEDURE export_students(p_filename OUT VARCHAR2) IS
    file_handle UTL_FILE.FILE_TYPE;
    v_line VARCHAR2(4000);
    v_filename VARCHAR2(100);
    v_count NUMBER := 0;
    v_exported NUMBER := 0;
    
BEGIN
    SELECT COUNT(*) INTO v_count FROM students;
    
    v_filename := 'students_' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '.csv';
    
    file_handle := UTL_FILE.FOPEN('MY_DIR', v_filename, 'W');

    UTL_FILE.PUT_LINE(file_handle, 'ID,NAME,MATHS,ENGLISH,SCIENCE,RESULT');

    FOR rec IN (SELECT ID, NAME, MATHS, ENGLISH, SCIENCE, RESULT FROM STUDENTS) LOOP
        v_line := rec.ID || ',' || rec.NAME || ',' || rec.MATHS || ',' || rec.ENGLISH || ',' || rec.SCIENCE || ',' || rec.RESULT;
        
        UTL_FILE.PUT_LINE(file_handle, v_line);
        
        v_exported := v_exported + 1;
        
    END LOOP;

    UTL_FILE.FCLOSE(file_handle);
    
    DBMS_OUTPUT.PUT_LINE(v_exported || ' number of rows exported.');
    
    IF v_count = v_exported THEN 
    
        DBMS_OUTPUT.PUT_LINE('All rows exported successfully.');
    ELSE
    
        DBMS_OUTPUT.PUT_LINE('Exported row count does NOT match table row count.');
        
    END IF;
    
    p_filename := v_filename;
    
END;
/

SELECT * FROM STUDENTS;

SET SERVEROUTPUT ON

DECLARE 
    v_filename VARCHAR2(100);
BEGIN
    export_students(v_filename);
END;
/

COMMIT;
