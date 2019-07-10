DROP TABLE UserType;
DROP TABLE BankUser;
DROP TABLE BankAccount;
-- Creating tables
CREATE TABLE UserType (
    user_type_id NUMBER PRIMARY KEY,
    user_type VARCHAR2(100)
);
/
CREATE TABLE BankUser (
    user_id NUMBER PRIMARY KEY,
    first_name VARCHAR2(100),
    last_name VARCHAR2(100) NOT NULL,
    date_of_birth DATE,
    user_type NUMBER CONSTRAINT user_user_type_fk REFERENCES UserType(user_type_id)
);
/
CREATE TABLE BankAccount (
    account_number NUMBER PRIMARY KEY,
    balance DECIMAL(8,2) DEFAULT 0.00,
    authorized_user NUMBER CONSTRAINT account_auth_user_fk REFERENCES BankUser(user_id)
);
/
CREATE SEQUENCE user_type_seq
START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE bank_user_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE bank_account_seq START WITH 1 INCREMENT BY 1;

