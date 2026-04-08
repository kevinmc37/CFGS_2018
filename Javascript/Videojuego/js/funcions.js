function getRule() {
    // Gets animation's keyframes
    var rule;
    var ss = document.styleSheets;
    for (var i = 0; i < ss.length; ++i) {
        for (var x = 0; x < ss[i].cssRules.length; ++x) {
            rule = ss[i].cssRules[x];
            if (rule.name === "rotate" && rule.type === CSSRule.KEYFRAMES_RULE) { rotateAnimation = rule; }
            else if (rule.name === "jump" && rule.type === CSSRule.KEYFRAMES_RULE) { jumpAnimation = rule; }
            else if (rule.name === "fall" && rule.type === CSSRule.KEYFRAMES_RULE) { fallAnimation = rule; }
            else if (rule.name === "move" && rule.type === CSSRule.KEYFRAMES_RULE) { moveAnimation = rule; }
            else if (rule.name === "moveMonster" && rule.type === CSSRule.KEYFRAMES_RULE) { moveMonsterAnimation = rule; }
        }
    }
}

function prepararMenu() {
    main = document.getElementById("main");
    contingut = document.createElement("div");
    contingut.setAttribute("class", "contingut");
    main.appendChild(contingut);
    
    // Background
    var background = document.createElement("img");
    background.setAttribute("src", "images/twilight.png");
    background.setAttribute("class", "bgLevel");
    
    // Clouds
    var cloud1 = document.createElement("img");
    cloud1.setAttribute("src", "images/cloud2.png");
    cloud1.setAttribute("class", "cloud");
    $(cloud1).css("right", 600);
    var cloud2 = document.createElement("img");
    cloud2.setAttribute("src", "images/cloud1.png");
    cloud2.setAttribute("class", "cloud");
    $(cloud2).css("right", 25);
    var cloud3 = document.createElement("img");
    cloud3.setAttribute("src", "images/cloud1.png");
    cloud3.setAttribute("class", "cloud");
    $(cloud3).css("right", -550);
    contingut.appendChild(background);
    contingut.appendChild(cloud1);
    contingut.appendChild(cloud2);
    contingut.appendChild(cloud3);
    
    // Moving clouds
    setInterval(function() {
        var counter = 5;
        var width1 = $(cloud1).css("right");
        width1 = parseInt(width1.substring(0, width1.length - 2));
        $(cloud1).css("right", counter+width1);
        var width2 = $(cloud2).css("right");
        width2 = parseInt(width2.substring(0, width2.length - 2));
        $(cloud2).css("right", counter+width2);
        var width3 = $(cloud3).css("right");
        width3 = parseInt(width3.substring(0, width3.length - 2));
        $(cloud3).css("right", counter+width3);
        if ($(cloud1).css("right") === 1000 + "px") { $(cloud1).css("right", -600); }
        else if ($(cloud2).css("right") === 1000 + "px") { $(cloud2).css("right", -600); }
        else if ($(cloud3).css("right") === 1000 + "px") { $(cloud3).css("right", -600); }
    }, 1000);
    
    // Coin box
    var capsaMonedes = document.createElement("div");
    capsaMonedes.classList.add("styleMonedes");
    var imgMonedes = document.createElement("img");
    imgMonedes.setAttribute("src", "images/coin.png");
    var numMonedes = document.createElement("div");
    numMonedes.setAttribute("id", "numMonedes");
    numMonedes.innerHTML = monedes;
    capsaMonedes.appendChild(imgMonedes);
    capsaMonedes.appendChild(numMonedes);
    contingut.appendChild(capsaMonedes);
    crearMenu();
    mostrarMenu();
}

function crearMenu() {
    // Menu options
    $(".controls").css("display", "none");
    $(".synopsis").css("display", "none");
    $(".menu").css("display", "none");
    var menu = document.createElement("div");
    menu.setAttribute("class", "menu");
    contingut.appendChild(menu);
    
    var coinImg = document.createElement("img");
    coinImg.setAttribute("src", "images/coin.png");
    $(coinImg).css("margin-left", 10);
    
    var titol = document.createElement("div");
    titol.setAttribute("class", "titol");
    titol.innerHTML = "Insert Coin";
    
    var opcions = document.createElement("div");
    opcions.setAttribute("class", "opcions");
    var start = document.createElement("div");
    start.setAttribute("onclick", "startGame();");
    start.innerHTML += "Start";
    start.appendChild(coinImg);
    start.innerHTML += "x5";
    var controls = document.createElement("div");
    controls.setAttribute("onclick", "mostrarControls();");
    controls.innerHTML += "Controls";
    controls.appendChild(coinImg);
    controls.innerHTML += "x5";
    var synopsis = document.createElement("div");
    synopsis.setAttribute("onclick", "mostrarSynopsis();");
    synopsis.innerHTML = "Synopsis";
    synopsis.appendChild(coinImg);
    synopsis.innerHTML += "x5";
    
    menu.appendChild(titol);
    opcions.appendChild(start);
    opcions.appendChild(controls);
    opcions.appendChild(synopsis);
    menu.appendChild(opcions);
    crearControls(coinImg);
    crearSynopsis(coinImg);
}

