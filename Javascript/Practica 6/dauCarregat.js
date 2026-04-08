/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function dauCarregat() {
    do {
        var jugades = parseInt((prompt("Quantes partides vols jugar?")));
    } while (isNaN(jugades));
    var guanyades = 0;
    var perdudes = 0;
    var apostat = 0;
    for (var compt = 0; compt < jugades; compt++) {
        if (Math.random() <= 0.1) {
            guanyades++;
            apostat += 80;
        }
        else {
            perdudes++;
            apostat -= 20;
        }
    }
    if (apostat >= 0) {
        var cadena = "Ha guanyat "+apostat+"€ jugant "+jugades+" vegades!";
        document.getElementById("resultat").innerHTML=cadena;
    }
    else {
        var cadena = "Ha perdut "+apostat+"€ jugant "+jugades+" vegades!";
        document.getElementById("resultat").innerHTML=cadena;
    }
}