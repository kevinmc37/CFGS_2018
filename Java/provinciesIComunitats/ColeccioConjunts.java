/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provinciesIComunitats;
import java.io.File;
import java.io.PrintStream;
/**
 *
 * @author guest-walruy
 */
public class ColeccioConjunts {

    /**
     * @param args the command line arguments
     */
     private static ComunitatAutonoma createComunitatAutonoma(String[] camps){
 
        ComunitatAutonoma comu=new ComunitatAutonoma(Integer.parseInt(camps[1]),camps[0]);
        return comu;
    }
     private static Provincia createProvincia(String[] camps){
         Provincia prov = new Provincia(Integer.parseInt(camps[2]),Integer.parseInt(camps[1]),camps[3]);
         return prov;
     }
    public static void main(String[] args) {
        // TODO code application logic here
        String rutaFitxer = Dialegs.gestioFitxers.mostrarDialegSeleccio(null);
        System.out.println(rutaFitxer);
        
        java.io.File entrada = new java.io.File(rutaFitxer);
        if(entrada.exists() && entrada.isFile()){//si existeix pasa
            try{
                java.util.Scanner lector = new java.util.Scanner(entrada);
                java.util.HashSet<ComunitatAutonoma> comunitats = new java.util.HashSet();//agafes el hashSet de comunitat autonoma.
                java.util.HashSet<Provincia> provincies = new java.util.HashSet();//agafes el hashSet de Provincia
                while(lector.hasNextLine()){//si no arriva al final, continua
                    String linia = lector.nextLine();//posem la linia a una variable
                    String[] camps=linia.split("\t");
                    ComunitatAutonoma comu = createComunitatAutonoma(camps);// creem l'objecte comunitat autonoma
                    Provincia prov = createProvincia(camps);// creem l'objecte provincia
                    //escrivim linia
                    comunitats.add(comu);
                    provincies.add(prov);
                }
            
                
                lector.close();
                
                //EXERCICI 3 FUNCIONS NO COMENTADES DE MES AVALL
                Provincies provs = new Provincies();
                provs.carregarProvincies(provincies);
                for(ComunitatAutonoma ca:comunitats){
                    System.out.println("Provincies de" + ca.getNomCA());
                    pintarProvincies(provs.provinciesPerComunitat(ca.getCodiCA()));
                }
               /* File fitxer = new File("ComunitatAutonoma.txt");//posem la ruta del fitxer per comunitat autonoma
                PrintStream escriu = new PrintStream(fitxer);//crees l'objecte per escriure amb la ruta anterior
                System.setOut(escriu);//escriu a la ruta fitxer
                for(ComunitatAutonoma com: comunitats){//escriu el fitxer comunitat autonoma
                    System.out.println(com.toString());
                }
                
                 File fitxerprovincia = new File("Provincia.txt");//posem la ruta del fitxer per provincia
                PrintStream escriuprov = new PrintStream(fitxerprovincia);//crees l'objecte per escriure amb la ruta anterior
                System.setOut(escriuprov);//escriu a la ruta fitxer
                 for(Provincia prov: provincies){//escriu el fitxer provincia
                    System.out.println(prov.toString());
                }*/
                                    
            }
            catch(Exception ex){
                System.out.println("Aixo falla mes que un smite de Saintvicius" + ex.getMessage());
            }
            
        }
        
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
    }
   
   

