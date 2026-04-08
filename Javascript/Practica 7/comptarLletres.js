function comptarLletres() {
    var abecedari = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "á", "à", "é", "è", "í", "ò", "ó", "ú", "Á", "À", "É", "È", "Í", "Ó", "Ò", "Ú", "ç", "Ç"];
    var cadena = "";
    cadena = prompt("Introdueix la frase a girar:");
    var paraules = cadena.split(" ");
    var numLletres = 0;
    paraules.forEach(function(valor) {
        for (var compt = 0; compt < valor.length; compt++) {
            if (abecedari.includes(valor.charAt(compt)) === true) { numLletres++; }
        }
    });
    document.getElementById("resultat").innerHTML="La frase '"+cadena+"' té "+numLletres+" lletres.";
}