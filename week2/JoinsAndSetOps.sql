DROP TABLE table_A;
DROP TABLE table_B;
-- Create super simple tables
CREATE TABLE table_A (
    nums NUMBER(6),
    chars VARCHAR2(10)
);

CREATE TABLE table_B (
    nums NUMBER(6),
    otherchars VARCHAR2(10)
);

-- Insert some data
INSERT ALL
INTO table_A
VALUES (1, 'a')
INTO table_A
VALUES (2, 'b')
INTO table_A
VALUES (3, 'c')
INTO table_A
VALUES (4, 'd')
SELECT * FROM DUAL; -- this is just part of the INSERT ALL syntax

INSERT ALL
INTO table_B
VALUES (3, 'C')
INTO table_B
VALUES (4, 'D')
INTO table_B
VALUES (5, 'E')
INTO table_B
VALUES (6, 'F')
INTO table_B
VALUES (7, 'G')
SELECT * FROM DUAL;

/* JOIN Examples */
SELECT * FROM table_A;
SELECT * FROM table_B;
-- INNER JOIN
SELECT * 
FROM table_A 
    INNER JOIN table_B
    ON table_A.nums = table_B.nums
;

-- LEFT JOIN
SELECT *
FROM table_A a
    LEFT JOIN table_B b
    ON a.nums = b.nums
ORDER BY a.nums
;

-- RIGHT JOIN
SELECT *
FROM table_A a
    RIGHT JOIN table_B b
    ON a.nums = b.nums
ORDER BY a.nums NULLS FIRST
;

-- FULL OUTER JOIN
SELECT *
FROM table_A a 
    FULL OUTER JOIN table_B b
    ON a.nums = b.nums
;

SELECT *
FROM table_A a 
    FULL JOIN table_B b -- same as using FULL OUTER JOIN
    ON a.nums = b.nums
;

-- CROSS JOIN
SELECT *
FROM table_A 
    CROSS JOIN table_B
;

-- alternative syntax for CROSS JOIN
SELECT * FROM table_A, table_B;

-- SELF JOIN
CREATE TABLE emps (
    emp_id NUMBER(6) PRIMARY KEY,
    e_name VARCHAR2(100),
    super_id NUMBER (6),
    CONSTRAINT super_fk 
        FOREIGN KEY (super_id) 
        REFERENCES emps(emp_id)
);

INSERT ALL INTO emps
VALUES (1, 'Bobby', null)
INTO emps
VALUES (2, 'Ryan', 1)
INTO emps
VALUES (3, 'Bobbert', 2)
INTO emps
VALUES (4, 'Bob', 2)
INTO emps
VALUES (5, 'Rob', 2)
SELECT * FROM DUAL;

SELECT * FROM emps;
-- find out how many people report to each employee
SELECT a.e_name, COUNT(a.emp_id)
FROM emps a INNER JOIN emps b
    ON a.emp_id = b.super_id
GROUP BY a.e_name
;