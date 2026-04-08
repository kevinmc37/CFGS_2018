function Autor(pNom,pCognom){
	/*No tocar aquest codi, inicializa els atributs
	 * nom i cognom amb el valor adient en funció de si
	 * ha estat informat o no */
	var nom = (typeof(pNom) === "undefined" ? null: pNom);
	var cognom = (typeof(pCognom) === "undefined" ? null: pCognom);
	
	/*Mètode a implementar seguint les especificacions de l'enunciat */
	this.toString = function(){
            if (nom !== undefined && cognom !== undefined) {
                document.write(cognom+", "+nom);
            }
            else if (nom !== undefined && cognom === undefined) {
                document.write(nom);
            }
	}
}
var obj = new Autor("Kevin", "Morales");
obj.toString();