-- NOT FINAL = poden heretar. NOT INSTANTIABLE = abstracte
CREATE OR REPLACE TYPE Poligon AS OBJECT (
	numCostats NUMBER(3, 0),
	MEMBER FUNCTION getNumCostats RETURN NUMBER,
	NOT INSTANTIABLE MEMBER FUNCTION getArea RETURN NUMBER,
	NOT INSTANTIABLE MEMBER FUNCTION getPerimetre RETURN NUMBER,
	ORDER MEMBER FUNCTION ordenarArea(pol Poligon) RETURN INTEGER
) NOT FINAL NOT INSTANTIABLE;

CREATE OR REPLACE TYPE BODY Poligon AS
	MEMBER FUNCTION getNumCostats RETURN NUMBER IS
	BEGIN
		RETURN SELF.numCostats;
	END getNumCostats;
	ORDER MEMBER FUNCTION ordenarArea(pol Poligon) RETURN INTEGER IS
	BEGIN
		IF SELF.getArea() - pol.getArea() > 0 THEN
			RETURN 1;
		ELSIF SELF.getArea() - pol.getArea() < 0 THEN
			RETURN -1;
		ELSE
			RETURN 0;
		END IF;
	END ordenarArea;
END;

CREATE OR REPLACE TYPE Triangle UNDER Poligon (
	base NUMBER,
	altura NUMBER,
	CONSTRUCTOR FUNCTION Triangle(base NUMBER, altura NUMBER) RETURN SELF AS RESULT,
	OVERRIDING MEMBER FUNCTION getNumCostats RETURN NUMBER,
	OVERRIDING MEMBER FUNCTION getArea RETURN NUMBER,
	OVERRIDING MEMBER FUNCTION getPerimetre RETURN NUMBER
);

CREATE OR REPLACE TYPE BODY Triangle AS
	CONSTRUCTOR FUNCTION Triangle(base NUMBER, altura NUMBER) RETURN SELF AS RESULT IS
	BEGIN
		numCostats := 3;
		SELF.base := abs(base);
		SELF.altura := abs(altura);
		RETURN;
	END Triangle;
	OVERRIDING MEMBER FUNCTION getNumCostats RETURN NUMBER IS
	BEGIN
		RETURN 3;
	END getNumCostats;
	OVERRIDING MEMBER FUNCTION getArea RETURN NUMBER IS
	BEGIN
		RETURN SELF.base * SELF.altura / 2;
	END getArea;
	OVERRIDING MEMBER FUNCTION getPerimetre RETURN NUMBER IS
	hipotenusa NUMBER;
	BEGIN
		/* Suposarem que el triangle és issòscel·les.
		Tenim la base per un costat, l’altura per un altre.
		Per tant, un dels costats iguals del triangle es pot
		calcular aplicant el teorema de Pitàgores */

		hipotenusa := sqrt(power(SELF.base / 2, 2) + power(SELF.altura, 2));
		RETURN SELF.base + 2 * hipotenusa;

		-- Ja que estem en quaresma, fem un gran acte de fe
	END getPerimetre;
END;

DECLARE
	tri1 Triangle;
	tri2 Triangle;
BEGIN
	tri1 := new Triangle(-3, 7);
	tri2 := new Triangle(-33, 77);
	DBMS_OUTPUT.PUT_LINE('Costats1: ' || tri1.getNumCostats());
	DBMS_OUTPUT.PUT_LINE('Àrea1: ' || tri1.getArea());
	DBMS_OUTPUT.PUT_LINE('Perímetre1: ' || tri1.getPerimetre());
	DBMS_OUTPUT.PUT_LINE('Costats2: ' || tri2.getNumCostats());
	DBMS_OUTPUT.PUT_LINE('Àrea2: ' || tri2.getArea());
	DBMS_OUTPUT.PUT_LINE('Perímetre2: ' || tri2.getPerimetre());
	DBMS_OUTPUT.PUT_LINE('Ordenació: ' || tri1.ordenarArea(tri2));
END;

CREATE OR REPLACE TYPE Quadrilater UNDER Poligon (
	OVERRIDING MEMBER FUNCTION getNumCostats RETURN NUMBER,
	OVERRIDING NOT INSTANTIABLE MEMBER FUNCTION getArea RETURN NUMBER,
	OVERRIDING NOT INSTANTIABLE MEMBER FUNCTION getPerimetre RETURN NUMBER
) NOT FINAL NOT INSTANTIABLE;

CREATE OR REPLACE TYPE BODY Quadrilater AS
	OVERRIDING MEMBER FUNCTION getNumCostats RETURN NUMBER IS
	BEGIN
		RETURN 4;
	END getNumCostats;
