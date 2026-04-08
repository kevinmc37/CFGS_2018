
/************************************************
 * 
 *	a.	Seleccions:
 * 
 ************************************************/

//i.	Selecciona tots els elements div que tinguin la classe module.

    $("div.module");

//ii.	Indica tres possibles maneres en què puguis seleccionar el tercer ítem de la llista desordenada d’id myList. Quin és el millor mètode a fer servir? Per què?

    $list = $("ul#myList li");
    $list1 = $list.eq(2); // Retorna el tercer element en format de jQuery

    $list.each(function(index, value) { // Itera per tota la lista, pots trobar el tercer element
        if (index === 2) {
            $list2 = value;
        }
    });

    var list3 = $list[2]; // Retorna el tercer element en format del DOM

    // Cap mètode és millor, cadascun serveix per diferents coses i els pots utilitzar tots depenent del que et convingui.

//iii.	Selecciona l’element label de l’element input utilitzant un selector d’atribut

    $("label").attr("for", "q");

//iv.	Esbrina quants elements en la pàgina estan ocults

    $displayNone = $("#blog p.excerpt");
    var numDisplayNone = $displayNone.size();

//v.	Esbrina quantes imatges a la pàgina tenen l’atribut alt

    $("img[alt]"); // Agafar totes les img que continguin alt

//vi.	Selecciona totes les files senars del cos de la taula

    // $("table#fruits tbody tr:odd"); Index 1 i 3, files parelles de la taula
    $("table#fruits tbody tr:even"); // Index 0 i 2, files senars de la taula

/**********************************************************
 * 
 *	b.	Recórrer el DOM
 * 
 * ********************************************************/
 
//i.	Seleccionar totes les imatges a la pàgina; mostrar per consola l’atribut alt de cada imatge

    $imatges = $("img");
    $imatges.each(function(index) {
        console.log($(this).attr("alt"));
    });

//ii.	Seleccionar l’element input i afegir una classe al formulari que el conté

    $("input").parent("form").addClass("classeForm");

//iii.	Seleccionar l’ítem que té la classe current dins de la llista d’id myList i eliminar l’esmentada classe enl’element; després afegeix la classe current al següent ítem de la llista

    $itemCurrent = $("#myList .current").removeClass("current");
    $itemCurrent.next().addClass("current");

//iv.	Seleccionar l’element select dins de l’element amb id specials; després dirigeix-te cap al botó submit

    $formulariInput = $("#specials select").parent().next().find($("input[type=submit]"));

//v.	Seleccionar el primer ítem de la llista amb id slideshow; afegeix-li la classe current i després afegeix la classe disabled als elements germans

    $itemFirst = $("#slideshow").first().addClass("current");
    $itemFirst.siblings().addClass("disabled");

/**********************************************************
 * 
 *	c.	Manipulació
 * 
 * ********************************************************/


//i.	Afegeix 5 nous ítems al final de la llista desordenada d’id myList

    var text = "<li>Soc una llista nova</li>";
    $llista2 = $("#myList");
    for (var compt = 0; compt < 5; compt++) {
        $llista2.append(text);
    }
    
//ii.	Eliminar els ítems senars de la llista
    
    $("#myList li:even").remove();

//iii.	Afegir una altre element h2 i un altre paràgraf al darrer div que posseeix la classe module    

    $lastModule = $("div.module").last();
    $lastModule.append("<h2>Titol gros</h2><div>Paragraf nou</div>");

//iv.	Afegir una altra opció a l’element select; dona-li a l’opció afegida el valor Wednesday

    $select = $("select").first();
    $select.append("<option></option>");
    $select.children().last().attr("value", "Wednesday").text("Wednesday");

//v.	Afegir un nou div amb classe module a la pàgina després del dar-rer; després afegeix una còpia de cadascuna de les imatges exis-tents dins del nou div.

    $lastDiv = $("div").last().parent();
    $nouDiv = $("div").addClass("module");
    $lastDiv.append("div");
    $lastDiv2 = $("div").last();
    $imatges.each(function(index) {
        $copia = $(this).clone();
        $lastDiv2.append($copia);
    });