function crearControls(coinImg) {
    // Control's page
    var controlsContent = document.createElement("div");
    controlsContent.setAttribute("class", "controls");
    var descripcioControls = document.createElement("div");
    descripcioControls.setAttribute("class", "descripcioControls");
    
    // Arrow Keys
    var arrowImg = document.createElement("img");
    arrowImg.setAttribute("src", "images/arrowKeys.png");
    var arrowKeys = document.createElement("div");
    arrowKeys.appendChild(arrowImg);
    arrowKeys.innerHTML += " Move Left | Inspect | Move Right.";
    arrowKeys.appendChild(coinImg);
    arrowKeys.innerHTML += "x1";
    descripcioControls.appendChild(arrowKeys);
    
    // A-D Keys (Dash)
    var dashLeft = document.createElement("img");
    dashLeft.setAttribute("src", "images/keyA.png");
    var dashRight = document.createElement("img");
    dashRight.setAttribute("src", "images/keyD.png");
    var dashKeys = document.createElement("div");
    dashKeys.appendChild(dashLeft);
    dashKeys.appendChild(dashRight);
    dashKeys.innerHTML += " Dash Left | Dash Right.";
    dashKeys.appendChild(coinImg);
    dashKeys.innerHTML += "x2";
    descripcioControls.appendChild(dashKeys);
    
    // Spacebar (Jump)
    var spaceImg = document.createElement("img");
    spaceImg.setAttribute("src", "images/spacebar.png");
    var spacebar = document.createElement("div");
    spacebar.appendChild(spaceImg);
    spacebar.innerHTML += " Jump.";
    spacebar.appendChild(coinImg);
    spacebar.innerHTML += "x3";
    descripcioControls.appendChild(spacebar);
    
    // F5 (Restart)
    var restartImg = document.createElement("img");
    restartImg.setAttribute("src", "images/keyF5.png");
    var restart = document.createElement("div");
    restart.appendChild(restartImg);
    restart.innerHTML += " Restart Game. Free!";
    descripcioControls.appendChild(restart);
    
    // Back button
    var backButton = document.createElement("div");
    backButton.setAttribute("onclick", "mostrarMenu()");
    backButton.innerHTML += "Back.";
    backButton.appendChild(coinImg);
    backButton.innerHTML += "x5";
    $(backButton).css("margin-top", 50);
    
    controlsContent.appendChild(descripcioControls);
    controlsContent.appendChild(backButton);
    contingut.appendChild(controlsContent);
}

function crearSynopsis(coinImg) {
    // Synopsis' page
    var synopsisContent = document.createElement("div");
    synopsisContent.setAttribute("class", "synopsis");
    var descripcioSynopsis = document.createElement("div");
    descripcioSynopsis.setAttribute("class", "descripcioSynopsis");
    
    // Game synopsis
    descripcioSynopsis.innerHTML = "The world has arrived to its end because of capitalism. You are a black square who started to kill monsters for money. After a meeting with John Cena, you decide it's better to donate it all. You start an adventure to the charity, but you find you need to pay for EVERYTHING. Arrive to the charity without running out of coins and you win the game...?";
    
    // Back button
    var backButton = document.createElement("div");
    backButton.setAttribute("onclick", "mostrarMenu()");
    backButton.innerHTML += "Back.";
    backButton.appendChild(coinImg);
    backButton.innerHTML += "x5";
    $(backButton).css("margin-top", 105);
    
    synopsisContent.appendChild(descripcioSynopsis);
    synopsisContent.appendChild(backButton);
    contingut.appendChild(synopsisContent);
}

function mostrarMenu() {
    if (monedes > 0) {
        monedes -= 5;
        $("#numMonedes").text(monedes);
        $(".controls").css("display", "none");
        $(".synopsis").css("display", "none");
        $(".menu").css("display", "block");
    }
    else { alert("No money, restart the game"); }
}

