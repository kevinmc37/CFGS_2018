function fibonacci() {
	var nombres = prompt("Entra quants nombres vols que surtin de la succeció de Fibonacci");
	nombres -= 2;
	var nombre1 = 1;
	var nombre2 = 1;
	var nombre3;
	document.write(nombre1+", ");
	document.write(nombre2);
	for (var compt = 0; compt < nombres; compt++) {
		nombre3 = nombre1 + nombre2;
		document.write(", "+nombre3);
		nombre2 = nombre1;
		nombre1 = nombre3;	
	}
}
