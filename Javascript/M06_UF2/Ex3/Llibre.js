function Llibre(pTitol, pAutor) {
    var titol = (typeof(pTitol) === "undefined" ? null: pTitol);
    var autor = (typeof(pAutor) === "undefined" ? null: pAutor);
    var numPag = 0;
    
    this.getAutor = function() {
        return autor;
    }
    
    this.getTitol = function() {
        return titol;
    }
    
    this.getNumPag = function() {
        return numPag;
    }
    
    this.setNumPag = function(pNumPag) {
        var valor = (typeof(pNumPag) === "undefined" ? numPag: pNumPag);
        if (!(valor < 0)) {
            numPag = Math.floor(valor);
        }
    }
    
    this.toString = function() {
        var cadena = ""+titol+"#"+numPag+"#";
        cadena += autor.toString();
        return cadena;
    }
    
}

function Autor(pNom,pCognom){
	/*No tocar aquest codi, inicializa els atributs
	 * nom i cognom amb el valor adient en funció de si
	 * ha estat informat o no */
	var nom = (typeof(pNom) === "undefined" ? null: pNom);
	var cognom = (typeof(pCognom) === "undefined" ? null: pCognom);
	
	/*Mètode a implementar seguint les especificacions de l'enunciat */
	this.toString = function(){
            var cadena = "";
            if (nom !== undefined && cognom !== undefined) {
                cadena = cognom+", "+nom;
            }
            else if (nom !== undefined && cognom === undefined) {
                cadena = nom;
            }
            return cadena;
	}
}

var autor1 = new Autor("Kevin", "Morales");
var llibre1 = new Llibre("Libro Mágico", autor1);
llibre1.setNumPag(6.4);
document.write(llibre1.toString());