function mostrarControls() {
    if (monedes > 0) {
        monedes -= 5;
        $("#numMonedes").text(monedes);
        $(".menu").css("display", "none");
        $(".controls").css("display", "block");
    }
    else { alert("No money, restart the game"); }
}

function mostrarSynopsis() {
    if (monedes > 0) {
        monedes -= 5;
        $("#numMonedes").text(monedes);
        $(".menu").css("display", "none");
        $(".synopsis").css("display", "block");
    }
    else { alert("No money, restart the game"); }
}
function startGame() {
    if (monedes > 0) {
        monedes -= 5;
        $("#numMonedes").text(monedes);
        $(".menu").css("display", "none");
        audio.setAttribute("src", "audio/crimson.mp3");
        audio.load();
        audio.play();
        getRule();
        playing = true;
        createLevel1();
    }
    else { alert("No money, restart the game"); }
}

function createLevel1() {
    numLevel++;
    level = document.createElement("div");
    level.classList.add("level");
    contingut.appendChild(level);
    for (var compt = 0; compt < NUM_FILES; compt++) {
        for (var compt1 = 0; compt1 < NUM_COLUMNES; compt1++) {
            var position = document.createElement("div");
            position.classList.add("position");
            position.fila = compt;
            position.columna = compt1;
            if ((compt === 10 && compt1 > 9) || (compt === 11 && (compt1 <= 9 && compt1 !== 0)) || (compt === 6 && compt1 === 0)) {
                position.classList.add("grass");
                position.classList.add("colisio");
            }
            else if ((compt === 11 && compt1 > 9) || (compt > 6 && compt1 === 0)) {
                position.classList.add("land");
                position.classList.add("colisio");
            }
            else if (compt === 9 && compt1 === 11) {
                position.classList.add("chest");
                position.coins = 51;
            }
            else if (compt === 9 && compt1 === 13) { position.classList.add("nail"); }
            else if (compt === 8 && compt1 === 17) { position.classList.add("star"); }
            else if (compt === 9 && compt1 === 17) { position.classList.add("door"); }
            level.appendChild(position);
        }
    }
    player = document.createElement("div");
    player.classList.add("player");
    startPosition = level.childNodes[calcularIndexLineal(10, 1)];
    positionPlayer = startPosition;
    positionPlayer.appendChild(player);
}

function createLevel2() {
    numLevel++;
    level = document.createElement("div");
    level.classList.add("level");
    contingut.appendChild(level);
    for (var compt = 0; compt < NUM_FILES; compt++) {
        for (var compt1 = 0; compt1 < NUM_COLUMNES; compt1++) {
            var position = document.createElement("div");
            position.classList.add("position");
            position.fila = compt;
            position.columna = compt1;
            if ((compt === 7 && (compt1 <= 7 && compt1 !== 0)) || (compt === 2 && compt1 === 0) || (compt === 7 && compt1 === 9) || (compt === 5 && compt1 === 11) || ((compt === 11 && (compt1 <= 9 && compt1 !== 0))) || (compt === 10 && compt1 > 9) || (compt === 3 && (compt1 >= 13 && compt1 < 19))) {
                position.classList.add("grass");
                position.classList.add("colisio");
            }
            else if ((compt === 11 && compt1 > 9) || (compt > 2 && compt1 === 0) || (compt === 8 && (compt1 > 2 && compt1 <= 5))) {
                position.classList.add("land");
                position.classList.add("colisio");
            }
            else if (compt === 6 && compt1 === 2) {
                position.classList.add("chest");
                position.coins = 21;
            }
            else if ((compt === 9 && compt1 === 4) || (compt === 6 && compt1 === 11) || (compt === 8 && (compt1 === 6 || compt1 === 7))) {
                position.classList.add("nailDown");
            }
            else if (compt === 9 && compt1 === 10) {
                monster = document.createElement("div");
                monster.classList.add("monsterRight");
                position.appendChild(monster);
                positionMonster = position;
            }
            else if (compt === 1 && compt1 === 17) { position.classList.add("star"); }
            else if (compt === 2 && compt1 === 17) { position.classList.add("door"); }
            level.appendChild(position);
        }
    }
    player = document.createElement("div");
    player.classList.add("player");
    startPosition = level.childNodes[calcularIndexLineal(10, 2)];
    positionPlayer = startPosition;
    positionPlayer.appendChild(player);
    monsterRight();
}

