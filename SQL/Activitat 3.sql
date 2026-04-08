CREATE OR REPLACE TYPE Adressa AS OBJECT (
	carrer VARCHAR2(50),
	cp VARCHAR2(5),
	poblacio VARCHAR2(50),
	provincia VARCHAR2(20),
	-- Setters
	MEMBER PROCEDURE setCarrer(carrer VARCHAR2),
	MEMBER PROCEDURE setCp(cp VARCHAR2),
	MEMBER PROCEDURE setPoblacio(poblacio VARCHAR2),
	MEMBER PROCEDURE setProvincia(provincia VARCHAR2),
	-- Getters
	MEMBER FUNCTION getCarrer RETURN VARCHAR2,
	MEMBER FUNCTION getCp RETURN VARCHAR2,
	MEMBER FUNCTION getPoblacio RETURN VARCHAR2,
	MEMBER FUNCTION getProvincia RETURN VARCHAR2
);

CREATE OR REPLACE TYPE Persona AS OBJECT (
	ident NUMBER,
	nif VARCHAR2(9),
	nom VARCHAR2(15),
	cognom1 VARCHAR2(15),
	cognom2 VARCHAR2(15),
	dataNaixement DATE,
	-- Setters
	MEMBER PROCEDURE setIdent(ident NUMBER),
	MEMBER PROCEDURE setNif(nif VARCHAR2),
	MEMBER PROCEDURE setNom(nom VARCHAR2),
	MEMBER PROCEDURE setCognom1(cognom1 VARCHAR2),
	MEMBER PROCEDURE setCognom2(cognom2 VARCHAR2),
	MEMBER PROCEDURE setDataNaixement(dataNaixement DATE),
	-- Getters
	MEMBER FUNCTION getIdent RETURN NUMBER,
	MEMBER FUNCTION getNif RETURN VARCHAR2,
	MEMBER FUNCTION getNom RETURN VARCHAR2,
	MEMBER FUNCTION getCognom1 RETURN VARCHAR2,
	MEMBER FUNCTION getCognom2 RETURN VARCHAR2,
	MEMBER FUNCTION getDataNaixement RETURN DATE,
	MEMBER FUNCTION mostrarNomSencer RETURN VARCHAR2,
	MEMBER FUNCTION mostrarEdat RETURN NUMBER
);

CREATE OR REPLACE TYPE BODY Adressa AS
	MEMBER PROCEDURE setCarrer(carrer VARCHAR2) IS
	BEGIN
		SELF.carrer := carrer;
	END setCarrer;
	MEMBER PROCEDURE setCp(cp VARCHAR2) IS
	BEGIN
		SELF.cp := cp;
	END setCp;
	MEMBER PROCEDURE setPoblacio(poblacio VARCHAR2) IS
	BEGIN
		SELF.poblacio := poblacio;
	END setPoblacio;
	MEMBER PROCEDURE setProvincia(provincia VARCHAR2) IS
	BEGIN
		SELF.provincia := provincia;
	END setProvincia;
	MEMBER FUNCTION getCarrer RETURN VARCHAR2 IS
	BEGIN
		RETURN SELF.carrer;
	END getCarrer;
	MEMBER FUNCTION getCp RETURN VARCHAR2 IS
	BEGIN
		RETURN SELF.cp;
	END getCp;
	MEMBER FUNCTION getPoblacio RETURN VARCHAR2 IS
	BEGIN
		RETURN SELF.poblacio;
	END getPoblacio;
	MEMBER FUNCTION getProvincia RETURN VARCHAR2 IS
	BEGIN
		RETURN SELF.provincia;
	END getProvincia;
END;

