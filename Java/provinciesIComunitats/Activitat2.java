/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provinciesIComunitats;

/**
 *
 * @author guest-mramzu
 */
public class Activitat2 {
    
    private static ComunitatAutonoma createComunitatAutonoma(String[] camps) {
        ComunitatAutonoma comunitat = new ComunitatAutonoma(Integer.parseInt(camps[1]), camps[0]);
        return comunitat;
    }
    
    private static Provincia createProvincia(String[] camps) {
        Provincia provincia = new Provincia(Integer.parseInt(camps[2]), Integer.parseInt(camps[1]), camps[3]);
        return provincia;
    }
    
    private static void pintarProvincies(java.util.HashSet<Provincia> provs){            
                pintarColleccio(provs);
    }
    private static void pintarColleccio(java.util.Collection col){
        if(col==null)return;
            for(Object com: col){
                System.out.println(com.toString());
            }
        }
        //Mostrar comunitats autonomes
    
    public static void main(String[] args) {
        
        String rutaFitxer = Dialegs.gestioFitxers.mostrarDialegGuardar(null); // Indiquem la ruta del fitxer de text.
        System.out.println(rutaFitxer);
        
        java.io.File entrada = new java.io.File(rutaFitxer); // Obrim el fitxer de text
        if (entrada.exists() && entrada.isFile()) { // Si el fitxer no existeix o no és un fitxer...
            try {
                java.util.Scanner lector = new java.util.Scanner(entrada); // Inicialitzem el lector de fitxers
                java.util.HashSet<ComunitatAutonoma> comunitats = new java.util.HashSet(); // Inicialitzem les taules Hash
                java.util.HashSet<Provincia> provincies = new java.util.HashSet();
                while (lector.hasNextLine()) { // Mentre existeixi una línia en el fitxer...
                    String linia = lector.nextLine(); // Llegim la següent línia
                    System.out.println(linia);
                    String[] camps = linia.split("\t"); // Posem en un array cada informació, separant pels tabuladors
                    ComunitatAutonoma comunitat = createComunitatAutonoma(camps); // Creem la informació de la comunitat
                    System.out.println(comunitat.toString());
                    if (!comunitats.contains(comunitat)) { comunitats.add(comunitat); } // Si no existeix la comunitat a la taula Hash la afegim
                    Provincia provincia = createProvincia(camps); // Creem la informació de la província
                    if (!provincies.contains(provincia)) { provincies.add(provincia); } // Si no existeix la província a la taula Hash la afegim
                }
                lector.close(); // Tanquem el lector de fitxers
                Provincies proves = new Provincies();
                proves.carregarProvincies(provincies);
                for(ComunitatAutonoma ca:comunitats){
                    System.out.println("Provincies de " + ca.getNomCA());
                    pintarProvincies(proves.provinciesPerComunitat(ca.getCodiCA()));
                }
                System.out.println("Ens anexionem Catalunya i Aragó");
                java.util.LinkedHashSet<Provincia> regneArago = Provincies.unioProvincies(proves.provinciesPerComunitat(2), proves.provinciesPerComunitat(9));
                pintarProvincies(regneArago);
                
                System.out.println("Països Catalans");
                java.util.LinkedHashSet<Provincia> paisosCatalans = Provincies.unioProvincies(proves.provinciesPerComunitat(2), proves.provinciesPerComunitat(10));
                pintarProvincies(paisosCatalans);
                
                System.out.println("Intersecció");
                java.util.HashSet<Provincia> paisosAragons = Provincies.interseccioProvincies(regneArago, paisosCatalans);
                pintarProvincies(paisosAragons);
                
                System.out.println("Diferència");
                java.util.HashSet<Provincia> regneCatala = Provincies.diferenciaSimetricaProvincies(regneArago, paisosCatalans);
                pintarProvincies(regneCatala);
                
                /*
                for (ComunitatAutonoma comAut:comunitats) {
                    System.out.println(comAut.toString()); // Imprimim cada comunitat
                }
                for (Provincia prov:provincies) {
                    System.out.println(prov.toString()); // Imprimim cada província
                }
                try {
                    java.io.File fitxerComunitats = new java.io.File("Comunitats_Autonomes.txt"); // Creem un fitxer per les comunitats
                    java.io.File fitxerProvincies = new java.io.File("Provincies.txt"); // Creem un fitxer per les províncies
                    java.io.PrintStream comu = new java.io.PrintStream(fitxerComunitats); // Inicialitzem l'escriptor del fitxer de comunitats
                    java.io.PrintStream provs = new java.io.PrintStream(fitxerProvincies); // Inicialitzem l'escriptor del fitxer de províncies
                    for (ComunitatAutonoma comuni:comunitats) {
                        comu.println(comuni.toString()); // Inserim cada informació de les comunitats
                    }
                    for (Provincia prov:provincies) {
                        provs.println(prov.toString()); // Inserim cada informació de les províncies
                    }
                    comu.close(); // Tanquem l'escriptor del fitxer de comunitats
                    provs.close(); // Tanquem l'escriptor del fitxer de províncies
                }
                catch (Exception f) { // Si l'escriptor falla...
                    System.out.println("El codi peta nano, "+f.getMessage());
                }*/
            }
            catch (Exception e) { // Si el lector falla...
                System.out.println("El codi peta nano, "+e.getMessage());
            }
        }
    }
    
}