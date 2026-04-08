<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <title>Formularis :p</title>
    </head>
    <body> <?php
        if (isset($_GET['btn'])) {
            if ($_GET['elMeuNumero']%2 == 0) {
                echo "El formulari s'ha enviat a través de GET ^_^. Ara imprimim la frase tantes vegades com hagis dit"; ?>
                <br> <?php
                for ($compt = 0; $compt < $_GET['elMeuNumero']; $compt++) {
                    echo $_GET['laMevaFrase']."\n";
                }
            }
            else { ?>
                <p>Ho sento, només acceptem nombres parells.</p>
                <form action="formulari1.php" method="GET">
                    <input name="laMevaFrase" type="text" placeholder="Escriu una frase" value="<?php echo $_GET['laMevaFrase']; ?>" required>
                    <input name="elMeuNumero" type="number" min="1" placeholder="Escriu un número parell" style="width: 200px;" required>
                    <button name="btn" type="submit"> Imprimir Frase GET > </button>
                </form> <?php
            }
        }
        elseif (isset($_POST['btn'])) {
            if ($_POST['elMeuNumero']%2 == 0) {
                echo "El formulari s'ha enviat a través de POST ^_^. Ara imprimim la frase tantes vegades com hagis dit"; ?>
                <br> <?php
                for ($compt = 0; $compt < $_POST['elMeuNumero']; $compt++) {
                    echo $_POST['laMevaFrase']."\n";
                }
            }
            else { ?>
                <p>Ho sento, només acceptem nombres parells.</p>
                <form action="formulari1.php" method="POST">
                    <input name="laMevaFrase" type="text" placeholder="Escriu una frase" value="<?php echo $_POST['laMevaFrase']; ?>" required>
                    <input name="elMeuNumero" type="number" min="1" placeholder="Escriu un número parell" style="width: 200px;" required>
                    <button name="btn" type="submit"> Imprimir Frase POST > </button>
                </form> <?php
            }
        }
        else { ?>
            <form action="formulari1.php" method="GET">
                <input name="laMevaFrase" type="text" placeholder="Escriu una frase" required>
                <input name="elMeuNumero" type="number" min="1" placeholder="Escriu un número parell" style="width: 200px;" required>
                <button name="btn" type="submit"> Imprimir Frase GET > </button>
            </form>
            <br>
            <form action="formulari1.php" method="POST">
                <input name="laMevaFrase" type="text" placeholder="Escriu una frase" required>
                <input name="elMeuNumero" type="number" min="1" placeholder="Escriu un número parell" style="width: 200px;" required>
                <button name="btn" type="submit"> Imprimir Frase POST > </button>
            </form> <?php
        } ?>
    </body>
</html>