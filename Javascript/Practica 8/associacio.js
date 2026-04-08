function associacio() {
    var taula = afegirElement(document.body, "table");
    taula.border = 1;
    taula.style = "font-family: 'Arial';";
    var capçalera = afegirElement(taula, "tr");
    afegirElement(capçalera, "th", "Dates");
    afegirElement(capçalera, "th", "Lloc");
    afegirElement(capçalera, "th", "+Info");
    capçalera.style = "font-weight: bold; font-size: 20px;";
    var anyActual = new Date().getFullYear();
    var avui = new Date();
    avui.setMonth(0);
    while (avui.getFullYear() === anyActual) {
        var fila = afegirElement(taula, "tr");
        var data = "";
        var dia = 0;
        var mes = 0;
        if (avui.getMonth() === 0 || avui.getMonth() === 2 || avui.getMonth() === 4 || avui.getMonth() === 6 || avui.getMonth() === 7 || avui.getMonth() === 9 || avui.getMonth() === 11) {
            avui.setDate(24);
            mes = 31;
        }
        else if (avui.getMonth() === 3 || avui.getMonth() === 5 || avui.getMonth() === 8 || avui.getMonth() === 10) {
            avui.setDate(23);
            mes = 30;
        }
        else if (avui.getMonth() === 1) {
            if ((anyActual % 4 === 0) && ((anyActual % 100 !== 0) || (anyActual % 400 === 0))) {
                avui.setDate(22);
                mes = 29;
            }
            else {
                avui.setDate(21);
                mes = 28;
            }
        }
        while (avui.getDay() !== 5) {
            avui.setDate(avui.getDate()+1);
        }
        if (mes === 28) { if (avui.getDate() <= 21) { avui.setDate(avui.getDate()+7); } }
        else if (mes === 29) { if (avui.getDate() <= 22) { avui.setDate(avui.getDate()+7); } }
        else if (mes === 30) { if (avui.getDate() <= 23) { avui.setDate(avui.getDate()+7); } }
        else if (mes === 31) { if (avui.getDate() <= 24) { avui.setDate(avui.getDate()+7); } }
        dia = avui.getDate();
        var mesCanvi = avui.getMonth()+1;
        data = dia+"/"+mesCanvi+"/"+anyActual;
        afegirElement(fila, "td", data);
        if (mes === dia) { afegirElement(fila, "td", "Institut"); }
        else { afegirElement(fila, "td", "Centre Cívic"); }
        if (dia % 3 === 0 && mes !== dia) { afegirElement(fila, "td", "Xerrada"); }
        else { afegirElement(fila, "td", ""); }
        avui.setDate(1);
        avui.setMonth(mesCanvi);
    }
}

function afegirElement(pare, tipus, text){
    var element = document.createElement(tipus);
    pare.appendChild(element);
    if(text){
        element.appendChild( document.createTextNode(text));
    }
    return element;
}