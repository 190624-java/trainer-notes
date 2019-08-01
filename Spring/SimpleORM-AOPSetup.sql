CREATE TABLE Spring_User (
    user_id NUMBER PRIMARY KEY,
    user_role NUMBER,
    user_full_name VARCHAR2(100),
    user_email VARCHAR2(100)
);
/
CREATE TABLE Spring_Batch (
    batch_id NUMBER PRIMARY KEY,
    batch_start_date DATE,
    batch_length NUMBER(2),
    batch_track VARCHAR2(50),
    batch_trainer NUMBER CONSTRAINT trainer_fk REFERENCES Spring_User(user_id)
);
/
CREATE TABLE Spring_Associate (
    associate_id NUMBER PRIMARY KEY,
    associate_name VARCHAR2(100),
    associate_email VARCHAR2(100),
    associate_batch NUMBER CONSTRAINT batch_fk REFERENCES Spring_Batch(batch_id)
);
/