function finalLevel() {
    audio.setAttribute("src", "audio/wind.mp3");
    audio.load();
    audio.play();
    numLevel++;
    level = document.createElement("div");
    level.classList.add("level");
    contingut.appendChild(level);
    for (var compt = 0; compt < NUM_FILES; compt++) {
        for (var compt1 = 0; compt1 < NUM_COLUMNES; compt1++) {
            var position = document.createElement("div");
            position.classList.add("position");
            position.fila = compt;
            position.columna = compt1;
            if (compt === 6 && compt1 <= 16) {
                position.classList.add("grass");
                position.classList.add("colisio");
            }
            else if ((compt > 6 && compt1 <= 16) || compt1 === 19) {
                position.classList.add("land");
                position.classList.add("colisio");
            }
            else if (compt === 11 && compt1 === 17) { position.classList.add("colisio"); }
            else if (compt === 5 && compt1 === 16) { position.classList.add("jhon"); }
            level.appendChild(position);
        }
    }
    player = document.createElement("div");
    player.classList.add("player");
    startPosition = level.childNodes[calcularIndexLineal(5, 0)];
    positionPlayer = startPosition;
    positionPlayer.appendChild(player);
}

function monsterRight() {
    $(monster).empty();
    var monsterImg = document.createElement("img");
    monsterImg.setAttribute("src", "images/monsterRight.png");
    monster.appendChild(monsterImg);
    moveMonsterAnimation.deleteRule("1");
    moveMonsterAnimation.appendRule("to { transform: translateX(100%); }");
    var interval = setInterval(function() {
        var destiMonster = level.childNodes[calcularIndexLineal(positionMonster.fila, positionMonster.columna+1)];
        monster.classList.add("moveMonster");
        setTimeout(function() {
            monster.classList.remove("moveMonster");
            destiMonster.appendChild(monster);
            positionMonster = destiMonster;
        }, 240); // 10ms abans del animation duration (estil.css)
        if ((positionPlayer.fila === positionMonster.fila) && ((positionPlayer.columna === positionMonster.columna) || (positionPlayer.columna === positionMonster.columna-1) || (positionPlayer.columna === positionMonster.columna+1))) {
            dead = true;
            var explosionSound = document.createElement("audio");
            explosionSound.setAttribute("src", "audio/explosion.mp3");
            explosionSound.load();
            explosionSound.play();
            var explosionPlace = level.childNodes[calcularIndexLineal(positionPlayer.fila-1, positionPlayer.columna-1)];
            explosionPlace.appendChild(explosion);
            setTimeout(function() {
                explosionPlace.removeChild(explosion);
            }, 2000);
            startPosition.appendChild(player);
            positionPlayer = startPosition;
            isAnimating = false;
        }
        if (positionMonster.fila === 9 && positionMonster.columna === 19) {
            clearInterval(interval);
            monsterLeft();
        }
        if (numLevel === 3) { clearInterval(interval) }
    }, 245);
}

function monsterLeft() {
    $(monster).empty();
    var monsterImg = document.createElement("img");
    monsterImg.setAttribute("src", "images/monsterLeft.png");
    monster.appendChild(monsterImg);
    moveMonsterAnimation.deleteRule("1");
    moveMonsterAnimation.appendRule("to { transform: translateX(-100%); }");
    var interval = setInterval(function() {
        var destiMonster = level.childNodes[calcularIndexLineal(positionMonster.fila, positionMonster.columna-1)];
        monster.classList.add("moveMonster");
        setTimeout(function() {
            monster.classList.remove("moveMonster");
            destiMonster.appendChild(monster);
            positionMonster = destiMonster;
        }, 240); // 10ms abans del animation duration (estil.css)
        if ((positionPlayer.fila === positionMonster.fila) && ((positionPlayer.columna === positionMonster.columna) || (positionPlayer.columna === positionMonster.columna-1) || (positionPlayer.columna === positionMonster.columna+1))) {
            dead = true;
            var explosionSound = document.createElement("audio");
            explosionSound.setAttribute("src", "audio/explosion.mp3");
            explosionSound.load();
            explosionSound.play();
            var explosionPlace = level.childNodes[calcularIndexLineal(positionPlayer.fila-1, positionPlayer.columna-1)];
            explosionPlace.appendChild(explosion);
            setTimeout(function() {
                explosionPlace.removeChild(explosion);
            }, 2000);
            startPosition.appendChild(player);
            positionPlayer = startPosition;
            isAnimating = false;
        }
        if (positionMonster.fila === 9 && positionMonster.columna === 10) {
            clearInterval(interval);
            monsterRight();
        }
        if (numLevel === 3) { clearInterval(interval) }
    }, 245);
}

