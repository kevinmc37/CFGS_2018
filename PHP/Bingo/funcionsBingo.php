<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of funcions
 *
 * @author guest-mzjbm8
 */
class funcionsBingo {
    
    public static function ferCartro($numCartrons) {
        $cartroNou = array();
        $arrayCartrons = array(
            'numeros'=>array(),
            'caselles'=>array()
        );
            for ($cartrons = 0; $cartrons < $numCartrons; $cartrons++) {
                $arrayCartrons['numeros'] = array();
                $arrayCartrons['caselles'] = array();
            $numeros = array(
                array(0,0,0,0,0,0,0,0,0),
                array(0,0,0,0,0,0,0,0,0),
                array(0,0,0,0,0,0,0,0,0)
            );
            $caselles = array(
                array(0,0,0,0),
                array(0,0,0,0),
                array(0,0,0,0)
            );
            for ($compt = 0; $compt < count($numeros); $compt++) {
                $casella = 0;
                for ($compt2 = 0; $compt2 < count($numeros[$compt]); $compt2++) {
                    $num = rand(1, 99);
                    while ((in_array($num, $numeros[0])) || (in_array($num, $numeros[1])) || (in_array($num, $numeros[2]))) {
                        $num = rand(1, 99);
                    }
                    $numeros[$compt][$compt2] = $num;
                }
                for ($compt3 = 0; $compt3 < 4; $compt3++) {
                    $casella = rand(1, 9);
                    while (in_array($casella, $caselles[$compt])) {
                        $casella = rand(1, 9);
                    }
                    $caselles[$compt][$compt3] = $casella;
                }
                sort($numeros[$compt]);
                sort($caselles[$compt]);
                if ($compt > 0) {
                    while (($caselles[0] == $caselles[1]) || ($caselles[0] == $caselles[2]) || ($caselles[1] == $caselles[2])) {
                        $casella = rand(1, 9);
                        while ((in_array($casella, $caselles[1])) || (in_array($casella, $caselles[2]))) {
                            $casella = rand(1, 9);
                        }
                        $caselles[$compt][0] = $casella;
                    }
                    sort($caselles[$compt]);
                }
            }
            $arrayCartrons['numeros'] = $numeros;
            $arrayCartrons['caselles'] = $caselles;
            $cartroNou[] = $arrayCartrons;
        }
        //var_dump($cartroNou);
        
        foreach ($cartroNou as $key => $nouBingo) { ?>
            <table border="1px"> <?php 
            for ($compt = 0; $compt < 3; $compt++) {
                $comptCasella = 0; ?>
                <tr> <?php
                    for ($compt1 = 0; $compt1 < 9; $compt1++) {
                        if (($comptCasella < 4) && ($nouBingo['caselles'][$compt][$comptCasella]-1 == $compt1)) { ?>
                            <td width="66px" height="66px"></td> <?php
                            $comptCasella++;
                        }
                        else { ?>
                            <td width="66px" height="66px"><?php echo $nouBingo['numeros'][$compt][$compt1] ?></td> <?php
                        }
                    } ?>
                </tr> <?php
            } ?>
            </table><br> <?php
        }
        return $cartroNou;
    }
    public static function bombo($bombo) {
        $num = rand(1, 99);
        while (in_array($num, $bombo)) {
            $num = rand(1, 99);
        }
        $bombo[] = $num;
        return $bombo;
    }
}