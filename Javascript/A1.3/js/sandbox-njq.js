
/************************************************
 * 
 *	a.	Seleccions:
 * 
 ************************************************/

//i.	Selecciona tots els elements div que tinguin la classe module.
    
    var modules = [];
    var divModule = document.getElementsByTagName("div");
    for (var compt = 0; compt < divModule.length; compt++) {
        if (divModule[compt].classList.contains("module")) {
            modules.push(divModule[compt]);
        }
    }

//ii.	Indica tres possibles maneres en què puguis seleccionar el tercer ítem de la llista desordenada d’id myList. Quin és el millor mètode a fer servir? Per què?

    var list = document.getElementById("myList");
    var items = list.children;
    var item3;
    
    for (var compt = 0; compt < items.length; compt++)  {
        if (compt === 2) {
            item3 = items[compt];
        }
    }
    
    item3 = items[2];
    
    item3 = items.item(2);
    
    // Cap mètode és millor, cadascun serveix per diferents coses i els pots utilitzar tots depenent del que et convingui.

//iii.	Selecciona l’element label de l’element input utilitzant un selector d’atribut

    var labelInput;
    var labels = document.getElementsByTagName("label");
    for (var compt = 0; compt < labels.length; compt++) {
        if (labels[compt].htmlFor === "q") {
            labelInput = labels[compt];
        }
    }

//iv.	Esbrina quants elements en la pàgina estan ocults

    var displayNone = document.getElementsByTagName("p");
    var amagats = 0;
    for (var compt = 0; compt < displayNone.length; compt++) {
        if (displayNone[compt].className === "excerpt") {
            amagats++;
        }
    }

//v.	Esbrina quantes imatges a la pàgina tenen l’atribut alt
    
    var imageAlt = document.getElementsByTagName("img");
    var alts = 0;
    for (var compt = 0; compt < imageAlt.length; compt++) {
        if (imageAlt[compt].getAttribute("alt")) {
            alts++;
        }
    }

//vi.	Selecciona totes les files senars del cos de la taula
    var tbody = document.getElementsByTagName("tbody");
    var senars = [];
    for (var compt = 0; compt < tbody.length; compt++) {
        var child = tbody[compt].children;
        for (var compt2 = 0; compt2 < child.length; compt2++) {
            if (compt2 % 2 === 0) {
                senars.push(child[compt2]);
            }
        }
    }

/**********************************************************
 * 
 *	b.	Recórrer el DOM
 * 
 * ********************************************************/
 
//i.	Seleccionar totes les imatges a la pàgina; mostrar per consola l’atribut alt de cada imatge

    for (var compt = 0; compt < imageAlt.length; compt++) {
        if (imageAlt[compt].getAttribute("alt")) {
            console.log(imageAlt[compt].getAttribute("alt"));
        }
    }

//ii.	Seleccionar l’element input i afegir una classe al formulari que el conté

    var inputForm = document.getElementsByTagName("input");
    var formulari;
    for (var compt = 0; compt < inputForm.length; compt++) {
        if (inputForm[compt].parentNode.nodeName === "FORM") {
            formulari = inputForm[compt].parentNode;
            if (!formulari.classList.contains("classeNova")) {
                formulari.classList.add("classeNova");
            }
        }
    }

//iii.	Seleccionar l’ítem que té la classe current dins de la llista d’id myList i eliminar l’esmentada classe en l’element; després afegeix la classe current al següent ítem de la llista

    var myList = document.getElementById("myList").children;
    var current = false;
    for (var compt = 0; compt < myList.length; compt++) {
        if (myList[compt].classList.contains("current") && current === false) {
            myList[compt].classList.remove("current");
            current = true;
        }
        else if (current === true) {
            myList[compt].classList.add("current");
            break;
        }
    }

//iv.	Seleccionar l’element select dins de l’element amb id specials; després dirigeix-te cap al botó submit

    //var formInput = document.getElementById("specials").children;    

//v.	Seleccionar el primer ítem de la llista amb id slideshow; afegeix-li la classe current i després afegeix la classe disabled als elements germans

    var slideshow = document.getElementById("slideshow").children;
    for (var compt = 0; compt < slideshow.length; compt++) {
        if (compt === 0) {
            slideshow[compt].classList.add("current");
        }
        else {
            slideshow[compt].classList.add("disabled");
        }
    }

/**********************************************************
 * 
 *	c.	Manipulació
 * 
 * ********************************************************/


//i.	Afegeix 5 nous ítems al final de la llista desordenada d’id myList

    var myList2 = document.getElementById("myList");
    var text = "<li>Soc una llista nova</li>";
    for (var compt = 0; compt < 5; compt++) {
        myList2.innerHTML += text;
    }
    
//ii.	Eliminar els ítems senars de la llista

    for (var compt = 0; compt < myList.length; compt++) {
        myList[compt].parentNode.removeChild(myList[compt]);
    }

//iii.	Afegir una altre element h2 i un altre paràgraf al darrer div que posseeix la classe module    

    var divsModule = document.getElementsByTagName("div");
    for (var compt = divsModule.length-1; compt >= 0; compt--) {
        if (divsModule[compt].classList.contains("module")) {
            divsModule[compt].innerHTML += "<h2>Titol gros</h2><div>Paragraf nou</div>";
            break;
        }
    }

//iv.	Afegir una altra opció a l’element select; dona-li a l’opció afegida el valor Wednesday

    var select = document.getElementsByTagName("select");
    select[0].innerHTML += "<option></option>";
    var option = select[0].lastChild;
    option.innerHTML = "Wednesday";
    option.value = "Wednesday";

//v.	Afegir un nou div amb classe module a la pàgina després del dar-rer; després afegeix una còpia de cadascuna de les imatges exis-tents dins del nou div.

    var lastDiv = document.getElementsByTagName("div");
    var copiaDiv = document.createElement("div");
    copiaDiv.classList.add("module");
    for (var compt = 0; compt < lastDiv.length; compt++) {
        if (compt === lastDiv.length-1) {
            for (var compt1 = 0; compt1 < imageAlt.length; compt1++) {
                var imgCopia = imageAlt[compt1].cloneNode();
                copiaDiv.appendChild(imgCopia);
            }
            lastDiv[compt].parentNode.insertBefore(copiaDiv, lastDiv[compt].nextSibling);
            break;
        }
    }