function moure(incrementFila, incrementColumna, animacio) {
    var fila = reajustarValor(positionPlayer.fila+incrementFila, NUM_FILES);
    var columna = reajustarValor(positionPlayer.columna+incrementColumna, NUM_COLUMNES);
    var desti = level.childNodes[calcularIndexLineal(fila, columna)];
    if (desti.classList.contains("nail") || desti.classList.contains("nailDown")) {
        if (monedes-1 > 0) { monedes--; }
        else { monedes = 0; }
        $("#numMonedes").text(monedes);
        var explosionSound = document.createElement("audio");
        explosionSound.setAttribute("src", "audio/explosion.mp3");
        explosionSound.load();
        explosionSound.play();
        var explosionPlace = level.childNodes[calcularIndexLineal(fila-1, columna-1)];
        explosionPlace.appendChild(explosion);
        setTimeout(function() {
            explosionPlace.removeChild(explosion);
        }, 2000);
        startPosition.appendChild(player);
        positionPlayer = startPosition;
        isAnimating = false;
    }
    else if (!(desti.classList.contains("colisio"))) {
        if (monedes-1 > 0) { monedes--; }
        else { monedes = 0; }
        $("#numMonedes").text(monedes);
        var moviment = "";
        if (animacio === "rotateRight") {
            moviment = "rotate";
            rotateAnimation.deleteRule("1");
            rotateAnimation.appendRule("to { transform: rotate(90deg) translateY(0%); }");
            $(player).css('transform-origin', 'bottom right');
        }
        else if (animacio === "rotateLeft") {
            moviment = "rotate";
            rotateAnimation.deleteRule("1");
            rotateAnimation.appendRule("to { transform: rotate(-90deg) translateY(0%); }");
            $(player).css('transform-origin', 'bottom left');
        }
        else if (animacio === "jumpRight") {
            moviment = "move";
            moveAnimation.deleteRule("1");
            moveAnimation.appendRule("to { transform: translateX(100%); }");
            $(player).css('transform-origin', 'center');
        }
        else if (animacio === "jumpLeft") {
            moviment = "move";
            moveAnimation.deleteRule("1");
            moveAnimation.appendRule("to { transform: translateX(-100%); }");
            $(player).css('transform-origin', 'center');
        }
        player.classList.add(moviment);
        void player.offsetWidth;
        setTimeout(function() {
            player.classList.remove(moviment);
            desti.appendChild(player);
            positionPlayer = desti;
            if (!(level.childNodes[calcularIndexLineal(fila+1, columna)].classList.contains("colisio"))) { fall(); }
            else { isAnimating = false; }
        }, 240); // 10ms abans del animation duration (estil.css)
    }
    else {
        isAnimating = false;
    }
}

