-- Apartat 1
INSERT INTO Categories VALUES(1, 'Moto3', 250, 16);
INSERT INTO Categories VALUES(2, 'Moto2', 600, 16);
INSERT INTO Categories VALUES(3, 'MotoGP', 1000, 18);

-- Apartat 2
INSERT INTO Pilots VALUES('Andrea', 'Dovicioso', 1986, 'ITA', 4, (SELECT categ.idCat FROM Categories categ WHERE categ.nom = 'MotoGP'));
INSERT INTO Pilots VALUES('Marc', 'Marquez', 1993, 'ESP', 93, (SELECT categ.idCat FROM Categories categ WHERE categ.nom = 'MotoGP'));
INSERT INTO Pilots VALUES('Isaac', 'Viñales', 1993, 'ESP', 32, (SELECT categ.idCat FROM Categories categ WHERE categ.nom = 'Moto2'));
INSERT INTO Pilots VALUES('Tatsuki', 'Suzuki', 1997, 'JPN', 24, (SELECT categ.idCat FROM Categories categ WHERE categ.nom = 'Moto3'));

-- Apartat 3
INSERT INTO Escuderies VALUES('Ducati team', 'Ducati', (SELECT categ.idCat FROM Categories categ WHERE categ.nom = 'MotoGP'));
INSERT INTO Escuderies VALUES('Repsol Honda Team', 'Honda', (SELECT categ.idCat FROM Categories categ WHERE categ.nom = 'MotoGP'));
INSERT INTO Escuderies VALUES('SAG Team', 'Kalex', (SELECT categ.idCat FROM Categories categ WHERE categ.nom = 'Moto2'));
INSERT INTO Escuderies VALUES('SIC58 Squadra Corse', 'Honda', (SELECT categ.idCat FROM Categories categ WHERE categ.nom = 'Moto3'));

-- Apartat 4
INSERT INTO PilotEscuderia VALUES(2018, (SELECT VALUE(pil) FROM Pilots pil WHERE pil.nom = 'Andrea' AND pil.cognom = 'Dovicioso'), (SELECT VALUE(escu) FROM Escuderies escu WHERE escu.nom = 'Ducati team'));
INSERT INTO PilotEscuderia VALUES(2018, (SELECT VALUE(pil) FROM Pilots pil WHERE pil.nom = 'Marc' AND pil.cognom = 'Marquez'), (SELECT VALUE(escu) FROM Escuderies escu WHERE escu.nom = 'Repsol Honda Team'));
INSERT INTO PilotEscuderia VALUES(2018, (SELECT VALUE(pil) FROM Pilots pil WHERE pil.nom = 'Isaac' AND pil.cognom = 'Viñales'), (SELECT VALUE(escu) FROM Escuderies escu WHERE escu.nom = 'SAG Team'));
INSERT INTO PilotEscuderia VALUES(2018, (SELECT VALUE(pil) FROM Pilots pil WHERE pil.nom = 'Tatsuki' AND pil.cognom = 'Suzuki'), (SELECT VALUE(escu) FROM Escuderies escu WHERE escu.nom = 'SIC58 Squadra Corse'));

-- Apartat 5
SELECT * FROM Pilots WHERE categoria IN (SELECT categ.idCat FROM Categories categ WHERE categ.nom = 'MotoGP');

-- Apartat 6
SELECT * FROM Escuderies WHERE categoria IN (SELECT categ.idCat FROM Categories categ WHERE categ.nom = 'Moto2');

-- Apartat 7
DELETE FROM PilotEscuderia pil WHERE pil.pilot.nom = 'Tatsuki' AND pil.pilot.cognom = 'Suzuki';

-- Apartat 8
UPDATE Pilots SET Pilots.categoria = 2 WHERE Pilots.nom = 'Tatsuki' AND Pilots.cognom = 'Suzuki';
