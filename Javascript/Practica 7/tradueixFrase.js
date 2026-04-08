function tradueixFrase() {
    var consonants = ["b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "ñ", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z", "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "Ñ", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z", "ç", "Ç"];
    var cadena = "";
    cadena = prompt("Introdueix la frase a traduir:");
    var paraules = cadena.split(" ");
    var novaCadena = "";
    paraules.forEach(function(valor, index) {
        for (var compt = 0; compt < valor.length; compt++) {
            if (index !== 0) {
                if (compt === 0) { novaCadena += " "; }
            }
            if (consonants.includes(valor.charAt(compt)) === true) {
                novaCadena += valor.charAt(compt)+"e";
            }
            novaCadena += valor.charAt(compt);
        }
    });
    document.getElementById("resultat").innerHTML=novaCadena;
}
