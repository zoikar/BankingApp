-- Database: BankingApplication
DROP DATABASE IF EXISTS BankingApplication;
DROP TABLE IF EXISTS CardInfo CASCADE;
DROP TABLE IF EXISTS AccountInfo CASCADE;

CREATE DATABASE BankingApplication
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1253'
    LC_CTYPE = 'English_United States.1253'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
CREATE TABLE AccountInfo(
	accnum INT,
	fname varchar(100),
	lname varchar(100),
	mobile varchar(10),
	id varchar(20),
	ssn varchar(9),
	address varchar(100),
	email varchar(100),
	password varchar(100),
	primary key(accnum)
);

CREATE TABLE CardInfo(
	accnum int,
	cardnum varchar(16),
	expmonth int,
	expyear int,
	cvv int,
	pin int,
	balance float,
	primary key(cardnum),
	FOREIGN KEY (accnum) REFERENCES AccountInfo (accnum)
);



SELECT * FROM AccountInfo;
SELECT * FROM CardInfo;
