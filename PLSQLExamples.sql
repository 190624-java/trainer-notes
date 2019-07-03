CREATE TABLE Employees(
    E_ID number(6) primary key,
    E_Name varchar2(100),
    E_Salary number(9),
    E_Title varchar2(100)
);

INSERT INTO EMPLOYEES
VALUES(1, 'Bobbert', 235000, 'TRAINER');
INSERT INTO EMPLOYEES
VALUES(2, 'Ryan', 0, 'TRAINER');
INSERT INTO EMPLOYEES
VALUES(3, 'Tom', 120000, 'MARKETER');
INSERT INTO EMPLOYEES
VALUES(4, 'Dogbert', 450000, 'SALES');
INSERT INTO EMPLOYEES
VALUES(5, 'Bill Nai', 25000, 'SALES');
INSERT INTO EMPLOYEES
VALUES(6, 'Overlord Ryan Lessley', 30000, 'TRAINER');
INSERT INTO EMPLOYEES
VALUES(7, 'Tom', 220000, 'MARKETER');
INSERT INTO EMPLOYEES
VALUES(8, 'tim', 220000, 'MARKETER');
INSERT INTO EMPLOYEES
VALUES(9, 'TAM', 220000, 'MARKETER');
INSERT INTO EMPLOYEES
VALUES(10, 'Tommy', 220000, 'MARKETER');

-- PL/SQL

/*
    A SEQUENCE is an object that maintains a counter 
*/
DROP SEQUENCE emp_id_seq;
CREATE SEQUENCE emp_id_seq
    START WITH 11
    INCREMENT BY 1
;

/*
    a trigger waits for a particular action.
*/
CREATE OR REPLACE TRIGGER emp_seq_trigger
BEFORE INSERT ON employees
FOR EACH ROW
BEGIN
    IF :new.e_id IS NULL
    THEN
        SELECT emp_id_seq.nextval INTO :new.e_id FROM dual;
    END IF;
END;

INSERT INTO employees (e_name, e_salary, e_title)
VALUES ('Jessica', '0.00', 'Trainer');
SELECT * FROM employees;

-- simple stored procedure
CREATE OR REPLACE PROCEDURE hello_world_procedure
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello World'); -- same as sysout in Java
END;

-- two ways of invoking a stored procedure
BEGIN
    hello_world_procedure();
END;
--or 
CALL hello_world_procedure();
EXECUTE hello_world_procedure();

/*
    you can use parameters with stored procedures.
    IN parameters - are passed in during the procedure call
    OUT parameters - what is returned from the procedure
    IN OUT parameters - used as input, transformed as output
    
    Stored procedures:
    - have as many in/out params as you want
    - can call other stored procedures in a stored procedure. 
    - can call functions
    - can alter data base with most DML statements
 */
CREATE OR REPLACE PROCEDURE insertIntoEmployee(
    empName IN VARCHAR2, empSal IN NUMBER, empTitle IN VARCHAR2)
IS
BEGIN
    INSERT INTO employees (e_name, e_salary, e_title)
    VALUES (empName, empSal, empTitle);
    COMMIT; -- saves these changes to the database.
END;
    
CALL insertIntoEmployee('Matt', 100000, 'Trainer');
SELECT COUNT(e_id) FROM employees WHERE e_id > 11;

-- another procedure example
CREATE OR REPLACE PROCEDURE get_name(emp_id IN NUMBER, emp_name OUT VARCHAR2)
IS
BEGIN
    SELECT e_name INTO emp_name FROM employees WHERE e_id = emp_id;
END;
    
-- calling the above stored procedure
DECLARE
    input NUMBER(6);
    results VARCHAR2(100);
BEGIN
    input := 11;
    get_name(input, results);
    DBMS_OUTPUT.PUT_LINE(results);
END;
    
/*
    CURSORS!!! (:
    - a curser is basically a pointer to a table or view
    - we can use them to iterate through queries
    
    -Theres CURSOR and SYS_REFCURSOR
        - SYS_REFCURSOR is stronger (more costly), able to be passed
        outside of the scope of the procedure in which it is created. 
        - CURSORs are created and then die within the scope of the 
        procedure they are created in.
 */

CREATE OR REPLACE PROCEDURE get_all_employees(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursorParam
    FOR
        SELECT * FROM employees;
END;
    
DECLARE
    my_cursor SYS_REFCURSOR;
    emp_id employees.e_id%TYPE; -- sets emp_id to the datatype of e_id
    emp_name employees.e_name%TYPE;
    emp_sal employees.e_salary%TYPE;
    emp_title employees.e_title%TYPE;
BEGIN
    get_all_employees(my_cursor);
    LOOP
        FETCH my_cursor INTO emp_id, emp_name, emp_sal, emp_title;
        EXIT WHEN my_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(emp_id || ' ' || emp_name || ' ' || emp_sal || ' ' || emp_title);
    END LOOP;
END;
    
    
/* 
    Functions
    - must return ONE and only ONE resource.
    - can use OUT params, but they shouldn't
    - cannot perform DML operations
    - CAN be called mid-query
    - functions can call other functions.
    - functions CANNOT call stored procedures.
*/

CREATE OR REPLACE FUNCTION get_max_id
RETURN NUMBER --required!
IS
    max_id NUMBER;
BEGIN
    SELECT MAX(e_id) INTO max_id FROM employees;
    RETURN max_id;
END;

DECLARE
    max_id NUMBER;
BEGIN
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('Max employee id: ' || max_id);
END;
    
SELECT e_name FROM employees
WHERE e_id = get_max_id();

-- the equivalent of the above query without functions
SELECT e_name FROM employees
WHERE e_id = (SELECT MAX(e_id) FROM employees);