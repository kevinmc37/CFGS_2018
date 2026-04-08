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
	DNI 	VARCHAR(10) UNIQUE,
	CONSTRAINT pk_PATIENT PRIMARY KEY (Pat_Number)
    );


CREATE TABLE VISIT
  (
    Doc_Number    INTEGER,
    Pat_Number    INTEGER,
    Visit_Date    DATE,
    Price	  DECIMAL(7,2),
    CONSTRAINT Visit_pk PRIMARY KEY (Doc_Number, Pat_Number, Visit_Date),
    CONSTRAINT ck_Price CHECK (Price >0),
    CONSTRAINT Visit_Doctor_fk FOREIGN KEY (Doc_Number) REFERENCES DOCTOR(Doc_Number),
    CONSTRAINT Visit_PATIENT_fk FOREIGN KEY (Pat_Number) REFERENCES PATIENT(Pat_Number)
  );


CREATE TABLE PRESCRIPTION
  (
    Presc_Number	INTEGER,
    Drug		VARCHAR(50) NOT NULL,
    Doc_Number		INTEGER NOT NULL,
    Pat_Number		INTEGER NOT NULL,
    Visit_Date		DATE NOT NULL,
    CONSTRAINT Prescription_pk PRIMARY KEY (Presc_Number),
    CONSTRAINT Prescription_Visit_fk FOREIGN KEY (Doc_Number, Pat_Number, Visit_Date) REFERENCES VISIT(Doc_Number, Pat_Number, Visit_Date)
  );

CREATE TABLE DRUGS_SUMMARY
(
	Drug		VARCHAR(50),
	Year    			INTEGER,
	Acum_Drugs		INTEGER,
	Acum_Pat		INTEGER,
	Acum_Doc		INTEGER,
	Max_Pat		INTEGER,
	Max_Doc		INTEGER,
	CONSTRAINT ck_Acum_Drugs CHECK (Acum_Drugs >0),
	CONSTRAINT ck_Acum_Pat CHECK (Acum_Pat >0),
	CONSTRAINT ck_Acum_Doc CHECK (Acum_Doc >0),
	CONSTRAINT Drugs_Summary_pk PRIMARY KEY (Drug,	Year),
	CONSTRAINT Summary_Doctor_fk FOREIGN KEY (Max_Doc) REFERENCES DOCTOR(Doc_Number),
	CONSTRAINT Summary_PATIENT_fk FOREIGN KEY (Max_Pat) REFERENCES PATIENT(Pat_Number)
);


COMMIT;
