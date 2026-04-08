<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <title>Formularis :p</title>
    </head>
    <body>
        <b>Conversor d'euros a pesetes</b><br><br> <?php
        if (!isset($_POST['convertir'])) { ?>
            <form action="formularis5a.php" method="POST">
                <input required name="euros" type="number" min="1" placeholder="Quantitat en euros" style="width: 200px;"><br>
                <br><button name="convertir" type="submit">Convertir</button>
            </form> <?php
        }
        else {
            $peseta = $_POST['euros']*166.386;
            echo $_POST['euros']." euros equivalen a ".$peseta." pesetes."; ?>
            <br><br><a href="formularis5a.php">Volver</a> <?php
        } ?>
    </body>
</html>