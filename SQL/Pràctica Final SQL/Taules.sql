DROP SCHEMA IF EXISTS ubd_20151 CASCADE;
CREATE SCHEMA ubd_20151 AUTHORIZATION postgres;
GRANT ALL ON SCHEMA ubd_20151 TO postgres;

SET search_path TO ubd_20151;

BEGIN WORK;
SET TRANSACTION READ WRITE;

SET datestyle = YMD;

-- Creació de taules


CREATE TABLE DOCTOR
  (
    Doc_Number INTEGER,
    Name	VARCHAR(50) NOT NULL,
    Specialty	VARCHAR(50) NOT NULL,
    Address	VARCHAR(50) NOT NULL,
    City	VARCHAR(30) NOT NULL,
    Phone	VARCHAR(10) NOT NULL,
    Salary	DECIMAL(8,2) NOT NULL,
    DNI		VARCHAR(10) UNIQUE,
    CONSTRAINT pk_Doctor PRIMARY KEY (Doc_Number),
    CONSTRAINT ck_Salary CHECK (Salary >0)
  );

CREATE TABLE PATIENT
  (
    Pat_Number	INTEGER,
    Name	VARCHAR(50) NOT NULL,
    Address     VARCHAR(50) NOT NULL,
    City        VARCHAR(30) NOT NULL,
    DNI 			 VARCHAR(10) UNIQUE,
    CONSTRAINT pk_PATIENT PRIMARY KEY (Pat_Number),
    CONSTRAINT ck_Pat_Number CHECK (Pat_Number >= 10000 AND Pat_Number <= 10000000)
    );

CREATE TABLE VISIT
  (
    Doc_Number	INTEGER NOT NULL,
    Pat_Number	INTEGER NOT NULL,
    Visit_Date	DATE NOT NULL,
    Price	DECIMAL(8,2) NOT NULL,
    CONSTRAINT pk_VISIT PRIMARY KEY (Doc_Number, Pat_Number, Visit_Date),
    CONSTRAINT VISIT_DOCTOR_fk FOREIGN KEY (Doc_Number) REFERENCES DOCTOR(Doc_Number),
    CONSTRAINT VISIT_PATIENT_fk FOREIGN KEY (Pat_Number) REFERENCES PATIENT(Pat_Number),
    CONSTRAINT ck_Price CHECK (Price > 0),
    CONSTRAINT ck_Pat_Number CHECK (Pat_Number >= 10000 AND Pat_Number <= 10000000)
    );

CREATE TABLE PRESCRIPTION 
  ( 
    Presc_Number    INTEGER, 
    Drug             VARCHAR(50) NOT NULL, 
    Doc_Number        INTEGER NOT NULL, 
    Pat_Number        INTEGER NOT NULL, 
    Visit_Date        DATE NOT NULL, 
    CONSTRAINT Prescription_pk PRIMARY KEY (Presc_Number), 
    CONSTRAINT Prescription_VISIT_fk FOREIGN KEY (Doc_Number, Pat_Number, Visit_Date) REFERENCES VISIT(Doc_Number, Pat_Number, Visit_Date),
    CONSTRAINT ck_Pat_Number CHECK (Pat_Number >= 10000 AND Pat_Number <= 10000000)
  ); 






COMMIT;
