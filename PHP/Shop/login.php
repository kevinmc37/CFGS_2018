<?php
// Comprovem si ja s'ha enviat el formulari
if (isset($_POST['enviar'])) {
// INICIALITZEM LES VARIABLES DE LA SESSIÓ
    session_start();
    $_SESSION['usuari'];
    $_SESSION['password'];
    if (empty($_POST['usuari']) || empty($_POST['password'])) {
        $error = "Has d'introduir un nom d'usuari i una contrasenya";
    } else {
        // Comprovem les credencials amb la base de dades
        // Connectem a la base de dades
        $_SESSION['usuari'] = $_POST['usuari'];
        $_SESSION['password'] = $_POST['password'];
        try {
            $opc = array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8");
            $dsn = "mysql:host=localhost;dbname=dwes";
            $dwes = new PDO($dsn, "root", "root", $opc);
            }
            catch (PDOException $e) {
            die("Error: " . $e->getMessage());
        }
// Executem la consulta per comprovar les credencials
        $sql = "SELECT usuari, cistella FROM usuaris WHERE usuari='".$_SESSION['usuari']."' AND contrasenya='".$_SESSION['password']."'";
        if ($resultat = $dwes->query($sql)) {
            $fila = $resultat->fetch();
            if ($fila != null) {
                $_SESSION['cistella'] = unserialize($fila['cistella']);
                header("Location: productes.php");
            } else {
		   // Si les credencials no són correctes les tornem a demanar
                $error = "Usuari o contraseña no valids!";
            }
            unset($resultat);
        }
        unset($dwes);
    }
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Desenvolupament web en entorn servidor -->
<!-- Tema 3 : Desenvolupament d'aplicacions web amb PHP -->
<!-- Exemple Botiga Web: login.php -->
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Exemple Tema 3: Login Botiga Web</title>
    <link href="botiga.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id='login'>
        <form action='login.php' method='post'>
            <fieldset >
                <legend>Login</legend>
                <div><span class='error'> <?php if (!empty($error)) {echo $error;} ?> </span></div>
                <div class='camp'>
                    <label for='usuari' >Usuari:</label><br/>
                    <input type='text' name='usuari' id='usuari' maxlength="50" /><br/>
                </div>
                <div class='camp'>
                    <label for='password' >Contrasenya:</label><br/>
                    <input type='password' name='password' id='password' maxlength="50" /><br/>
                </div>
                <div class='camp'>
                    <input type='submit' name='enviar' value='Enviar' />
                </div>
            </fieldset>
        </form>
    </div>
</body>
</html>
