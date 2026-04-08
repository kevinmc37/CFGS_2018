<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <title>Formularis :p</title>
    </head>
    <body> <?php
        if (!isset($_POST['btn'])) { ?>
        <form action="formulari2.php" method="POST">
            <input name="num" type="number" min="1" placeholder="Escriu un número" required>
            <button name="btn" type="submit"> Nombres divisors > </button>
        </form> <?php
        }
        else {
            $divisors = array();
            for ($compt = 1; $compt <= $_POST['num']; $compt++) {
                if ($_POST['num'] % $compt === 0) {
                    array_push($divisors, $compt);
                }
            }
            if (count($divisors) <= 2) { echo "El número ".$_POST['num']." és primer."; }
            else {
                echo "El número ".$_POST['num']." no és primer. Els seus divisors són:<br>";
                foreach ($divisors as $value){
                    echo $value."\n";
                }
            }
        } ?>
    </body>
</html>