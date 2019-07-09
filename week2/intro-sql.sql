-- this is a single line comment
/*
 * this is a multiline comment
 */
-- DDL
CREATE TABLE trainee(
    trainee_id NUMBER,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birth_date DATE,
    major VARCHAR(100) DEFAULT 'Computer Science'
);

-- ALTER TABLE trainee RENAME TO student;
ALTER TABLE trainee
ADD favorite_color VARCHAR(20);
-- ALTER TABLE trainee MODIFY favorite_color NUMBER;
ALTER TABLE trainee
DROP COLUMN favorite_color;

/*
 *  DML
 */
-- insert some values into our trainee table
INSERT INTO trainee VALUES (1, 'Dan', 'Pickles', '01-jan-70', 'Math');
INSERT INTO trainee (trainee_id, first_name, last_name, birth_date)
VALUES (2, 'Minnie', 'Mouse', '01-jan-45');

-- update some rows
UPDATE trainee
SET major = 'English', birth_date = '01-jan-01';-- this updates ALL rows

-- to only update rows with first_name = 'Dan'
UPDATE trainee
SET major = 'English'
WHERE first_name = 'Dan';

-- to delete rows
DELETE FROM trainee; -- this deletes ALL ROWS in trainee
-- essentially equivalent to TRUNCATE
DELETE FROM trainee
WHERE first_name = 'Minnie'; --deletes rows that match criteria

-- DDL
--DROP TABLE trainee;
TRUNCATE TABLE trainee;