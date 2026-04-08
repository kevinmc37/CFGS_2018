function calcular(simbol) {
    var igual = document.getElementById("igual");
    var operacio = document.getElementById("operacio");
    var answer = document.getElementById("answer");
    var operador = document.getElementsByClassName("operador");
    if (simbol === "/" || simbol === "*" || simbol === "-" || simbol === "+" || simbol === "." || simbol === "%") {
        for (var compt = 0; compt < operador.length; compt++)  {
            operador[compt].disabled = true;
        }
    }
    else {
        if (simbol !== "(" && simbol !== ")") {
            for (var compt = 0; compt < operador.length; compt++)  {
                operador[compt].disabled = false;
            }
        }
    }
    if (simbol === "r") { operacio.value = operacio.value.slice(0, -1); }
    else if (simbol === "c") {
        operacio.value = "";
        document.getElementById("valorResultat").innerHTML = "";
    }
    else if (simbol === "sup") { operacio.value += "^"; }
    else if (simbol === "v") { operacio.value += "√("; }
    else if (simbol === "Ans") {
        operacio.value += document.getElementById("valorResultat").innerHTML;
    }
    else if (simbol === "=") {
        var arrelComprovar = false;
        var arrel;
        var resultat;
        for (var compt1 = 0; compt1 < operacio.value.length; compt1++) {
            if (operacio.value.includes("√") === true && arrelComprovar === false) {
                arrelComprovar = true;
                arrel = operacio.value.match(/[\d(?=√)|\)(?=√)]√/);
                if (arrel !== null) {
                    arrel.forEach(function (element) {
                        var arrelModificat = element.split("√");
                        var str = arrelModificat[0]+"*√";
                        operacio.value = operacio.value.replace(element, str);
                    });
                }
                operacio.value = operacio.value.replace(/√/g, "Math.sqrt");
            }
            else if (operacio.value[compt1] === '^') {
                var obreParentesis = false;
                var tancaParentesis = false;
                var potencies;
                if (operacio.value[compt1-1] === ")" && operacio.value[compt1+1] === "(") {
                    potencies = operacio.value.match(/\(.*\)\^\(.*\)/);
                    obreParentesis = true;
                    tancaParentesis = true;
                }
                else if (operacio.value[compt1-1] === ")" && operacio.value[compt1+1] !== "(") {
                    potencies = operacio.value.match(/\(.*\)\^\d+/);
                    obreParentesis = true;
                }
                else if (operacio.value[compt1-1] !== ")" && operacio.value[compt1+1] === "(") {
                    potencies = operacio.value.match(/\d+\^\(.*\)/);
                    tancaParentesis = true;
                }
                else { potencies = operacio.value.match(/\d+\^\d+/); }
                potencies.forEach(function (element) {
                    var nums = element.split("^");
                    if (obreParentesis === true && tancaParentesis === true) {
                        nums[0] = eval(nums[0]);
                        nums[1] = eval(nums[1]);
                    }
                    else if (obreParentesis === true && tancaParentesis === false) { nums[0] = eval(nums[0]); }
                    else if (obreParentesis === false && tancaParentesis === true) { nums[1] = eval(nums[1]); }
                    operacio.value = operacio.value.replace(element, "Math.pow("+nums[0]+", "+nums[1]+")");
                });
            }
        }
        try  {
            resultat = eval(operacio.value);
            resultat = Math.round(resultat * 10000000000) / 10000000000;
            document.getElementById("valorResultat").innerHTML = resultat;
            answer.disabled = false;
        }
        catch(err) {
            document.getElementById("valorResultat").innerHTML = "Syntax Error";
            answer.disabled = true;
        }
        operacio.value = "";
        igual.disabled = true;
        for (var compt = 0; compt < operador.length; compt++)  {
            operador[compt].disabled = true;
        }
    }
    else {
        operacio.value += simbol;
        if (simbol === "(") {
            var posicio = operacio.value.lastIndexOf("(")-1;
            if (operacio.value[posicio] >= 48 || operacio.value[posicio] <= 57 || operacio.value[posicio] === ")") { operacio.value = operacio.value.replace(/\($/, "*("); }
        }
    }
}
