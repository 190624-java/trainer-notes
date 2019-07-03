-- Table creation
CREATE TABLE cave (
    cave_id INTEGER PRIMARY KEY,
    cave_name VARCHAR(100),
    max_bears INTEGER DEFAULT 4
);

CREATE TABLE bear_type (
    bear_type_id INTEGER PRIMARY KEY,
    bear_type_name VARCHAR(100)
);

CREATE TABLE bear (
    bear_id INTEGER PRIMARY KEY,
    bear_name VARCHAR(100),
    bear_weight NUMBER(5,2) DEFAULT 200.00,
    bear_type_id INTEGER CONSTRAINT fk_bear_type REFERENCES bear_type,
    cave_id INTEGER
);

ALTER TABLE bear
ADD CONSTRAINT fk_bear_cave
FOREIGN KEY (cave_id) REFERENCES cave(cave_id);

-- Adding data
INSERT INTO bear_type VALUES (1, 'Grizzly');
INSERT INTO bear_type VALUES (2, 'Polar');

INSERT ALL INTO cave
VALUES (1, 'Awesome Cave 1', 10)
INTO cave(cave_id, cave_name)
VALUES (2, 'Awesome Cave 2')
SELECT *  FROM DUAL;
    
INSERT ALL INTO bear
VALUES (1, 'Dan', 201.00, 1, 1)
INTO bear
VALUES (2, 'Minnie', 180.50, 1, 1)
INTO bear
VALUES (3, 'Donald', 200.00, 2, 2)
SELECT * FROM DUAL;
    
-- Query our data!  

-- simple select statement
SELECT * FROM bear;
SELECT bear_name FROM bear;

-- filter the rows that are returned
-- select all bears from cave 1
SELECT * FROM bear
WHERE cave_id = 1;
    
SELECT * FROM bear
WHERE cave_id = 1
ORDER BY bear_weight DESC;

SELECT BEAR_ID ,
BEAR_NAME AS name,
BEAR_WEIGHT ,
BEAR_TYPE_ID ,
CAVE_ID  FROM bear;
    
/*
 * Functions:
 *      Scalar functions - return a row for every queried row.
 *              - operate on a single row.
 *              - ex. CONCAT - can be used to concatenate two columns
 *      Aggregate functions - return a row for each group of rows
 *              - operate on groups of rows.
 *              - ex. COUNT, AVERAGE, etc.
 */

-- example
SELECT bear_id, CONCAT(bear_name, '!') AS bearname, bear_weight 
FROM bear; -- scalar

SELECT COUNT(bear_id) FROM bear; -- returns # of bears in the table

-- find out how many bears are in cave 1
SELECT COUNT(bear_id) FROM bear
WHERE cave_id = 1;

-- find out how many bears are in each cave.
SELECT cave_id, COUNT(bear_id) 
FROM bear
GROUP BY cave_id;
 
-- fields returned must be grouped by or aggregated if there is a 
--group by clause or aggregate function being used.
SELECT cave_id, COUNT(bear_id), bear_name 
FROM bear
GROUP BY cave_id, bear_name;

-- find the average weight of bears in a cave
SELECT cave_id, AVG(bear_weight)
FROM bear
GROUP BY cave_id;

-- if we want to be able to filter rows returned by
-- the value of an aggregate function, we have to use the HAVING clause

-- which caves have an avg weight of less than 200
SELECT cave_id, AVG(bear_weight)
FROM bear
GROUP BY cave_id
HAVING AVG(bear_weight) < 200;
 