function jump() {
    var nail = false;
    var moving = "";
    var keys = [];
    onkeydown = function(e) {
        keys[e.which] = e.type == 'keydown';
        if (keys[37]) { moving = "left"; }
        else if (keys[39]) { moving = "right"; }
        else if (keys[65]) { moving = "dashLeft"; }
        else if (keys[68]) { moving = "dashRight"; }
    }
    var fila = reajustarValor(positionPlayer.fila-1, NUM_FILES);
    var columna = positionPlayer.columna;
    var desti = level.childNodes[calcularIndexLineal(fila, columna)];
    if (desti.classList.contains("nail") || desti.classList.contains("nailDown")) {
        if (monedes-3 > 0) { monedes -= 3; }
        else { monedes = 0; }
        $("#numMonedes").text(monedes);
        var explosionSound = document.createElement("audio");
        explosionSound.setAttribute("src", "audio/explosion.mp3");
        explosionSound.load();
        explosionSound.play();
        var explosionPlace = level.childNodes[calcularIndexLineal(fila-1, columna-1)];
        explosionPlace.appendChild(explosion);
        setTimeout(function() {
            explosionPlace.removeChild(explosion);
        }, 2000);
        startPosition.appendChild(player);
        positionPlayer = startPosition;
        isAnimating = false;
    }
    else if (!(desti.classList.contains("colisio"))) {
        if (level.childNodes[calcularIndexLineal(fila-1, columna)].classList.contains("nail") || level.childNodes[calcularIndexLineal(fila-1, columna)].classList.contains("nailDown")) {
            if (monedes-3 > 0) { monedes -= 3; }
            else { monedes = 0; }
            $("#numMonedes").text(monedes);
            var explosionSound = document.createElement("audio");
            explosionSound.setAttribute("src", "audio/explosion.mp3");
            explosionSound.load();
            explosionSound.play();
            var explosionPlace = level.childNodes[calcularIndexLineal(fila-1, columna-1)];
            explosionPlace.appendChild(explosion);
            setTimeout(function() {
                explosionPlace.removeChild(explosion);
            }, 2000);
            startPosition.appendChild(player);
            positionPlayer = startPosition;
            isAnimating = false;
        }
        else {
            if (level.childNodes[calcularIndexLineal(fila-2, columna)].classList.contains("nail") || level.childNodes[calcularIndexLineal(fila-2, columna)].classList.contains("nailDown")) { nail = true; }
            if (monedes-3 > 0) { monedes -= 3; }
            else { monedes = 0; }
            $("#numMonedes").text(monedes);
            jumpAnimation.deleteRule("1");
            jumpAnimation.appendRule("to { transform: translateY(-100%); }");
            player.classList.add("jump");
            if (nail === false) {
                setTimeout(function() {
                    desti.appendChild(player);
                    positionPlayer = desti;
                    player.classList.remove("jump");
                }, 240); // 10ms abans del animation duration (estil.css)
            }
            else {
                setTimeout(function() {
                    player.classList.remove("jump");
                }, 240); // 10ms abans del animation duration (estil.css)
            }
            fila--;
            if (!(level.childNodes[calcularIndexLineal(fila, columna)].classList.contains("colisio"))) {
                if (level.childNodes[calcularIndexLineal(fila-1, columna)].classList.contains("nail") || level.childNodes[calcularIndexLineal(fila-1, columna)].classList.contains("nailDown")) {
                    var explosionSound = document.createElement("audio");
                    explosionSound.setAttribute("src", "audio/explosion.mp3");
                    explosionSound.load();
                    explosionSound.play();
                    var explosionPlace = level.childNodes[calcularIndexLineal(fila-1, columna-1)];
                    explosionPlace.appendChild(explosion);
                    setTimeout(function() {
                        explosionPlace.removeChild(explosion);
                    }, 2000);
                    startPosition.appendChild(player);
                    positionPlayer = startPosition;
                    isAnimating = false;
                }
                else {
                    desti = level.childNodes[calcularIndexLineal(fila, columna)]
                    jumpAnimation.deleteRule("1");
                    jumpAnimation.appendRule("to { transform: translateY(-200%); }");
                    player.classList.add("jump");
                    setTimeout(function() {
                        desti.appendChild(player);
                        positionPlayer = desti;
                        player.classList.remove("jump");
                    }, 240); // 10ms abans del animation duration (estil.css)
                    fila--;
                    if (!(level.childNodes[calcularIndexLineal(fila, columna)].classList.contains("colisio"))) {
                        desti = level.childNodes[calcularIndexLineal(fila, columna)];
                        jumpAnimation.deleteRule("1");
                        jumpAnimation.appendRule("to { transform: translateY(-300%); }");
                        player.classList.add("jump");
                        setTimeout(function() {
                            desti.appendChild(player);
                            positionPlayer = desti;
                            player.classList.remove("jump");
                            if (moving === "right" && !(level.childNodes[calcularIndexLineal(fila, columna+1)].classList.contains("colisio"))) {
                                jumpRight();
                            }
                            else if (moving === "left" && !(level.childNodes[calcularIndexLineal(fila, columna-1)].classList.contains("colisio"))) {
                                jumpLeft();
                            }
                            else if (moving === "dashRight") { dash(1); }
                            else if (moving === "dashLeft") { dash(-1); }
                            else { fall(); }
                        }, 240); // 10ms abans del animation duration (estil.css)
                    }
                    else {
                        setTimeout(function() {
                            if (moving === "right" && !(level.childNodes[calcularIndexLineal(fila+1, columna+1)].classList.contains("colisio"))) {
                                jumpRight();
                            }
                            else if (moving === "left" && !(level.childNodes[calcularIndexLineal(fila+1, columna-1)].classList.contains("colisio"))) {
                                jumpLeft();
                            }
                            else if (moving === "dashRight") { dash(1); }
                            else if (moving === "dashLeft") { dash(-1); }
                            else { fall(); }
                        }, 240);
                    }
                }
            }
            else {
                setTimeout(function() {
                    if (moving === "right" && !(level.childNodes[calcularIndexLineal(fila+1, columna+1)].classList.contains("colisio"))) {
                        jumpRight();
                    }
                    else if (moving === "left" && !(level.childNodes[calcularIndexLineal(fila+1, columna-1)].classList.contains("colisio"))) {
                        jumpLeft();
                    }
                    else if (moving === "dashRight") { dash(1); }
                    else if (moving === "dashLeft") { dash(-1); }
                    else { fall(); }
                }, 240);
            }
        }
    }
    else { isAnimating = false; }
}

