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

function Array() {
    
    var nouArr = [];
    
    this.ordenarPerTitol = function(arr) {
        for (var compt = 0; compt < arr.length; compt++) {
            var ascendent = "";
            var llibre1 = arr[compt].getTitol();
            for (var compt2 = 0; compt2 < arr.length; compt2++) {
                if (compt === compt2) {
                    continue;
                }
                else {
                    var llibre2 = arr[compt2].getTitol();
                    if (llibre1 > llibre2) {
                        ascendent = llibre1;
                    }
                    else if (llibre2 > llibre1) {
                        ascendent = llibre2;
                    }
                    else {
                        var arr2 = ordenarPerPagines([llibre1, llibre2]);
                        ascendent = arr2.shift();
                    }
                }
            }
            nouArr.push(ascendent);
        }
        return nouArr;
    }
    
    this.ordenarPerPagines = function(arr) {
        
    }
    
    this.ordenarPerAutor = function(arr) {
        
    }
    
}
var biblioteca = [];
var autor1 = new Autor("Kevin", "Morales");
var autor2 = new Autor("Nose", "Nomeacuerdo");

var llibre1 = new Llibre("Libro Mágico", autor1);
llibre1.setNumPag(6);
biblioteca.push(llibre1);

var llibre2 = new Llibre("Deberes", autor2);
biblioteca.push(llibre2);

var perTitol = biblioteca.ordenarPerTitol();

document.write(perTitol);