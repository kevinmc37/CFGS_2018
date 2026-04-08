<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
        <title>Resultat consulta</title>
    </head>
    <body> <?php
        if (isset($_POST['enviar'])) {
            $dwes = "";
            $sql = "";
            $resultat = "";
            if (strpos($_POST['consulta'], "PDO") !== false) {
                try {
                    $opc = array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8");
                    $dsn = "mysql:host=localhost;dbname=Tasca3UF3";
                    $dwes = new PDO($dsn, "root", "root", $opc);
                }
                catch (PDOException $e) { die("Error: ".$e->getMessage()); }
                if (substr($_POST['consulta'], -2) === '1') {
                    $sql = "SELECT cognom1, cognom2 FROM Empleats";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '2') {
                    $sql = "SELECT cognom1, cognom2 FROM Empleats GROUP BY cognom1";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '3') {
                    $sql = "SELECT * FROM Empleats WHERE nom = 'LÓPEZ'";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '4') {
                    $sql = "SELECT * FROM Empleats WHERE nom = 'LÓPEZ' || nom = 'PÉREZ'";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '5') {
                    $sql = "SELECT * FROM Empleats WHERE departament = 714";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '6') {
                    $sql = "SELECT * FROM Empleats WHERE departament = 737 || departament = 777";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '7') {
                    $sql = "SELECT * FROM Empleats WHERE cognom1 LIKE 'P%'";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '8') {
                    $sql = "SELECT SUM(pressupost) \"Pressupost Total\" FROM Departaments";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '9') {
                    $sql = "SELECT departament, COUNT(*) \"Nº d'empleats\" FROM Empleats, Departaments WHERE Empleats.departament = Departaments.codi AND Departaments.codi IN(SELECT departament FROM Empleats) GROUP BY Departaments.codi";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '10') {
                    $sql = "SELECT * FROM Empleats, Departaments WHERE Empleats.departament = Departaments.codi";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '11') {
                    $sql = "SELECT cognom1, cognom2, Departaments.nom, pressupost FROM Empleats, Departaments WHERE Departaments.codi = Empleats.departament";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '12') {
                    $sql = "SELECT Empleats.nom, cognom1, cognom2 FROM Empleats, Departaments WHERE Empleats.departament = Departaments.codi AND pressupost > 60000";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '13') {
                    $sql = "SELECT * FROM Departaments WHERE pressupost > (SELECT AVG(pressupost) FROM Departaments)";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '14') {
                    $sql = "SELECT * FROM (SELECT Departaments.nom \"Departament\", COUNT(*) \"numEmpleats\" FROM Empleats, Departaments WHERE Empleats.departament = Departaments.codi AND Departaments.codi IN(SELECT departament FROM Empleats) GROUP BY Departaments.codi) AS inst1 WHERE numEmpleats > 2";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '15') {
                    $sql2 = "INSERT INTO Departaments VALUES(11, 'Qualitat', 40000)";
                    $resultat2 = $dwes->query($sql2);
                    $sql2 = "INSERT INTO Empleats VALUES('89267109Z', 'Esther', 'Vázquez', '', 11, 999)";
                    $resultat2 = $dwes->query($sql2);
                    $sql = "SELECT * FROM Empleats WHERE dni = '89267109Z'";
                    $resultat = $dwes->query($sql);
                }
                elseif (substr($_POST['consulta'], -2) === '16') {
                    $sql = "UPDATE Departaments SET pressupost = ((pressupost*10)/100)";
                    $resultat = $dwes->query($sql);
                    echo "S'han actualitzat ".$resultat->rowCount()." files.";
                    exit();
                }
                elseif (substr($_POST['consulta'], -2) === '17') {
                    $sql = "UPDATE Empleats SET departament = 714 WHERE departament = 777";
                    $resultat = $dwes->query($sql);
                    echo "S'han actualitzat ".$resultat->rowCount()." files.";
                    exit();
                }
                elseif (substr($_POST['consulta'], -2) === '18') {
                    $sql = "DELETE FROM Empleats WHERE departament = 714";
                    $resultat = $dwes->query($sql);
                    echo "S'han borrat ".$resultat->rowCount()." files.";
                    exit();
                }
                elseif (substr($_POST['consulta'], -2) === '19') {
                    $sql = "DELETE FROM Empleats WHERE departament IN (SELECT codi FROM Departaments WHERE pressupost > 60000)";
                    $resultat = $dwes->query($sql);
                    echo "S'han borrat ".$resultat->rowCount()." files.";
                    exit();
                }
                elseif (substr($_POST['consulta'], -2) === '20') {
                    $sql = "DELETE FROM Empleats";
                    $resultat = $dwes->query($sql);
                    echo "S'han borrat ".$resultat->rowCount()." files.";
                    exit();
                }
                if ($resultat->rowCount() > 0) {
                    while ($consulta = $resultat->fetch(PDO::FETCH_NAMED)) {
                        foreach ($consulta as $key=>$value) { echo "<strong style='color: green;'>".$key.":</strong> ".$value.", "; }
                        echo "<br>";
                    }
                }
                else { echo "S'han retornat 0 files"; }
            }
            else {
                $dwes = new mysqli("localhost", "root", "root", "Tasca3UF3");
                if ($dwes->connect_errno) {
                    echo "Error".$error." connectant a la base de dades: ".$dwes->connect_error;
                    exit();
                }
                $dwes->set_charset("UTF8");
                if (substr($_POST['consulta'], -2) === '1') {
                    $sql = "SELECT cognom1, cognom2 FROM Empleats";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '2') {
                    $sql = "SELECT cognom1, cognom2 FROM Empleats GROUP BY cognom1";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '3') {
                    $sql = "SELECT * FROM Empleats WHERE nom = 'LÓPEZ'";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '4') {
                    $sql = "SELECT * FROM Empleats WHERE nom = 'LÓPEZ' || nom = 'PÉREZ'";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '5') {
                    $sql = "SELECT * FROM Empleats WHERE departament = 714";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '6') {
                    $sql = "SELECT * FROM Empleats WHERE departament = 737 || departament = 777";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '7') {
                    $sql = "SELECT * FROM Empleats WHERE cognom1 LIKE 'P%'";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '8') {
                    $sql = "SELECT SUM(pressupost) \"Pressupost Total\" FROM Departaments";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '9') {
                    $sql = "SELECT departament, COUNT(*) \"Nº d'empleats\" FROM Empleats, Departaments WHERE Empleats.departament = Departaments.codi AND Departaments.codi IN(SELECT departament FROM Empleats) GROUP BY Departaments.codi";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '10') {
                    $sql = "SELECT * FROM Empleats, Departaments WHERE Empleats.departament = Departaments.codi";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '11') {
                    $sql = "SELECT cognom1, cognom2, Departaments.nom, pressupost FROM Empleats, Departaments WHERE Departaments.codi = Empleats.departament";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '12') {
                    $sql = "SELECT Empleats.nom, cognom1, cognom2 FROM Empleats, Departaments WHERE Empleats.departament = Departaments.codi AND pressupost > 60000";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '13') {
                    $sql = "SELECT * FROM Departaments WHERE pressupost > (SELECT AVG(pressupost) FROM Departaments)";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '14') {
                    $sql = "SELECT * FROM (SELECT Departaments.nom \"Departament\", COUNT(*) \"numEmpleats\" FROM Empleats, Departaments WHERE Empleats.departament = Departaments.codi AND Departaments.codi IN(SELECT departament FROM Empleats) GROUP BY Departaments.codi) AS inst1 WHERE numEmpleats > 2";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '15') {
                    $sql2 = "INSERT INTO Departaments VALUES(11, 'Qualitat', 40000)";
                    $resultat2 = $dwes->query($sql2);
                    $sql2 = "INSERT INTO Empleats VALUES('89267109Z', 'Esther', 'Vázquez', '', 11, 999)";
                    $resultat2 = $dwes->query($sql2);
                    $sql = "SELECT * FROM Empleats WHERE dni = '89267109Z'";
                    $resultat = $dwes->query($sql, MYSQLI_USE_RESULT);
                }
                elseif (substr($_POST['consulta'], -2) === '16') {
                    $sql = "UPDATE Departaments SET pressupost = ((pressupost*10)/100)";
                    $resultat = $dwes->query($sql);
                    echo "S'han actualitzat ".$resultat->num_rows." files.";
                    exit();
                }
                elseif (substr($_POST['consulta'], -2) === '17') {
                    $sql = "UPDATE Empleats SET departament = 714 WHERE departament = 777";
                    $resultat = $dwes->query($sql);
                    echo "S'han actualitzat ".$resultat->num_rows." files.";
                    exit();
                }
                elseif (substr($_POST['consulta'], -2) === '18') {
                    $sql = "DELETE FROM Empleats WHERE departament = 714";
                    $resultat = $dwes->query($sql);
                    echo "S'han borrat ".$resultat->num_rows." files.";
                    exit();
                }
                elseif (substr($_POST['consulta'], -2) === '19') {
                    $sql = "DELETE FROM Empleats WHERE departament IN (SELECT codi FROM Departaments WHERE pressupost > 60000)";
                    $resultat = $dwes->query($sql);
                    echo "S'han borrat ".$resultat->num_rows." files.";
                    exit();
                }
                elseif (substr($_POST['consulta'], -2) === '20') {
                    $sql = "DELETE FROM Empleats";
                    $resultat = $dwes->query($sql);
                    echo "S'han borrat ".$resultat->num_rows." files.";
                    exit();
                }
                if ($resultat->num_rows > 0) {
                    while ($consulta = $resultat->fetch_assoc()) {
                        foreach ($consulta as $key=>$value) { echo "<strong style='color: green;'>".$key.":</strong> ".$value.", "; }
                        echo "<br>";
                    }
                }
                else { echo "S'han retornat 0 files."; }
            }
        } ?>
    </body>
</html>