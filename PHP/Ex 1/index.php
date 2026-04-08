<?php require_once("./empleat.php");
require_once("./menu.php");
require_once("./taula.php");
//
$empleado = new empleat("Kevin", "5973");
$impost = $empleado->impostos();
if ($impost === true) { echo "L'empleat ha de pagar impostos.<br>"; }
else { echo "L'empleat no ha de pagar impostos.<br><br>"; }
//
$menu = new menu();
$menu->afegir("Google", "www.google.es");
$menu->afegir("Youtube", "www.youtube.com");
$menu->horitzontal();
echo "<br><br>";
$menu->vertical();
echo "<br><br>";
//
$taula = new taula(5, 5);
$cella1 = $taula->afegirCella(3, 2);
$cella1->colorLletra("green");
$cella1->colorFons("blue");
$cella1->inserirInformacio("Bones");
$cella2 = $taula->afegirCella(4, 1);
$cella2->colorLletra("red");
$cella2->colorFons("black");
$cella2->inserirInformacio("Hola");
$taula->mostrarTaula();