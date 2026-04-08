function Lector(nSoci, nom, telefon, adreça) {
    this.nSoci = nSoci;
    this.nom = nom;
    this.telefon = telefon;
    this.adreça = adreça;
    var prestecs = Array();
    var multaIni;
    var multaFi;
    
    this.retornar = function (idLlibre, dataActual) {
        var trobat = false;
        var compt = 0;
        var identificador; // Per trobar la posició i treure-lo del array
        while (trobat === false && compt < prestecs.length) {
            if (prestecs[compt][0] === idLlibre) {
                trobat = true;
                identificador = compt;
                var limit = new Date(prestecs[compt][1].getTime());
                limit.setDate(limit.getDate()+30); // Limit d'entrega del llibre
                if (dataActual > limit) { // Si la data ha passat, té multa
                    var numDies = dataActual.getDate()-limit.getDate();
                    multaIni = new Date(dataActual.getTime());
                    multar(numDies);
                    alert("Toma multa cabrón!");
                }
            }
            compt++;
        }
        if (trobat === false) { alert("No tens aquest llibre"); }
        else {
            prestecs.splice(identificador, 1);
            alert("S'ha retornat el llibre!");
        }
    };
    
    this.prestar = function (idLlibre, dataActual) {
        if (multaIni !== undefined) { // Si hi ha multa...
            if (dataActual <= multaFi) { // Es mira si ja ha passat la data de multa
                alert("No pots, tens una multa >:c");
                return false;
            }
            multaIni = undefined;
            multaFi = undefined;
        }
        if (prestecs.length === 3) {
            alert("No es poden prestar més llibres");
            return false;
        }
        prestecs.push(new Array(idLlibre, dataActual));
        alert("Et presto el llibre. Num de llibres: "+prestecs.length);
    };
    
    var multar = function (numDies) {
        multaFi = new Date(multaIni.getTime()); // S'agafa la data de multa inicial
        multaFi.setDate((numDies*2)+multaFi.getDate()); // Es sumen els dies de multa
    };
}

function cridar() {
    var lector1 = new Lector(34, "Pepe Apellido", "938456346", "c/ la calle guay");
    var dataActual = new Date();
    var canviData = new Date(dataActual.getTime());
    
    lector1.prestar(8364, dataActual);
    canviData.setDate(canviData.getDate()+25);
    lector1.retornar(8364, canviData);
    canviData.setDate(canviData.getDate()-25);
    
    lector1.prestar(445, dataActual);
    canviData.setDate(canviData.getDate()+35);
    lector1.retornar(445, canviData);
    
    lector1.prestar(3210, dataActual);
    canviData.setDate(canviData.getDate()+25);
    lector1.prestar(1234, canviData);
}