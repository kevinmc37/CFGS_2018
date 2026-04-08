function createElementsTaulell(taulell, numFiles, numColumnes) {
    var imatges = carregarRutaImatges();
    for (var compt = 0; compt < numFiles; compt++) {
        for (var compt1 = 0; compt1 < numColumnes; compt1++) {
            var li = document.createElement("li");
            li.fila = compt;
            li.columna = compt1;
            li.style.backgroundColor = COLOR_DEFAULT;
            var img = document.createElement("img");
            img.src = imatges[calcularIndexLineal(compt, compt1)];
            li.appendChild(img);
            taulell.appendChild(li);
        }
    }
    selectedA = taulell.firstChild;
    selectedA.style.backgroundColor = COLOR_SELECTED_A;
    selectedB = taulell.lastChild;
    selectedB.style.backgroundColor = COLOR_SELECTED_B;
}

function up(jugador) {
    var objActual = selectedLi(jugador);
    moure(jugador, objActual, -1, 0);
}

function down(jugador) {
    var objActual = selectedLi(jugador);
    moure(jugador, objActual, 1, 0);
}

function right(jugador) {
    var objActual = selectedLi(jugador);
    moure(jugador, objActual, 0, 1);
}

function left(jugador) {
    var objActual = selectedLi(jugador);
    moure(jugador, objActual, 0, -1);
}

function selectedLi(jugador) {
    var li;
    var color;
    if (jugador === "A") {
        li = selectedA;
        color = COLOR_SELECTED_A;
    }
    else {
        li = selectedB;
        color = COLOR_SELECTED_B;
    }
    return { "li":li,"selectedColor":color }; // JSON
}

function reajustarValor(valorIn, valorMax) {
    return ((valorIn + valorMax) % valorMax);
}

function pucMoure(jugador, liDesti) {
    if (jugador === "A") {
        return liDesti !== selectedB;
    }
    else {
        return liDesti !== selectedA;
    }
}

function moure(jugador, selectedLi, incrementFila, incrementColumna) {
    var fila = reajustarValor(selectedLi.li.fila+incrementFila, NUM_COLUMNES);
    var columna = reajustarValor(selectedLi.li.columna+incrementColumna, NUM_FILES);
    var liDesti = taulell.childNodes[calcularIndexLineal(fila, columna)];
    if (pucMoure(jugador, liDesti)) {
        selectedLi.li.style.backgroundColor = COLOR_DEFAULT;
        selectedLi.li.classList.remove("girar");
        liDesti.style.backgroundColor = selectedLi.selectedColor;
        liDesti.classList.add("girar");
        if (jugador === "A") {
            selectedA = liDesti;
        }
        else {
            selectedB = liDesti;
        }
    }
}

function calcularIndexLineal(fila, columna) {
    return fila * NUM_COLUMNES + columna;
}

function carregarRutaImatges() {
    var image = new Array();
    for (var compt = 1; compt < 41; compt++) {
        var str = "0"+compt;
        str = str.substring(str.length-2, str.length);
        image.push("img/img_" + str + ".png");
    }
    return shuffle(image);
}

function shuffle(array) {
    var numElem = array.length;
    while (numElem) {
        var i = Math.floor(Math.random() * numElem--);
        var t = array[numElem];
        array[numElem] = array[i];
        array[i] = t;
    }
    return array;
}

var COLOR_DEFAULT = "teal";
var NUM_FILES = 5;
var NUM_COLUMNES = 5;

var selectedA, selectedB;
var COLOR_SELECTED_A = "red";
var COLOR_SELECTED_B = "yellow";

var POSICIO = "0-0";

var taulell = document.createElement("ul");
document.getElementById("main").appendChild(taulell);

createElementsTaulell(taulell, NUM_FILES, NUM_COLUMNES);

addEventListener("keydown", function(event) {
    if (event.code === "F5") { return; }
    event.preventDefault();
    switch (event.code) {
        // Jugador A
        case "ArrowUp":
            up("A");
            break;
        case "ArrowDown":
            down("A");
            break;
        case "ArrowRight":
            right("A");
            break;
        case "ArrowLeft":
            left("A");
            break;
        // Jugador B
        case "KeyW":
            up("B");
            break;
        case "KeyS":
            down("B");
            break;
        case "KeyD":
            right("B");
            break;
        case "KeyA":
            left("B");
            break;
    }
});

/*<script>
    document.getElementById("demo").addEventListener("keydown", myFunction);

    function myFunction(e) {
        document.getElementById("demo").style.backgroundColor = "red";
        document.getElementById("demo").value = e.code;
    }
</script>*/