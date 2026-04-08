/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function moneda() {
	var aleatori = Math.random()*0.5;
        var cadena = "La probabilitat de que surti creu es "+aleatori+".\n";
        if (Math.random() < aleatori) { cadena += "Creu"; }
        else { cadena += "Cara"; }
	document.getElementById("resultat").innerHTML=cadena;
}