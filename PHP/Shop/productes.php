<?php
// Recuperem la informació de la sessió
session_start();
var_dump($_SESSION);
// i comprovem que s'usuari s'ha identificat
if (!isset($_SESSION['usuari'])) {
    die("Error - t'has <a href='login.php'>d'identificar</a>.<br />");
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Desenvolupament web en entorn servidor -->
<!-- Tema 3 : Desenvolupament d'aplicacions web amb PHP -->
<!-- Exemple Botiga Web: productes.php -->
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Exemple Tema 3: llistat de productes</title>
        <link href="botiga.css" rel="stylesheet" type="text/css">
    </head>
    <body class="pagproductes">
        <div id="contenidor">
        <div id="encapçalament">
            <h1>Llistat de productes</h1>
        </div>
        <div id="cistella">
            <h3><img src="cistella.png" alt="Cistella" width="24" height="21">Cistella</h3>
            <hr /> <?php
                // Comprovem si s'ha enviat el formulari de buidar la cistella
                if (isset($_POST['buidar'])) {
                    unset($_SESSION['cistella']);
                    header('Location: productes.php');
                    
                }
                // Comprovem si s'ha enviat el formulari d'afegir
                if (isset($_POST['enviar'])) {
                    // Creem un array amb les dades del nou producte
                    $producte['nom'] = $_POST['nom'];
                    $producte['preu'] = $_POST['preu'];
                    // i l'afegim
                    $_SESSION['cistella'][$_POST['codi']] = $producte;
                    header('Location: productes.php');
                }
                // Si la cistella està buida, mostrem un missatge
                $cistella_buida = true;
                if (empty($_SESSION['cistella'])) {
                    print "<p>Cistella buida</p>";
                }
                // Si no està buida, mostrem el seu contingut
                else {
                    foreach ($_SESSION['cistella'] as $cistella) {
                        foreach ($cistella as $productes) {
                            echo $productes." ";
                        }
                        echo " €<br>";
                    }
                    $cistella_buida = false;
                }
            ?>
            <form id='buidar' action='productes.php' method='post'>
                <input type='submit' name='buidar' value='Buidar cistella'
                <?php if ($cistella_buida) print "disabled='true'"; ?>
                />
            </form>
            <form id='comprar' action='cistella.php' method='post'>
                <input type='submit' name='comprar' value='Comprar'
                <?php if ($cistella_buida) print "disabled='true'"; ?>
            />
            </form>
        </div>
        <div id="productes">
            <?php
                try {
                    $opc = array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8");
                    $dsn = "mysql:host=localhost;dbname=dwes";
                    $dwes = new PDO($dsn, "root", "root", $opc);
                }
                catch (PDOException $e) {
                    $error = $e->getCode();
                    $missatge = $e->getMessage();
                }
            if (!isset($error)) {
                $sql = "SELECT codi, nom_curt, preu FROM productes";
                $resultat = $dwes->query($sql);
                if($resultat) {
                    // creem un formulari per cada producte obtingut
                    $row = $resultat->fetch();
                    while ($row != null) {
                        echo "<p><form id='${row['codi']}' action='productes.php' method='POST'>";
                        echo "<input type='hidden' name='codi' value='".$row['codi']."'/>";
                        echo "<input type='hidden' name='nom' value='".$row['nom_curt']."'/>";
                        echo "<input type='hidden' name='preu' value='".$row['preu']."'/>";
                        echo "<input type='submit' name='enviar' value='Afegir'/>";                    
                        echo " ". $row['nom_curt'].": ";
                        echo " ". $row['preu']." €.";
                        echo "</form>";
                        echo "</p>";
                        $row = $resultat->fetch();
                    }
                }
            }
        ?>
        </div>
            <br class="divisor" />
            <div id="peu">
                <form action='logout.php' method='post'>
                <input type='submit' name='desconnectar' value='Desconnectar usuari <?php echo $_SESSION['usuari']; ?>'/>
                </form>
            <?php
            if (isset($error)) {
                print "<p class='error'>Error $error: $missatge</p>";
            }
            ?>
        </div>
    </div>
    </body>
</html>

