/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moraleskevinexuf5;

import java.util.ArrayList;

/**
 *
 * @author POSA AQUI EL TEU NOM
 */
public class Exercici1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Exercici1 exe = new Exercici1();
        exe.init();
        
    }
    
    /**
     * Inicialitza el programa
     */
    public void init(){
        //Seleccionem el fitxer d'origen (el segon paràmetre és la ruta per defecte)
        String ruta = GestioFitxers.mostrarDialegSeleccio(null,"E:\\M03_Soft\\Examen16_17");
        // Carreguem les dades del fitxer d'origen en un ArrayList.
        // aquesta estructura ens permet recòrren fàcilment les files que tenim al fitxer
        ArrayList<String> arl = GestioFitxers.llegirFitxer(ruta);
        if(arl != null && !arl.isEmpty()){
            //Si no hi ha hagut problema a llegir el fitxer i al fitxer hi havia dades
            /*TODO: Afegeix el codi aquí per carregar les estructures que es demanen a l'exercici
            Recorda que has de justificar quina estructura has triat*/

            
            
            /*El diàleg de guardar el mostrarem només si hem pogut fer les altres tasques*/
            ruta = GestioFitxers.mostrarDialegGuardar(null,"E:\\M03_Soft\\Examen16_17");

            //GuardarEscuderies(escuderies, ruta);
        }

    }
    
    /**
    *Guarda les dades de la col·lecció que es passa per paràmetre a l'arxiu que s'hi indica
    * @param estruc    {@link java.util.Collection} col·lecció d'objectes Escuderia
    * @param ruta    {@link String} cadena amb la ruta de l'arxiu destí
    */
    private void GuardarEscuderies(java.util.Collection colecci, String ruta){
        if(ruta==null || ruta.length()==0) return;
        ArrayList<String> comu = new ArrayList();
        
        /*Aquí seria bó recorrer l'estructura que has creat (Cal que canviis el tipus
        de dades Collection al tipus de dades que has fet servir i omplir un ArrayList amb 
        lles línies que volem bolcar al fitxer de sortida
        */
        
        GestioFitxers.bolcarDadesFitxer(ruta, comu);
        
    }
    
}
