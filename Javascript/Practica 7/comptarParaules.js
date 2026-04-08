function comptarParaules() {
    var cadena = "";
    cadena = prompt("Introdueix la frase a comptar:");
    var paraules = cadena.split(" ");
    var compt = 0;
    paraules.forEach(function() {
        compt++;
    });
    document.getElementById("resultat").innerHTML=compt+" paraules.";
}