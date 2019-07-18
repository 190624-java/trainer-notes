-- DROP TABLE Hero;
-- Table and table setup
CREATE TABLE Hero(
    hero_id NUMBER PRIMARY KEY,
    hero_name VARCHAR2(100),
    hero_level NUMBER,
    hero_class VARCHAR2(30)
);
/
CREATE SEQUENCE hero_id_seq
START WITH 1 INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER hero_id_trigger
BEFORE INSERT ON Hero
FOR EACH ROW
BEGIN
    SELECT hero_id_seq.nextVal INTO :new.hero_id FROM Dual;
END;
/



