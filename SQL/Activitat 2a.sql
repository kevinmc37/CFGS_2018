CREATE OR REPLACE TYPE Usuari AS OBJECT (
	login VARCHAR2(10),
	nom VARCHAR2(35),
	cognoms VARCHAR2(40),
	localitat VARCHAR2(50),
	codi_postal VARCHAR2(5),
	credit NUMBER,
	-- Setters
	MEMBER PROCEDURE set_login(login VARCHAR2),
	MEMBER PROCEDURE set_nom(nom VARCHAR2),
	MEMBER PROCEDURE set_cognoms(cognoms VARCHAR2),
	MEMBER PROCEDURE set_localitat(localitat VARCHAR2),
	MEMBER PROCEDURE set_codi_postal(codi_postal VARCHAR2),
	MEMBER PROCEDURE increment_credit(inc NUMBER),
	-- Getters
	MEMBER FUNCTION get_nom_sencer RETURN VARCHAR2,
	MEMBER FUNCTION get_credit RETURN NUMBER
);

CREATE OR REPLACE TYPE BODY Usuari AS
	MEMBER PROCEDURE set_login(login VARCHAR2) IS
	BEGIN
		SELF.login := login;
	END set_login;
	MEMBER PROCEDURE set_nom(nom VARCHAR2) IS
	BEGIN
		SELF.nom := nom;
	END set_nom;
	MEMBER PROCEDURE set_cognoms(cognoms VARCHAR2) IS
	BEGIN
		SELF.cognoms := cognoms;
	END set_cognoms;
	MEMBER PROCEDURE set_localitat(localitat VARCHAR2) IS
	BEGIN
		SELF.localitat := localitat;
	END set_localitat;
	MEMBER PROCEDURE set_codi_postal(codi_postal VARCHAR2) IS
	BEGIN
		SELF.codi_postal := codi_postal;
	END set_codi_postal;
	MEMBER PROCEDURE increment_credit(inc NUMBER) IS
	BEGIN
		credit := credit + inc;
	END increment_credit;
	MEMBER FUNCTION get_nom_sencer RETURN VARCHAR2 IS
	BEGIN
		RETURN SELF.nom || ' ' || SELF.cognoms;
	END get_nom_sencer;
	MEMBER FUNCTION get_credit RETURN NUMBER IS
	BEGIN
		RETURN SELF.credit;
	END get_credit;
END;

SET SERVEROUTPUT ON
DECLARE
	usu Usuari;
BEGIN
	usu := NEW Usuari('BobE', 'Bob', 'Esponja', 'Torelló', '08570', 20);
	SYS.DBMS_OUTPUT.PUT_LINE('Usuari: ' || usu.get_nom_sencer());
	SYS.DBMS_OUTPUT.PUT_LINE('Credit: ' || usu.get_credit());
	usu.increment_credit(100);
	usu.set_nom('Roberto');
	SYS.DBMS_OUTPUT.PUT_LINE('Usuari: ' || usu.get_nom_sencer());
	SYS.DBMS_OUTPUT.PUT_LINE('Credit: ' || usu.get_credit());
END;