CREATE OR REPLACE TYPE BODY Persona AS
	MEMBER PROCEDURE setIdent(ident NUMBER) IS
	BEGIN
		SELF.ident := ident;
	END setIdent;
	MEMBER PROCEDURE setNif(nif VARCHAR2) IS
	BEGIN
		SELF.nif := nif;
	END setNif;
	MEMBER PROCEDURE setNom(nom VARCHAR2) IS
	BEGIN
		SELF.nom := nom;
	END setNom;
	MEMBER PROCEDURE setCognom1(cognom1 VARCHAR2) IS
	BEGIN
		SELF.cognom1 := cognom1;
	END setCognom1;
	MEMBER PROCEDURE setCognom2(cognom2 VARCHAR2) IS
	BEGIN
		SELF.cognom2 := cognom2;
	END setCognom2;
	MEMBER PROCEDURE setDataNaixement(dataNaixement DATE) IS
	BEGIN
		SELF.dataNaixement := dataNaixement;
	END setDataNaixement;
	MEMBER FUNCTION getIdent RETURN NUMBER IS
	BEGIN
		RETURN SELF.ident;
	END getIdent;
	MEMBER FUNCTION getNif RETURN VARCHAR2 IS
	BEGIN
		RETURN SELF.nif;
	END getNif;
	MEMBER FUNCTION getNom RETURN VARCHAR2 IS
	BEGIN
		RETURN SELF.nom;
	END getNom;
	MEMBER FUNCTION getCognom1 RETURN VARCHAR2 IS
	BEGIN
		RETURN SELF.cognom1;
	END getCognom1;
	MEMBER FUNCTION getCognom2 RETURN VARCHAR2 IS
	BEGIN
		RETURN SELF.cognom2;
	END getCognom2;
	MEMBER FUNCTION getDataNaixement RETURN DATE IS
	BEGIN
		RETURN SELF.dataNaixement;
	END getDataNaixement;
	MEMBER FUNCTION mostrarNomSencer RETURN VARCHAR2 IS
	BEGIN
		RETURN SELF.nom || ' ' || SELF.cognom1 || ' ' || SELF.cognom2;
	END mostrarNomSencer;
	MEMBER FUNCTION mostrarEdat RETURN NUMBER IS
	dataActual DATE;
	BEGIN
		SELECT SYSDATE INTO dataActual FROM DUAL;
		RETURN FLOOR(MONTHS_BETWEEN(dataActual, SELF.dataNaixement) / 12);
	END mostrarEdat;
END;

SET SERVEROUTPUT ON;
DECLARE
	adres Adressa;
	pers Persona;
BEGIN
	adres := NEW Adressa('CarrerXulo', '08389', 'PoblacioXula', 'ProvinciaXula');
	adres.setCarrer('NouCarrer');
	SYS.DBMS_OUTPUT.PUT_LINE('Carrer: ' || adres.getCarrer());
	SYS.DBMS_OUTPUT.PUT_LINE('Codi postal: ' || adres.getCp());
	SYS.DBMS_OUTPUT.PUT_LINE('Població: ' || adres.getPoblacio());
	SYS.DBMS_OUTPUT.PUT_LINE('Província: ' || adres.getProvincia());
	pers := NEW Persona(1, '47853870R', 'Kevin', 'Morales', 'Cano', '05/04/1997');
	pers.setNom('Blablabla');
	SYS.DBMS_OUTPUT.PUT_LINE('Identificació: ' || pers.getIdent());
	SYS.DBMS_OUTPUT.PUT_LINE('DNI: ' || pers.getNif());
	SYS.DBMS_OUTPUT.PUT_LINE('Nom: ' || pers.getNom());
	SYS.DBMS_OUTPUT.PUT_LINE('1r cognom: ' || pers.getCognom1());
	SYS.DBMS_OUTPUT.PUT_LINE('2n cognom: ' || pers.getCognom2());
	SYS.DBMS_OUTPUT.PUT_LINE('Data de naixement: ' || pers.getDataNaixement());
	SYS.DBMS_OUTPUT.PUT_LINE('Nom sencer: ' || pers.mostrarNomSencer());
	SYS.DBMS_OUTPUT.PUT_LINE('Edat: ' || pers.mostrarEdat());
END;
