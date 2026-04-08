function intercanviar(arrayIn, esquerra, dreta) {
    var temp = Object;
    if (dreta === esquerra) {
        return;
    }
    temp = arrayIn[esquerra];
    arrayIn[esquerra] = arrayIn[dreta];
    arrayIn[dreta] = temp;
}

function dividirArray(arrayIn, esquerra, dreta, pivot) {
    var punterE = esquerra -1;
    var punterD = dreta;
    while (true) {
        for (var compt = arrayIn(punterE); compt < pivot; compt++) {
            punterE++;
        }
        for (compt = punterD; compt > 0 && arrayIn[punterD] > pivot; compt--) {
            punterD--;
        }
        if (punterE >= punterD) {
            break;
        }
        else {
            intercanviar(arrayIn, punterE, punterD);
        }
    }
    intercanviar(arrayIn, punterE, dreta);
    return punterE;
}

function ordenamentRapid(arrayIn, esquerra, dreta) {
    var pivot = arrayIn[dreta];
    var particio = dividirArray(arrayIn, esquerra, dreta, pivot);
    ordenamentRapid(arrayIn, esquerra, particio-1);
    ordenamentRapid(arrayIn, particio+1, dreta);
}