<html>
    <head>
        <title>Bingo!!</title>
        <meta charset="UTF-8">
    </head>
    <body> <?php
        require_once('./funcionsBingo.php');
        $cartrons = funcionsBingo::ferCartro(6);
        $bombo = array();
        $guanyador = false;
        $seguentJugador = false;
        $cartroGuanyador;
        while ($guanyador === false) {
            $bombo = funcionsBingo::bombo($bombo);
            foreach ($cartrons as $key1 => $cartro) {
                $seguentJugador = false;
                foreach ($cartro['numeros'] as $nums) {
                    foreach ($nums as $num) {
                        if (!in_array($num, $bombo)) {
                            $seguentJugador = true;
                            break(2);
                        }
                    }
                }
                if ($seguentJugador === false) {
                    $guanyador = true;
                    $cartroGuanyador = $key1+1;
                    break(1);
                }
            }
        }
        var_dump($bombo);
        echo "El guanyador és el cartró ".$cartroGuanyador." amb ".count($bombo)." boles!!!! Felicitats :D";?>
    </body>
</html>