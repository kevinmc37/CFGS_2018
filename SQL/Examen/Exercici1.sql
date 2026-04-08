-- Apartat 1
CREATE OR REPLACE TYPE CircuitObj AS OBJECT (
    codi NUMBER,
    nom VARCHAR2(20),
    ciutat VARCHAR2(30),
    pais VARCHAR2(20),
    longitud NUMBER(5, 2)
);

-- Apartat 2
CREATE OR REPLACE TYPE CursaObj AS OBJECT (
    temporada NUMBER,
    numCursa NUMBER,
    circuit NUMBER,
    data DATE
);

-- Apartat 3
ALTER TYPE CircuitObj DROP ATTRIBUTE ciutat;

ALTER TYPE CircuitObj
    ADD ATTRIBUTE revoltsE NUMBER,
    ADD ATTRIBUTE revoltsD NUMBER;

-- Apartat 4
CREATE OR REPLACE TYPE PilotObj AS OBJECT (
    nom VARCHAR2(20),
    cognom VARCHAR(30),
    dataNaix DATE,
    nacionalitat VARCHAR2(20),
    numero NUMBER
);

-- Apartat 5
ALTER TYPE PilotObj ADD MEMBER FUNCTION getEdat RETURN NUMBER;

-- Apartat 6
ALTER TYPE PilotObj ADD MEMBER FUNCTION potParticipar(categoria NUMBER) RETURN BOOLEAN;

CREATE OR REPLACE TYPE BODY PilotObj AS
    MEMBER FUNCTION getEdat RETURN NUMBER IS
    dataActual DATE;
    BEGIN
	SELECT SYSDATE INTO dataActual FROM DUAL;
	RETURN FLOOR(MONTHS_BETWEEN(dataActual, SELF.dataNaix) / 12);
    END getEdat;
    MEMBER FUNCTION potParticipar(categoria NUMBER) RETURN BOOLEAN IS
    edat NUMBER;
    BEGIN
        edat := SELF.getEdat();
        IF ((categoria = 1 OR categoria = 2) AND edat >= 16) THEN
            RETURN TRUE;
        ELSIF (categoria = 3 AND edat >= 18) THEN
            RETURN TRUE;
        ELSE
            RETURN FALSE;
        END IF;
    END potParticipar;
END;

-- Apartat 7
CREATE TABLE CircuitObjTbl OF CircuitObj;

ALTER TABLE CircuitObjTbl ADD CONSTRAINT pk_codi PRIMARY KEY (codi);

-- Apartat 8
CREATE TABLE PilotEscuderiaTbl (
    codi NUMBER,
    pilot PilotObj,
    escuderia VARCHAR2(30),
    categoria NUMBER
);
