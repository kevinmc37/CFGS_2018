<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <title>Formularis :p</title>
    </head>
    <body> <?php
        $jugadors_de_lacrosse = array( "Billy Bitter", "Chris Bocklet", "Jeremy Boltus" );
        $jugadors_de_pilota_basca = array( "Iñaqui" );
        $esports = array();
        $esports["Lacrosse"] = $jugadors_de_lacrosse;
        $esports["Pilota Basca"] = $jugadors_de_pilota_basca;
        foreach( $esports as $esport => $jugadors ) {
            echo "Els meu jugadors preferits de $esport són:<br>";
            foreach ($jugadors as $nom) {
                echo $nom."<br>";
            }
            echo "<br>"; 
        } ?>
    </body>
</html>