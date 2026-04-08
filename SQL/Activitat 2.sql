CREATE OR REPLACE TYPE Bicicleta AS OBJECT (
	-- Atributs de Bicicleta
	marca VARCHAR2(30),
	modelo VARCHAR2(60),
	color VARCHAR2(30),
	roda_d VARCHAR2(1), -- R radial, L lenticular
	roda_t VARCHAR2(1), -- R radial, L lenticular
	frens_m VARCHAR2(30),
	frens_t VARCHAR2(1), -- D discs, T tambor, C contrapedal
	pinyons NUMBER(2),
	plats NUMBER(2)
);

DESC Bicicleta -- Petita descripció de l'objecte

ALTER TYPE Bicicleta ADD ATTRIBUTE matricula VARCHAR2(10);

ALTER TYPE Bicicleta MODIFY ATTRIBUTE matricula VARCHAR2(12);
