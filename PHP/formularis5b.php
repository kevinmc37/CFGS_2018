<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <title>Formularis :p</title>
    </head>
    <body>
        <b>Conversor de monedes</b><br><br> <?php
        if (!isset($_POST['convertir'])) { ?>
            <form action="formularis5b.php" method="POST">
                <input required name="euros" type="number" min="1" placeholder="Quantitat en euros" style="width: 200px;">
                <select name="moneda" required>
                    <option selected disabled>Convertir a...</option>
                    <option value=166.386 >Pesetes</option>
                    <option value=1.325>Dòlars</option>
                    <option value=0.927>Lliures</option>
                    <option value=118.232>Iens</option>
                    <option value=1.515>Francs</option>
                </select><br><br>
                <button name="convertir" type="submit">Convertir</button>
            </form> <?php
        }
        else {
            $moneda = $_POST['euros']*$_POST['moneda'];
            if ($_POST['moneda'] === 166.386) { $nom = " pesetes."; }
            elseif ($_POST['moneda'] === 1.325) { $nom = " dòlars."; }
            elseif ($_POST['moneda'] === 0.927) { $nom = " lliures esterlines."; }
            elseif ($_POST['moneda'] === 118.232) { $nom = " iens."; }
            elseif ($_POST['moneda'] === 1.515) { $nom = " francs suïssos."; }
            echo $_POST['euros']." euros equivalen a ".$moneda.$nom; ?>
            <br><br><a href="formularis5b.php">Volver</a> <?php
        } ?>
    </body>
</html>