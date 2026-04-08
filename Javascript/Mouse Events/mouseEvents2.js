/* Crearem una funció que cridarem quan fem click al div blau amb id main
 * i ens generarà una sèrie d'elements div al punt en que hem fet click */

function createElements(event) {
    for (var compt = 0; compt < 600; compt++) {
        var dot = document.createElement("div");
        dot.className = "trail";
        dot.style.left = event.pageX-30 + "px";
        dot.style.top = event.pageY-30 + "px";
        var randomColor = "rgb(" + (Math.floor(Math.random() * 256)) + "," + (Math.floor(Math.random() * 256)) + "," + (Math.floor(Math.random() * 256)) + ")";
        dot.style.background = randomColor;
        // event.target.appendChild(dot);
        divPrinc.appendChild(dot);
    }
    properDiv = divPrinc.children.length-1;
    afegirListenerMouse();
    eliminarListenerClick();
}

function afegirListenerMouse() {
    divPrinc.addEventListener("mousemove", function(event) {
       event.preventDefault();
       pageLeft = event.pageX - 30;
       pageTop = event.pageY - 30;
    });
    requestAnimationFrame(moveDiv); // Crida l'animació
}

function eliminarListenerClick() {
    divPrinc.removeEventListener("click", createElements);
}

function afegirListenerClick() {
    /* Només farà click a dins del main. A fora no afegirà punts */
    divPrinc = document.getElementById("main");
    divPrinc.addEventListener("click", createElements);
}

function moveDiv(timestamp) {
    var divs = divPrinc.children;
    var dot = divs[properDiv];
    dot.style.left = pageLeft + "px";
    dot.style.top = pageTop + "px";
    properDiv--;
    properDiv = (divs.length+properDiv) % divs.length;
    requestAnimationFrame(moveDiv);
}

var divPrinc;
var properDiv;
var pageTop;
var pageLeft;

afegirListenerClick();