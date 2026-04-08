function toTipusOracio() {
    var abecedari = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "á", "à", "é", "è", "í", "ò", "ó", "ú", "Á", "À", "É", "È", "Í", "Ó", "Ò", "Ú", "ç", "Ç"];
    var cadena = "";
    cadena = prompt("Introdueix la frase a majuscular:");
    var frase = cadena.split(".");
    var novaCadena = "";
    frase.forEach(function(valor, index) {
        var majuscula = false;
        for (var compt = 0; compt < valor.length; compt++) {
            if (index !== 0) {
                if (compt === 0) { novaCadena += ". "; }
            }
            if (abecedari.includes(valor.charAt(compt)) === true) {
                if (majuscula === false) {
                    novaCadena += valor.charAt(compt).toUpperCase();
                    majuscula = true;
                }
                else { novaCadena += valor.charAt(compt).toLowerCase(); }
            }
            else { novaCadena += valor.charAt(compt); }
        }
    });
    document.getElementById("resultat").innerHTML=novaCadena;
}