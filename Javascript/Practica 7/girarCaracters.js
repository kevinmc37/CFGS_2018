function girarCaracters() {
    var cadena = "";
    cadena = prompt("Introdueix la frase a girar:");
    var novaCadena = "";
    for (var compt = 0; compt < cadena.length; compt++) {
        novaCadena += cadena.charAt(cadena.length-(compt+1));
    }
    document.getElementById("resultat").innerHTML=novaCadena;
}