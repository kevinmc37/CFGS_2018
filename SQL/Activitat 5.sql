CREATE OR REPLACE TYPE Adressa2 AS OBJECT (
	carrer VARCHAR2(50),
	ciutat VARCHAR2(50),
	cp VARCHAR2(5)
);

CREATE OR REPLACE TYPE Client AS OBJECT (
	cli_num NUMBER,
	cli_nom VARCHAR2(50),
	adressa ADRESSA2,
	telefon VARCHAR2(13)
);

CREATE TABLE Clients OF Client;

ALTER TABLE Clients ADD CONSTRAINT pk_cli_num PRIMARY KEY (cli_num);

CREATE TABLE Comandes (
	ord_num NUMBER,
	cli_num NUMBER,
	adressa ADRESSA2,
	CONSTRAINT pk_ord_num PRIMARY KEY (ord_num)
);