function fall() {
    var nail = false;
    var compt = positionPlayer.fila+1;
    var fila = reajustarValor(compt, NUM_FILES);
    var columna = positionPlayer.columna;
    var desti = level.childNodes[calcularIndexLineal(fila, columna)];
    var casillas = 0;
    while (!(desti.classList.contains("colisio"))) {
        if (desti.classList.contains("nail") || desti.classList.contains("nailDown")) {
            nail = true;
            break;
        }
        compt++;
        casillas++;
        fallAnimation.deleteRule("1");
        fallAnimation.appendRule("to { transform: translateY(" + (casillas*100) + "%); }");
        player.classList.add("fall");
        setTimeout(function() {
            desti.appendChild(player);
            positionPlayer = desti;
            player.classList.remove("fall");
        }, 240); // 10ms abans del animation duration (estil.css)
        desti = level.childNodes[calcularIndexLineal(compt, columna)];
    }
    desti = level.childNodes[calcularIndexLineal(compt-1, columna)];
    setTimeout(function() {
        if (nail === true) {
            var explosionSound = document.createElement("audio");
            explosionSound.setAttribute("src", "audio/explosion.mp3");
            explosionSound.load();
            explosionSound.play();
            var explosionPlace = level.childNodes[calcularIndexLineal(fila, columna-1)];
            explosionPlace.appendChild(explosion);
            setTimeout(function() {
                explosionPlace.removeChild(explosion);
             }, 2000);
            startPosition.appendChild(player);
            positionPlayer = startPosition;
        }
        isAnimating = false;
    }, 240);
}

function dash(direccio) {
    var fila = positionPlayer.fila;
    var columna = reajustarValor(positionPlayer.columna + direccio, NUM_COLUMNES);
    var desti = level.childNodes[calcularIndexLineal(fila, columna)];
    if (desti.classList.contains("nail") || desti.classList.contains("nailDown")) {
        if (monedes-2 > 0) { monedes -= 2; }
        else { monedes = 0; }
        $("#numMonedes").text(monedes);
        var explosionSound = document.createElement("audio");
        explosionSound.setAttribute("src", "audio/explosion.mp3");
        explosionSound.load();
        explosionSound.play();
        var explosionPlace = level.childNodes[calcularIndexLineal(fila-1, columna-1)];
        explosionPlace.appendChild(explosion);
        setTimeout(function() {
            explosionPlace.removeChild(explosion);
        }, 2000);
        startPosition.appendChild(player);
        positionPlayer = startPosition;
        isAnimating = false;
    }
    else if (!(desti.classList.contains("colisio"))) {
        if (level.childNodes[calcularIndexLineal(fila, columna+direccio)].classList.contains("nail") || level.childNodes[calcularIndexLineal(fila, columna+direccio)].classList.contains("nailDown")) {
            if (monedes-2 > 0) { monedes -= 2; }
            else { monedes = 0; }
            $("#numMonedes").text(monedes);
            var explosionSound = document.createElement("audio");
            explosionSound.setAttribute("src", "audio/explosion.mp3");
            explosionSound.load();
            explosionSound.play();
            var explosionPlace = level.childNodes[calcularIndexLineal(fila-1, columna-1)];
            explosionPlace.appendChild(explosion);
            setTimeout(function() {
                explosionPlace.removeChild(explosion);
            }, 2000);
            startPosition.appendChild(player);
            positionPlayer = startPosition;
            isAnimating = false;
        }
        else {
            if (monedes-2 > 0) { monedes -= 2; }
            else { monedes = 0; }
            $("#numMonedes").text(monedes);
            moveAnimation.deleteRule("1");
            moveAnimation.appendRule("to { transform: translateX(" + (direccio*100) + "%); }");
            player.classList.add("move");
            setTimeout(function() {
                desti.appendChild(player);
                positionPlayer = desti;
                player.classList.remove("move");
            }, 240);
            columna += direccio;
            if (!(level.childNodes[calcularIndexLineal(fila, columna)].classList.contains("colisio"))) {
                desti = level.childNodes[calcularIndexLineal(fila, columna)];
                moveAnimation.deleteRule("1");
                moveAnimation.appendRule("to { transform: translateX(" + (direccio*200) + "%); }");
                player.classList.add("move");
                setTimeout(function() {
                    desti.appendChild(player);
                    positionPlayer = desti;
                    player.classList.remove("move");
                }, 240); // 10ms abans del animation duration (estil.css)
            }
        }
    }
    setTimeout(function() {
        fall();
    }, 240);
}

