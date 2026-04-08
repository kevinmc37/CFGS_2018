<?php session_start();
$cistellaUsuari = serialize($_SESSION['cistella']);
try {
    $opc = array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8");
    $dsn = "mysql:host=localhost;dbname=dwes";
    $dwes = new PDO($dsn, "root", "root", $opc);
}
catch (PDOException $e) {
    die("Error: " . $e->getMessage());
}
$sql = "UPDATE usuaris SET cistella='".$cistellaUsuari."' WHERE usuari='".$_SESSION['usuari']."' AND contrasenya='".$_SESSION['password']."'";
$resultat = $dwes->query($sql);
session_destroy();
header('Location: login.php');