INSERT INTO CLIENTS VALUES (Client(1,'Kevin',Adressa2('carerrugrbg', 'ciutatjfbrhv', '08508'),'856843658'));

SELECT * FROM CLIENTS;

UPDATE CLIENTS SET CLIENTS.CLI_NOM = 'incognito' WHERE CLIENTS.CLI_NUM = 1;

UPDATE CLIENTS cli SET cli.ADRESSA.carrer = 'noucarrer' WHERE cli.ADRESSA.cp = '08508';

DELETE FROM CLIENTS cli WHERE cli.CLI_NUM = 1;

CREATE TABLE clients2 OF CLIENT;

INSERT INTO CLIENTS2 SELECT VALUE(cli) FROM CLIENTS cli WHERE cli.CLI_NUM = 1;

SELECT * FROM CLIENTS2;

SELECT cli1.cli_nom FROM CLIENTS cli1 JOIN CLIENTS2 cli2 ON VALUE(cli1) = VALUE(cli2);

DECLARE
    cli1 CLIENT;
    cli2 CLIENT;
BEGIN
    SELECT VALUE (clie) INTO cli1 FROM CLIENTS clie WHERE clie.cli_num = 1;
    dbms_output.put_line(cli1.cli_nom);
    cli2 := cli1;
    dbms_output.put_line(cli2.cli_nom);
END;
