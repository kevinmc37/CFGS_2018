function palindrom() {
    var palindrom = false;
    var cadena = "";
    cadena = prompt("Introdueix la frase:");
    cadena = cadena.toString();
    var novaCadena = "";
    for (var compt = 0; compt < cadena.length; compt++) {
        novaCadena += cadena.charAt(cadena.length-(compt+1));
    }
    if (cadena.toLowerCase() === novaCadena.toLowerCase()) { palindrom = true; }
    var form = document.createElement("form");
    var label = document.createElement("label");
    var paragraf = document.createElement("p");
    var frase = paragraf;
    document.body.appendChild(form);
    frase.setAttribute("id", "frase");
    label.setAttribute("for", "frase");
    form.appendChild(label);
    label.appendChild(document.createTextNode("Frase:"));
    form.appendChild(frase);
    frase.appendChild(document.createTextNode(cadena));
    form.appendChild(paragraf);
    if (palindrom === true) { paragraf.appendChild(document.createTextNode("\nLa frase és un palíndrom.")); }
    else { paragraf.appendChild(document.createTextNode("\nLa frase no és un palíndrom.")); }
}