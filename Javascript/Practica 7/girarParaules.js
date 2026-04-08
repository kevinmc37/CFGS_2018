function girarParaules() {
    var cadena = "";
    cadena = prompt("Introdueix la frase a girar:");
    var paraules = cadena.split(" ");
    var novaCadena = "";
    paraules.forEach(function(valor) {
        novaCadena = valor.concat(" "+novaCadena);
    });
    document.getElementById("resultat").innerHTML=novaCadena;
}