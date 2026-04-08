<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <title>Formularis :p</title>
    </head>
    <body>
        <b style="font-size: 24px; color: cornflowerblue;">Inserció de vivenda</b><br> <?php
        session_start();
        if (!isset($_POST['insertar'])) { ?>
            <p>Introdueix les dades de la vivenda:</p>
            <div style="border: dashed 2px deepskyblue;">
                <form action="formularis5c.php" method="POST" style="line-height: 35px;">
                    <b>Tipus de vivenda:</b>
                    <select name="pis" required> <?php
                        if (!isset($_SESSION['pis'])) { ?> <option selected disabled>Tipus...</option> <?php } ?>
                        <option <?php if (isset($_SESSION['pis']) && $_SESSION['pis'] === "Pis") { echo "selected"; } ?> value="Pis">Pis</option>
                        <option <?php if (isset($_SESSION['pis']) && $_SESSION['pis'] === "Adossat") { echo "selected"; } ?> value="Adossat">Adossat</option>
                        <option <?php if (isset($_SESSION['pis']) && $_SESSION['pis'] === "Xalet") { echo "selected"; } ?> value="Xalet">Xalet</option>
                        <option <?php if (isset($_SESSION['pis']) && $_SESSION['pis'] === "Casa") { echo "selected"; } ?> value="Casa">Casa</option>
                    </select><br>
                    <b>Zona:</b>
                    <select name="zona" required> <?php
                        if (!isset($_SESSION['zona'])) { ?> <option selected disabled>Zones...</option> <?php } ?>
                        <option <?php if (isset($_SESSION['zona']) && $_SESSION['zona'] === "Centre") { echo "selected"; } ?> value="Centre">Centre</option>
                        <option <?php if (isset($_SESSION['zona']) && $_SESSION['zona'] === "Nervión") { echo "selected"; } ?> value="Nervión">Nervión</option>
                        <option <?php if (isset($_SESSION['zona']) && $_SESSION['zona'] === "Triana") { echo "selected"; } ?> value="Triana">Triana</option>
                        <option <?php if (isset($_SESSION['zona']) && $_SESSION['zona'] === "Aljarafe") { echo "selected"; } ?> value="Aljarafe">Aljarafe</option>
                        <option <?php if (isset($_SESSION['zona']) && $_SESSION['zona'] === "Macarena") { echo "selected"; } ?> value="Macarena">Macarena</option>
                    </select><br>
                    <b>Direcció:</b>
                    <input name="direccio" type="text" required <?php if (isset($_SESSION['direccio'])) { ?> value="<?php echo $_SESSION['direccio'] ?>" <?php } ?> ><br>
                    <b>Nº dormitoris:</b>
                    <input name="dorm" <?php if (isset($_SESSION['dorm']) && $_SESSION['dorm'] === "1") { echo "checked"; } ?> id="dorm1" value=1 type="radio" required><label for="dorm1">1</label>
                    <input name="dorm" <?php if (isset($_SESSION['dorm']) && $_SESSION['dorm'] === "2") { echo "checked"; } ?> id="dorm2" value=2 type="radio"><label for="dorm2">2</label>
                    <input name="dorm" <?php if (isset($_SESSION['dorm']) && $_SESSION['dorm'] === "3") { echo "checked"; } ?> id="dorm3" value=3 type="radio"><label for="dorm3">3</label>
                    <input name="dorm" <?php if (isset($_SESSION['dorm']) && $_SESSION['dorm'] === "4") { echo "checked"; } ?> id="dorm4" value=4 type="radio"><label for="dorm4">4</label>
                    <input name="dorm" <?php if (isset($_SESSION['dorm']) && $_SESSION['dorm'] === "5") { echo "checked"; } ?> id="dorm5" value=5 type="radio"><label for="dorm5">5</label><br>
                    <b>Preu:</b>
                    <input name="preu" <?php if (isset($_SESSION['preu'])) { ?> value="<?php echo $_SESSION['preu'] ?>" <?php } ?> type="number" min="1" placeholder="€" required><br>
                    <b>Tamany:</b>
                    <input name="tamany" <?php if (isset($_SESSION['tamany'])) { ?> value="<?php echo $_SESSION['tamany'] ?>" <?php } ?> type="number" min="1" placeholder="m²" required><br>
                    <b>Extres:</b> <?php
                    if (isset($_SESSION['extra'])) {
                        foreach ($_SESSION['extra'] as $key => $extra) { ?>
                            <input name="extra[]" id="<?php echo "extra".($key+1); ?>" value="<?php echo $extra; ?>" type="checkbox" checked><label for="<?php echo "extra".($key+1); ?>"><?php echo $extra; ?></label> <?php
                        }
                        if (!in_array("Piscina", $_SESSION['extra'])) { ?> <input name="extra[]" id="extra1" value="Piscina" type="checkbox"><label for="extra1">Piscina</label> <?php }
                        if (!in_array("Jardí", $_SESSION['extra'])) { ?> <input name="extra[]" id="extra2" value="Jardí" type="checkbox"><label for="extra2">Jardí</label> <?php }
                        if (!in_array("Garatge", $_SESSION['extra'])) { ?> <input name="extra[]" id="extra3" value="Garatge" type="checkbox"><label for="extra3">Garatge</label> <?php } ?>
                        <br> <?php
                    }
                    else { ?>
                        <input name="extra[]" id="extra1" value="Piscina" type="checkbox"><label for="extra1">Piscina</label>
                        <input name="extra[]" id="extra2" value="Jardí" type="checkbox"><label for="extra2">Jardí</label>
                        <input name="extra[]" id="extra3" value="Garatge" type="checkbox"><label for="extra3">Garatge</label><br> <?php
                    } ?>
                    <b style="vertical-align: top;">Observacions:</b>
                    <textarea name="observacions" rows="5" cols="50" placeholder="Escriu les teves observacions aquí..."><?php if (isset($_SESSION['observacions'])) { echo $_SESSION['observacions']; } ?></textarea><br>
                    <button name="insertar" type="submit">Insertar vivenda</button>
                </form>
            </div> <?php
        }
        elseif (empty($_POST['pis']) || empty($_POST['zona']) || empty($_POST['direccio']) || empty($_POST['dorm']) || empty($_POST['preu']) || empty($_POST['tamany']) || empty($_POST['extra']) || empty($_POST['observacions'])) { ?>
            <p>No s'ha pogut fer la inserció degut als següents errors:</p><br> <?php
            if (empty($_POST['pis'])) { ?> <li>Tipus de vivenda errònia.</li> <?php }
            else { $_SESSION['pis'] = $_POST['pis']; }
            if (empty($_POST['zona'])) { ?> <li>Zona de vivenda errònia.</li> <?php }
            else { $_SESSION['zona'] = $_POST['zona']; }
            if (empty($_POST['direccio'])) { ?> <li>Direcció de vivenda errònia.</li> <?php }
            else { $_SESSION['direccio'] = $_POST['direccio']; }
            if (empty($_POST['dorm'])) { ?> <li>Nº de dormitoris erroni.</li> <?php }
            else { $_SESSION['dorm'] = $_POST['dorm']; }
            if (empty($_POST['preu'])) { ?> <li>Preu de vivenda erroni.</li> <?php }
            else { $_SESSION['preu'] = $_POST['preu']; }
            if (empty($_POST['tamany'])) { ?> <li>Tamany de vivenda erroni.</li> <?php }
            else { $_SESSION['tamany'] = $_POST['tamany']; }
            if (!empty($_POST['extra'])) {
                foreach ($_POST['extra'] as $extra) {
                    $_SESSION['extra'] = $_POST['extra'];
                }
            }
            if (!empty($_POST['observacions'])) { $_SESSION['observacions'] = $_POST['observacions']; } ?>
            <br><br><a href="formularis5c.php">Volver</a> <?php
        }
        else { ?>
            <p>Aquestes són les dades introduïdes:</p>
            <li>Tipus: <?php echo $_POST['pis']; ?></li><br>
            <li>Zona: <?php echo $_POST['zona']; ?></li><br>
            <li>Direcció: <?php echo $_POST['direccio']; ?></li><br>
            <li>Nº dormitoris: <?php echo $_POST['dorm']; ?></li><br>
            <li>Preu: <?php echo $_POST['preu']; ?></li><br>
            <li>Tamany: <?php echo $_POST['tamany']; ?></li><br> <?php
            if (isset($_POST['extra'])) { ?>
                <li>Extres: <?php
                    foreach ($_POST['extra'] as $key => $extra) {
                        echo $extra;
                        if ($key < count($_POST['extra'])-1) { echo ", "; }
                        else { echo "."; }
                    } ?>
                </li><br> <?php
            }
            if (isset($_POST['observacions']) && !empty($_POST['observacions'])) { ?>
                <li>Observacions: <?php echo $_POST['observacions']; ?></li> <?php
            } ?>
            <br><br><a href="formularis5c.php">Insertar una altra vivenda</a> <?php
            session_unset();
            session_destroy();
        } ?>
    </body>
</html>