function inspect() {
    if (positionPlayer.classList.contains("chest")) {
        monedes += positionPlayer.coins-1;
        $("#numMonedes").text(monedes);
        positionPlayer.coins = 0;
        var sound = document.createElement("audio");
        sound.setAttribute("src", "audio/coin.mp3");
        sound.load();
        sound.play();
        positionPlayer.classList.remove("chest");
        positionPlayer.classList.add("openChest");
    }
    else if (positionPlayer.classList.contains("door")) {
        var lastLevel = document.getElementsByClassName("level");
        level.remove();
        if (numLevel === 1) { createLevel2(); }
        else if (numLevel === 2) { finalLevel(); }
    }
}

function right() { moure(0, 1, "rotateRight"); }

function left() { moure(0, -1, "rotateLeft"); }

function jumpRight() { moure(0, 1, "jumpRight"); }

function jumpLeft() { moure(0, -1, "jumpLeft"); }

function calcularIndexLineal(fila, columna) { return fila * NUM_COLUMNES + columna; }

function reajustarValor(valorIn, valorMax) { return ((valorIn + valorMax) % valorMax); }

addEventListener("keydown", function(event) {
    if (event.code === "F5") { return; }
    event.preventDefault();
    if (dead === true) {
        startPosition.appendChild(player);
        positionPlayer = startPosition;
        setTimeout(function() {
            dead = false;
        }, 500)
    }
    else if (isAnimating === false && playing === true && monedes > 0) {
        isAnimating = true;
        switch (event.code) {
            case "ArrowUp":
                inspect();
                isAnimating = false;
            break;
            case "ArrowRight":
                right();
            break;
            case "ArrowLeft":
                left();
            break;
            case "Space":
                if (monedes >= 3) { jump(); }
                else {
                    alert("Not enough money");
                    isAnimating = false;
                }
            break;
            case "KeyD":
                if (monedes >= 2) { dash(1); }
                else {
                    alert("Not enough money");
                    isAnimating = false;
                }
            break;
            case "KeyA":
                if (monedes >= 2) { dash(-1); }
                else {
                    alert("Not enough money");
                    isAnimating = false;
                }
            break;
            default:
                isAnimating = false;
            break;
        }
        setTimeout(function() {
            if (positionPlayer.classList.contains("jhon")) {
                isAnimating = true;
                alert("Jump");
                var newAudio = document.createElement("audio");
                newAudio.setAttribute("src", "audio/jhon.mp3");
                newAudio.load();
                newAudio.play();
                var jhonDiv = document.createElement("div");
                main.appendChild(jhonDiv);
                var jhon = document.createElement("img");
                jhon.setAttribute("src", "images/jhon.gif");
                jhonDiv.appendChild(jhon);
                $(jhon).css("position", "absolute");
                $(jhon).css("left", "73%");
                $(jhon).css("top", "10%");
                main.appendChild(jhonDiv);
                setTimeout(function() {
                    $(jhonDiv).css("display", "none");
                    var conf = confirm();
                    moure(0, 1, "rotateRight");
                    $(player).css("background-color", "none");
                    $(main).fadeOut("slow", function() {
                        $(main).empty();
                        monedes = 45;
			playing = false;
                        prepararMenu();
                        $(main).fadeIn("slow");
                    });
                }, 6250);
                
            }
        }, 240);
    }
    else if (monedes === 0) { alert("No money, restart the game"); }
});

var NUM_COLUMNES = 20;
var NUM_FILES = 12;

var main, contingut, rotateAnimation, jumpAnimation, fallAnimation, moveAnimation, moveMonsterAnimation, level, player, monster, startPosition, positionPlayer, positionMonster;
var isAnimating = false, playing = false, dead = false;
var numLevel = 0;
var explosion = document.createElement("img");
explosion.setAttribute("src", "images/explosion.gif");
var explosionPosition = $(explosion).css("right");
$(explosion).css("position", "absolute");
var monedes = 45;
var audio = document.createElement("audio");
audio.setAttribute("src", "audio/wind.mp3");
audio.setAttribute("loop", "true");
audio.load();
audio.play();
prepararMenu();
