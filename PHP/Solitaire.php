<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <title>Solitari</title>
    </head>
    <body>
        <?php session_start();
        if (!isset($_POST['btnExit'])) {
            $cartaEscollida;
            $figures = array("Cors", "Diamants", "Trèvols", "Piques");
            $cartes = array("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
            if (!isset($_SESSION['grup'])) {
                $_SESSION['grup'] = 0;
                $baralla = array();
                foreach ($figures as $figura) {
                    foreach ($cartes as $carta) {
                        $baralla[] = array("carta"=>$carta, "figura"=>$figura);
                    }
                }
                shuffle($baralla); // baralla de 52 cartes
                $mall = array( // 24 cartes en grups de 3
                    array("", "", ""),
                    array("", "", ""),
                    array("", "", ""),
                    array("", "", ""),
                    array("", "", ""),
                    array("", "", ""),
                    array("", "", ""),
                    array("", "", "")
                );
                $columnes = array( // 28 cartes restants en columnes
                    array(""),
                    array("", ""),
                    array("", "", ""),
                    array("", "", "", ""),
                    array("", "", "", "", ""),
                    array("", "", "", "", "", ""),
                    array("", "", "", "", "", "", "")
                );
                $colocades = array( // espai per les 52 cartes
                    array(" ", "", "", "", "", "", "", "", "", "", "", "", ""),
                    array(" ", "", "", "", "", "", "", "", "", "", "", "", ""),
                    array(" ", "", "", "", "", "", "", "", "", "", "", "", ""),
                    array(" ", "", "", "", "", "", "", "", "", "", "", "", "")
                );
                foreach ($mall as $key => $trio) {
                    for ($compt1 = 0; $compt1 < sizeof($trio); $compt1++) {
                        $mall[$key][$compt1] = array_shift($baralla);
                    }
                }
                foreach ($columnes as $key => $columna) {
                    for ($compt2 = 0; $compt2 < sizeof($columna); $compt2++) {
                        $columnes[$key][$compt2] = array_shift($baralla);
                    }
                }
                $_SESSION['mall'] = $mall;
                $_SESSION['columnes'] = $columnes;
                $_SESSION['colocades'] = $colocades;
                $_SESSION['cartaEscollida'] = array("", "");
                $_SESSION['ultimaCartaColocada'] = array(0, 0, 0, 0);
                $_SESSION['ultimaCartaColumnes'] = array(0, 0, 0, 0, 0, 0, 0);
                $_SESSION['ultimaCartaAdicionals'] = $_SESSION['ultimaCartaColumnes'];
                $_SESSION['adicionals'] = array_fill_keys(array_keys($columnes), null);
                $cartaEscollida = false;
            }
            if (isset($_POST['btnCanvi'])) {
                if ($_SESSION['grup'] < sizeof($_SESSION['mall'])-1) { $_SESSION['grup']++; }
                else { $_SESSION['grup'] = 0; }
            }
            if (isset($_POST['btnAgafarMall'])) {
                $_SESSION['cartaEscollida'][0] = $_SESSION['mall'][$_SESSION['grup']][0]['carta'];
                $_SESSION['cartaEscollida'][1] = $_SESSION['mall'][$_SESSION['grup']][0]['figura'];
                $cartaEscollida = true;
            }
            if (isset($_POST['btnAgafarColumna1']) || isset($_POST['btnAgafarColumna2']) || isset($_POST['btnAgafarColumna3']) || isset($_POST['btnAgafarColumna4']) || isset($_POST['btnAgafarColumna5']) || isset($_POST['btnAgafarColumna6']) || isset($_POST['btnAgafarColumna7'])) {
                for ($columnaEscollida = 1; $columnaEscollida < 8; $columnaEscollida++) {
                    if (isset($_POST["btnAgafarColumna$columnaEscollida"])) {
                        $llargColumna = sizeof($_SESSION['columnes'][$columnaEscollida-1])-1;
                        $_SESSION['cartaEscollida'][0] = $_SESSION['columnes'][$columnaEscollida-1][$llargColumna]['carta'];
                        $_SESSION['cartaEscollida'][1] = $_SESSION['columnes'][$columnaEscollida-1][$llargColumna]['figura'];
                        $cartaEscollida = true;
                    }
                }
            }
            if (isset($_POST['btnAgafarAdicional1']) || isset($_POST['btnAgafarAdicional2']) || isset($_POST['btnAgafarAdicional3']) || isset($_POST['btnAgafarAdicional4']) || isset($_POST['btnAgafarAdicional5']) || isset($_POST['btnAgafarAdicional6']) || isset($_POST['btnAgafarAdicional7'])) {
                for ($columnaEscollida = 1; $columnaEscollida < 8; $columnaEscollida++) {
                    if (isset($_POST["btnAgafarAdicional$columnaEscollida"])) {
                        $llargColumna = sizeof($_SESSION['adicionals'][$columnaEscollida-1])-1;
                        $_SESSION['cartaEscollida'][0] = $_SESSION['adicionals'][$columnaEscollida-1][$llargColumna]['carta'];
                        $_SESSION['cartaEscollida'][1] = $_SESSION['adicionals'][$columnaEscollida-1][$llargColumna]['figura'];
                        $cartaEscollida = true;
                    }
                }
            }
            if (isset($_POST['btnRetirar'])) {
                $_SESSION['cartaEscollida'][0] = "";
                $_SESSION['cartaEscollida'][1] = "";
                $cartaEscollida = false;
            }
            if (isset($_POST['btnAfegirColocades1']) || isset($_POST['btnAfegirColocades2']) || isset($_POST['btnAfegirColocades3']) || isset($_POST['btnAfegirColocades4'])) {
                for ($palEscollit = 1; $palEscollit < 5; $palEscollit++) {
                    if (isset($_POST["btnAfegirColocades$palEscollit"])) {
                        if (isset($_SESSION['ultimaCartaColocada'][$palEscollit-1])) {
                            $trobada = false;
                            $carta = $_SESSION['cartaEscollida'][0];
                            $figura = $_SESSION['cartaEscollida'][1];
                            $_SESSION['colocades'][$palEscollit-1][$_SESSION['ultimaCartaColocada'][$palEscollit-1]] = $carta." de ".$figura;
                            if ($_SESSION['ultimaCartaColocada'][$palEscollit-1] < sizeof($_SESSION['colocades'][$palEscollit-1])-1) {
                                $_SESSION['colocades'][$palEscollit-1][$_SESSION['ultimaCartaColocada'][$palEscollit-1]+1] = " ";
                            }
                            foreach ($_SESSION['mall'] as $key1 => $mall) {
                                foreach ($mall as $key2 => $posicio) {
                                    if ($posicio['carta'] === $carta && $posicio['figura'] === $figura) {
                                        unset($_SESSION['mall'][$key1][$key2]);
                                        $_SESSION['mall'][$key1] = array_values($_SESSION['mall'][$key1]);
                                        $trobada = true;
                                        if (empty($_SESSION['mall'][$key1][$key2])) {
                                            unset($_SESSION['mall'][$key1]);
                                            $_SESSION['mall'] = array_values($_SESSION['mall']);
                                        }
                                        break 2;
                                    }
                                }
                            }
                            if ($trobada === false) {
                                foreach ($_SESSION['columnes'] as $key1 => $columna) {
                                    foreach ($columna as $key2 => $posicio) {
                                        if ($posicio['carta'] === $carta && $posicio['figura'] === $figura) {
                                            unset($_SESSION['columnes'][$key1][$key2]);
                                            $trobada = true;
                                            break 2;
                                        }
                                    }
                                }
                            }
                            if ($trobada === false) {
                                foreach ($_SESSION['adicionals'] as $key1 => $adicional) {
                                    foreach ($adicional as $key2 => $posicio) {
                                        if ($posicio['carta'] === $carta && $posicio['figura'] === $figura) {
                                            unset($_SESSION['adicionals'][$key1][$key2]);
                                            $trobada = true;
                                            break 2;
                                        }
                                    }
                                }
                            }
                            $_SESSION['cartaEscollida'][0] = "";
                            $_SESSION['cartaEscollida'][1] = "";
                            $cartaEscollida = false;
                        }
                    }
                }
            }
            if (isset($_POST['btnAfegirAdicional1']) || isset($_POST['btnAfegirAdicional2']) || isset($_POST['btnAfegirAdicional3']) || isset($_POST['btnAfegirAdicional4']) || isset($_POST['btnAfegirAdicional5']) || isset($_POST['btnAfegirAdicional6']) || isset($_POST['btnAfegirAdicional7'])) {
                $adicional = false;
                for ($columnaAdicional = 1; $columnaAdicional < 8; $columnaAdicional++) {
                    if (isset($_POST["btnAfegirAdicional$columnaAdicional"])) {
                        if ($adicional === false) {
                            $_SESSION['adicionals'][$columnaAdicional-1][] = array_fill_keys(array_keys($_SESSION['adicionals'][$columnaAdicional-1][0]), null);
                            $adicional = true;
                        }
                        for ($llargColumna = 0; $llargColumna < sizeof($_SESSION['adicionals'][$columnaAdicional-1]); $llargColumna++) {
                            if ($llargColumna < sizeof($_SESSION['adicionals'][$columnaAdicional-1])-1) {
                                continue;
                            }
                            elseif ($llargColumna !== 0 && empty($_SESSION['adicionals'][$columnaAdicional-1])) { continue; }
                            $trobada = false;
                            $carta = $_SESSION['cartaEscollida'][0];
                            $figura = $_SESSION['cartaEscollida'][1];
                            $_SESSION['adicionals'][$columnaAdicional-1][$llargColumna]['carta'] = $_SESSION['cartaEscollida'][0];
                            $_SESSION['adicionals'][$columnaAdicional-1][$llargColumna]['figura'] = $_SESSION['cartaEscollida'][1];
                            foreach ($_SESSION['mall'] as $key1 => $mall) {
                                foreach ($mall as $key2 => $posicio) {
                                    if ($posicio['carta'] === $carta && $posicio['figura'] === $figura) {
                                        unset($_SESSION['mall'][$key1][$key2]);
                                        $_SESSION['mall'][$key1] = array_values($_SESSION['mall'][$key1]);
                                        $trobada = true;
                                        if (empty($_SESSION['mall'][$key1][$key2])) {
                                            unset($_SESSION['mall'][$key1]);
                                            $_SESSION['mall'] = array_values($_SESSION['mall']);
                                        }
                                        break 2;
                                    }
                                }
                            }
                            if ($trobada === false) {
                                foreach ($_SESSION['columnes'] as $key1 => $columna) {
                                    foreach ($columna as $key2 => $posicio) {
                                        if ($posicio['carta'] === $carta && $posicio['figura'] === $figura) {
                                            unset($_SESSION['columnes'][$key1][$key2]);
                                            $trobada = true;
                                            break 2;
                                        }
                                    }
                                }
                            }
                            if ($trobada === false) {
                                foreach ($_SESSION['adicionals'] as $key1 => $adicional) {
                                    foreach ($adicional as $key2 => $posicio) {
                                        if ($posicio['carta'] === $carta && $posicio['figura'] === $figura) {
                                            unset($_SESSION['adicionals'][$key1][$key2]);
                                            $trobada = true;
                                            break 2;
                                        }
                                    }
                                }
                            }
                            $_SESSION['cartaEscollida'][0] = "";
                            $_SESSION['cartaEscollida'][1] = "";
                            $cartaEscollida = false;
                        }
                    }
                }
            } ?>
            <form action="solitari.php" method="POST"> <?php
                if ($_SESSION['cartaEscollida'][0] !== "") { ?>
                    <b>Carta escollida: </b> <?php
                    echo $_SESSION['cartaEscollida'][0]." de ".$_SESSION['cartaEscollida'][1]; ?>
                    <button name="btnRetirar">Retirar carta</button><br> <?php
                    $cartaEscollida = true;
                }
                else { $cartaEscollida = false; } ?>
                <b>Cartes col·locades:</b> <?php
                $numFigura = 0;
                foreach ($_SESSION['colocades'] as $colocada) {
                    $ultimaCarta = 0;
                    if ($colocada[0] === " ") {
                        if ($numFigura === 0) { $ultimaCarta = "Pal de Cors"; }
                        elseif ($numFigura === 1) { $ultimaCarta = "Pal de Diamants"; }
                        elseif ($numFigura === 2) { $ultimaCarta = "Pal de Trèvols"; }
                        elseif ($numFigura === 3) { $ultimaCarta = "Pal de Piques"; } ?>
                        <br><span><?php echo $ultimaCarta; ?> &emsp;</span> <?php
                    }
                    elseif (strpos($colocada[12], 'K') !== false) {
                        $_SESSION['ultimaCartaColocada'][$numFigura] = 13;
                        if ($numFigura === 0) { $ultimaCarta = "Pal de Cors Complet!"; }
                        elseif ($numFigura === 1) { $ultimaCarta = "Pal de Diamants Complet!"; }
                        elseif ($numFigura === 2) { $ultimaCarta = "Pal de Trèvols Complet!"; }
                        elseif ($numFigura === 3) { $ultimaCarta = "Pal de Piques Complet!"; } ?>
                        <br><span><?php echo $ultimaCarta; ?> &emsp;</span> <?php
                    }
                    else {
                        for ($comptarUltima = 1; $comptarUltima < 13; $comptarUltima++) {
                            if ($comptarUltima < 12) {
                                if ($colocada[$comptarUltima] === " ") {
                                    $ultimaCarta = $colocada[$comptarUltima-1];
                                    $_SESSION['ultimaCartaColocada'][$numFigura] = $comptarUltima;
                                    break;
                                }
                            }
                            else {
                                if ($colocada[$comptarUltima] === " ") {
                                    $ultimaCarta = $colocada[$comptarUltima-1];
                                    $_SESSION['ultimaCartaColocada'][$numFigura] = $comptarUltima;
                                }
                            }
                        } ?>
                        <br><span><?php echo $ultimaCarta; ?> &emsp;</span> <?php
                    }
                    $numFigura++;
                    if ($_SESSION['ultimaCartaColocada'][$numFigura-1] < sizeof($_SESSION['colocades'][$numFigura-1])) {
                        if ($cartaEscollida === true) {
                            if ($_SESSION['colocades'][$numFigura-1][0] === " ") {
                                if ($numFigura === 1 && $_SESSION['cartaEscollida'][0] === "A" && $_SESSION['cartaEscollida'][1] === "Cors") { ?>
                                    <button name="btnAfegirColocades<?php echo $numFigura; ?>" style="margin-left: 35px;">Afegir carta [<?php echo $numFigura; ?>]</button> <?php
                                }
                                elseif ($numFigura === 2 && $_SESSION['cartaEscollida'][0] === "A" && $_SESSION['cartaEscollida'][1] === "Diamants") { ?>
                                    <button name="btnAfegirColocades<?php echo $numFigura; ?>" style="margin-left: 35px;">Afegir carta [<?php echo $numFigura; ?>]</button> <?php
                                }
                                elseif ($numFigura === 3 && $_SESSION['cartaEscollida'][0] === "A" && $_SESSION['cartaEscollida'][1] === "Trèvols") { ?>
                                    <button name="btnAfegirColocades<?php echo $numFigura; ?>" style="margin-left: 35px;">Afegir carta [<?php echo $numFigura; ?>]</button> <?php
                                }
                                elseif ($numFigura === 4 && $_SESSION['cartaEscollida'][0] === "A" && $_SESSION['cartaEscollida'][1] === "Piques") { ?>
                                    <button name="btnAfegirColocades<?php echo $numFigura; ?>" style="margin-left: 35px;">Afegir carta [<?php echo $numFigura; ?>]</button> <?php
                                }
                            }
                            else {
                                $seguentCarta = array_search($ultimaCarta[0], $cartes);
                                $seguentCarta = $cartes[$seguentCarta+1];
                                if ($numFigura === 1 && $_SESSION['cartaEscollida'][0] === $seguentCarta && $_SESSION['cartaEscollida'][1] === "Cors") { ?>
                                    <button name="btnAfegirColocades<?php echo $numFigura; ?>" style="margin-left: 35px;">Afegir carta [<?php echo $numFigura; ?>]</button> <?php
                                }
                                elseif ($numFigura === 2 && $_SESSION['cartaEscollida'][0] === $seguentCarta && $_SESSION['cartaEscollida'][1] === "Diamants") { ?>
                                    <button name="btnAfegirColocades<?php echo $numFigura; ?>" style="margin-left: 35px;">Afegir carta [<?php echo $numFigura; ?>]</button> <?php
                                }
                                elseif ($numFigura === 3 && $_SESSION['cartaEscollida'][0] === $seguentCarta && $_SESSION['cartaEscollida'][1] === "Trèvols") { ?>
                                    <button name="btnAfegirColocades<?php echo $numFigura; ?>" style="margin-left: 35px;">Afegir carta [<?php echo $numFigura; ?>]</button> <?php
                                }
                                elseif ($numFigura === 4 && $_SESSION['cartaEscollida'][0] === $seguentCarta && $_SESSION['cartaEscollida'][1] === "Piques") { ?>
                                    <button name="btnAfegirColocades<?php echo $numFigura; ?>" style="margin-left: 35px;">Afegir carta [<?php echo $numFigura; ?>]</button> <?php
                                }
                            }
                        }
                    }
                } ?>
                <br><br><b>Mall:</b> <?php
                if ($cartaEscollida === false) { ?> <button name="btnCanvi" type="submit"><?php echo "Canviar grup [".($_SESSION['grup']+1)."]" ?></button><br> <?php }
                else { ?> <button disabled name="btnCanvi" type="submit"><?php echo "Canviar grup [".($_SESSION['grup']+1)."]" ?></button><br> <?php }
                for ($compt3 = 0; $compt3 < sizeof($_SESSION['mall'][$_SESSION['grup']]); $compt3++) { ?>
                    <br><span><?php echo $_SESSION['mall'][$_SESSION['grup']][$compt3]['carta']." de ".$_SESSION['mall'][$_SESSION['grup']][$compt3]['figura']; ?> &emsp;</span> <?php
                    if ($compt3 === 0) { ?>
                        <button name="btnAgafarMall">Agafar carta</button> <?php
                    }
                    echo "<br>";
                } ?>
                <br><br>
                <b>Columnes:</b><br> <?php
                $compt4 = 0;
                foreach ($_SESSION['columnes'] as $columns) {
                    if (empty($columns)) {
                        if (empty($_SESSION['adicionals'][$compt4])) { ?>
                            <span style="display: inline-block; vertical-align: top; padding-right: 15px;">Columna buida <?php
                            if ($cartaEscollida === true) {
                                if ($_SESSION['cartaEscollida'][0] === "K") { ?>
                                <br><button name="btnAfegirAdicional<?php echo $compt4+1; ?>" type="submit">Afegir carta [<?php echo $compt4+1; ?>]</button> <?php
                                }
                            } ?> </span> <?php
                        }
                        else { ?>
                            <span style="display: inline-block; vertical-align: top; padding-right: 15px;"> <?php
                            for ($afegirCarta = 0; $afegirCarta < sizeof($_SESSION['adicionals'][$compt4]); $afegirCarta++) {
                                if ($afegirCarta === sizeof($_SESSION['adicionals'][$compt4])-1) { $_SESSION['ultimaCartaAdicionals'][$compt4] = $afegirCarta; }
                                echo $_SESSION['adicionals'][$compt4][$afegirCarta]['carta']." de ".$_SESSION['adicionals'][$compt4][$afegirCarta]['figura']; ?> <br> <?php
                            }
                            if ($cartaEscollida === false) { ?>
                                <button name="btnAgafarAdicional<?php echo $compt4+1; ?>" type="submit">Agafar carta [<?php echo $compt4+1; ?>]</button> <?php
                            }
                            else {
                                $seguentCarta = array_search($_SESSION['cartaEscollida'][0], $cartes);
                                if ($seguentCarta < 12) {
                                    $seguentCarta = $cartes[$seguentCarta+1];
                                    if ($_SESSION['cartaEscollida'][1] === "Cors" || $_SESSION['cartaEscollida'][1] === "Diamants") {
                                        if ($_SESSION['adicionals'][$compt4][$_SESSION['ultimaCartaAdicionals'][$compt4]]['carta'] === $seguentCarta && ($_SESSION['adicionals'][$compt4][$_SESSION['ultimaCartaAdicionals'][$compt4]]['figura'] === "Trèvols" || $_SESSION['adicionals'][$compt4][$_SESSION['ultimaCartaAdicionals'][$compt4]]['figura'] === "Piques")) { ?>
                                            <button name="btnAfegirAdicional<?php echo $compt4+1; ?>" type="submit">Afegir carta [<?php echo $compt4+1; ?>]</button> <?php
                                        }
                                    }
                                    else {
                                        if ($_SESSION['adicionals'][$compt4][$_SESSION['ultimaCartaAdicionals'][$compt4]]['carta'] === $seguentCarta && ($_SESSION['adicionals'][$compt4][$_SESSION['ultimaCartaAdicionals'][$compt4]]['figura'] === "Cors" || $_SESSION['adicionals'][$compt4][$_SESSION['ultimaCartaAdicionals'][$compt4]]['figura'] === "Diamants")) { ?>
                                            <button name="btnAfegirAdicional<?php echo $compt4+1; ?>" type="submit">Afegir carta [<?php echo $compt4+1; ?>]</button> <?php
                                        }
                                    }
                                }
                            }
                        } ?> </span> <?php
                    }
                    else { ?>
                        <span style="display: inline-block; vertical-align: top; padding-right: 15px;"> <?php
                            for ($compt5 = 0; $compt5 < sizeof($columns); $compt5++) {
                                if ($compt5 === sizeof($columns)-1) {
                                    $_SESSION['ultimaCartaColumnes'][$compt4] = $compt5;
                                    echo $_SESSION['columnes'][$compt4][$compt5]['carta']." de ".$_SESSION['columnes'][$compt4][$compt5]['figura']; ?> <br> <?php
                                }
                                else { echo "???"; ?> <br> <?php }
                            }
                            if (!empty($_SESSION['adicionals'][$compt4])) {
                                for ($compt6 = 0; $compt6 < sizeof($_SESSION['adicionals'][$compt4]); $compt6++) {
                                    $_SESSION['ultimaCartaAdicionals'][$compt4] = $compt6;
                                    echo $_SESSION['adicionals'][$compt4][$compt6]['carta']." de ".$_SESSION['adicionals'][$compt4][$compt6]['figura']; ?> <br> <?php
                                }
                            }
                            if ($cartaEscollida === false) {
                                if (empty($_SESSION['adicionals'][$compt4])) { ?>
                                    <button name="btnAgafarColumna<?php echo $compt4+1; ?>" type="submit">Agafar carta [<?php echo $compt4+1; ?>]</button> <?php
                                }
                                else { ?>
                                    <button name="btnAgafarAdicional<?php echo $compt4+1; ?>" type="submit">Agafar carta [<?php echo $compt4+1; ?>]</button> <?php
                                }
                            }
                            else {
                                $seguentCarta = array_search($_SESSION['cartaEscollida'][0], $cartes);
                                if ($seguentCarta < 12) {
                                    $seguentCarta = $cartes[$seguentCarta+1];
                                    if ($_SESSION['cartaEscollida'][1] === "Cors" || $_SESSION['cartaEscollida'][1] === "Diamants") {
                                        if (empty($_SESSION['adicionals'][$compt4])) {
                                            if ($_SESSION['columnes'][$compt4][$_SESSION['ultimaCartaColumnes'][$compt4]]['carta'] === $seguentCarta && ($_SESSION['columnes'][$compt4][$_SESSION['ultimaCartaColumnes'][$compt4]]['figura'] === "Trèvols" || $_SESSION['columnes'][$compt4][$_SESSION['ultimaCartaColumnes'][$compt4]]['figura'] === "Piques")) { ?>
                                                <button name="btnAfegirAdicional<?php echo $compt4+1; ?>" type="submit">Afegir carta [<?php echo $compt4+1; ?>]</button> <?php
                                            }
                                        }
                                        else {
                                            if ($_SESSION['adicionals'][$compt4][$_SESSION['ultimaCartaAdicionals'][$compt4]]['carta'] === $seguentCarta && ($_SESSION['adicionals'][$compt4][$_SESSION['ultimaCartaAdicionals'][$compt4]]['figura'] === "Trèvols" || $_SESSION['adicionals'][$compt4][$_SESSION['ultimaCartaAdicionals'][$compt4]]['figura'] === "Piques")) { ?>
                                                <button name="btnAfegirAdicional<?php echo $compt4+1; ?>" type="submit">Afegir carta [<?php echo $compt4+1; ?>]</button> <?php
                                            }
                                        }
                                    }
                                    else {
                                        if (empty($_SESSION['adicionals'][$compt4])) {
                                            if ($_SESSION['columnes'][$compt4][$_SESSION['ultimaCartaColumnes'][$compt4]]['carta'] === $seguentCarta && ($_SESSION['columnes'][$compt4][$_SESSION['ultimaCartaColumnes'][$compt4]]['figura'] === "Cors" || $_SESSION['columnes'][$compt4][$_SESSION['ultimaCartaColumnes'][$compt4]]['figura'] === "Diamants")) { ?>
                                                <button name="btnAfegirAdicional<?php echo $compt4+1; ?>" type="submit">Afegir carta [<?php echo $compt4+1; ?>]</button> <?php
                                            }
                                        }
                                        else {
                                            if ($_SESSION['adicionals'][$compt4][$_SESSION['ultimaCartaAdicionals'][$compt4]]['carta'] === $seguentCarta && ($_SESSION['adicionals'][$compt4][$_SESSION['ultimaCartaAdicionals'][$compt4]]['figura'] === "Cors" || $_SESSION['adicionals'][$compt4][$_SESSION['ultimaCartaAdicionals'][$compt4]]['figura'] === "Diamants")) { ?>
                                                <button name="btnAfegirAdicional<?php echo $compt4+1; ?>" type="submit">Afegir carta [<?php echo $compt4+1; ?>]</button> <?php
                                            }
                                        }
                                    }
                                }
                            } ?>
                        </span> <?php
                    }
                    $compt4++;
                } ?>
                <br><br><br><button name="btnExit" type="submit">Nova Partida</button>
            </form> <?php
        }
        else {
            session_unset();
            session_destroy();
            header('Location: solitari.php');
        } ?>
    </body>
</html>