END;

CREATE OR REPLACE TYPE Rectangle UNDER Quadrilater (
	base NUMBER,
	altura NUMBER,
	CONSTRUCTOR FUNCTION Rectangle RETURN SELF AS RESULT,
	CONSTRUCTOR FUNCTION Rectangle(base NUMBER, altura NUMBER) RETURN SELF AS RESULT,
	OVERRIDING MEMBER FUNCTION getArea RETURN NUMBER,
	OVERRIDING MEMBER FUNCTION getPerimetre RETURN NUMBER
);

CREATE OR REPLACE TYPE BODY Rectangle AS
	CONSTRUCTOR FUNCTION Rectangle RETURN SELF AS RESULT IS
	BEGIN
		SELF.base := 3;
		SELF.altura := 2;
		RETURN;
	END Rectangle;
	CONSTRUCTOR FUNCTION Rectangle(base NUMBER, altura NUMBER) RETURN SELF AS RESULT IS
	BEGIN
		SELF.base := abs(base);
		SELF.altura := abs(altura);
		RETURN;
	END Rectangle;
	OVERRIDING MEMBER FUNCTION getArea RETURN NUMBER IS
	BEGIN
		RETURN SELF.base * SELF.altura;
	END getArea;
	OVERRIDING MEMBER FUNCTION getPerimetre RETURN NUMBER IS
	BEGIN
		RETURN base*2 + altura*2;
	END getPerimetre;
END;

DECLARE
	rec1 Rectangle;
	rec2 Rectangle;
BEGIN
	rec1 := new Rectangle(-7, 3);
	rec2 := new Rectangle();
	DBMS_OUTPUT.PUT_LINE('Costats1: ' || rec1.getNumCostats());
	DBMS_OUTPUT.PUT_LINE('Àrea1: ' || rec1.getArea());
	DBMS_OUTPUT.PUT_LINE('Perímetre1: ' || rec1.getPerimetre());
	DBMS_OUTPUT.PUT_LINE('Costats2: ' || rec2.getNumCostats());
	DBMS_OUTPUT.PUT_LINE('Àrea2: ' || rec2.getArea());
	DBMS_OUTPUT.PUT_LINE('Perímetre2: ' || rec2.getPerimetre());
	DBMS_OUTPUT.PUT_LINE('Ordenació: ' || rec1.ordenarArea(rec2));
END;

CREATE OR REPLACE TYPE Quadrat UNDER Quadrilater (
	costat NUMBER,
	CONSTRUCTOR FUNCTION Quadrat RETURN SELF AS RESULT,
	CONSTRUCTOR FUNCTION Quadrat(costat NUMBER) RETURN SELF AS RESULT,
	OVERRIDING MEMBER FUNCTION getArea RETURN NUMBER,
	OVERRIDING MEMBER FUNCTION getPerimetre RETURN NUMBER
);

CREATE OR REPLACE TYPE BODY Quadrat AS
	CONSTRUCTOR FUNCTION Quadrat RETURN SELF AS RESULT IS
	BEGIN
		SELF.costat := 3;
		RETURN;
	END Quadrat;
	CONSTRUCTOR FUNCTION Quadrat(costat NUMBER) RETURN SELF AS RESULT IS
	BEGIN
		SELF.costat := abs(costat);
		RETURN;
	END Quadrat;
	OVERRIDING MEMBER FUNCTION getArea RETURN NUMBER IS
	BEGIN
		RETURN power(SELF.costat, 2);
	END getArea;
	OVERRIDING MEMBER FUNCTION getPerimetre RETURN NUMBER IS
	BEGIN
		RETURN SELF.costat * 4;
	END getPerimetre;
END;

DECLARE
	quad1 Quadrat;
	quad2 Quadrat;
BEGIN
	quad1 := new Quadrat(-5);
	quad2 := new Quadrat();
	DBMS_OUTPUT.PUT_LINE('Costats1: ' || quad1.getNumCostats());
	DBMS_OUTPUT.PUT_LINE('Àrea1: ' || quad1.getArea());
	DBMS_OUTPUT.PUT_LINE('Perímetre1: ' || quad1.getPerimetre());
	DBMS_OUTPUT.PUT_LINE('Costats2: ' || quad2.getNumCostats());
	DBMS_OUTPUT.PUT_LINE('Àrea2: ' || quad2.getArea());
	DBMS_OUTPUT.PUT_LINE('Perímetre2: ' || quad2.getPerimetre());
	DBMS_OUTPUT.PUT_LINE('Ordenació: ' || quad1.ordenarArea(quad2));
END;
