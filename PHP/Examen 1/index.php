<?php require_once('./cotxe.php');

$cotxe1 = new cotxe("red", 4, "modelGuay", 5);
$cotxe2 = new cotxe("blue", 2, "modelNoTantGuay", 7);
$cotxe1->plenarDeposit(2);
$cotxe2->plenarDeposit(2);

while ($cotxe1->getGasolina() > 0 || $cotxe2->getGasolina() > 0) {
    $cotxe1->accelerar();
    echo $cotxe1->getGasolina()."<br>";
    $cotxe2->accelerar();
    echo $cotxe2->getGasolina()."<br><br>";
}