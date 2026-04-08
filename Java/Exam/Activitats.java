/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moraleskevinexuf5;

/**
 *
 * @author guest-nk7ql1
 */
public class Activitats {
    
    public static void main(String[] args) {
        java.util.TreeMap<String, Escuderia> mapaEscuderia = new java.util.TreeMap();
        // TreeMap perquè es poden ordenar-se amb el valor de la clau (és a dir, alfabèticament)
        java.util.TreeMap<String, Pilot> mapaPilots = new java.util.TreeMap();
        String rutaFitxer = exercici1.GestioFitxers.mostrarDialegGuardar(null);
        System.out.println(rutaFitxer);
        java.io.File entrada = new java.io.File(rutaFitxer); // Obrim el fitxer de text
        try {
            java.util.Scanner lector = new java.util.Scanner(entrada);
            while (lector.hasNextLine()) {
                String linia = lector.nextLine();
                String[] camps = linia.split("\t");
                if (!mapaEscuderia.containsKey(camps[1])) {
                    Escuderia escuderia = new Escuderia(camps[1], camps[0], camps[2], camps[3]);
                    mapaEscuderia.put(camps[1], escuderia);
                }
                else {
                    Escuderia escuderia = mapaEscuderia.get(camps[1]);
                    int codi = escuderia.getCodi();
                    escuderia.setNum_inst(codi);
                }
                if (!mapaPilots.containsKey(camps[9])) {
                    boolean titular = false;
                    if ("Titular".equals(camps[8])) {
                        titular = true;
                    }
                    if ("".equals(camps[5])) {
                        int dorsal = 100+(int)(Math.random()*(200));
                        camps[5] = ""+dorsal;
                    }
                    
                    Pilot pilot = new Pilot(Integer.parseInt(camps[5]), camps[6], camps[7], titular, camps[9], camps[1]);
                    mapaPilots.put(camps[9], pilot);
                }
                else {
                    Pilot pilot = mapaPilots.get(camps[9]);
                    pilot.setCodiEscuderia2(camps[1]);
                }
            }
            System.out.println("Escuderia:\n\n"+mapaEscuderia);
            System.out.println("Pilots:\n\n"+mapaPilots);
            java.util.Iterator<java.util.Map.Entry<String, Escuderia>> iterador = mapaEscuderia.entrySet().iterator();
            java.io.File nouFitxer = new java.io.File("Escuderies.txt");
            java.io.PrintStream escriptor = new java.io.PrintStream(nouFitxer);
            while (iterador.hasNext()) {
                iterador.next();
            }
            escriptor.close();
            // No m'ha donat temps de fer l'escriptor
        }
        catch (Exception e) {
            System.out.println("El codi peta nano, "+e.getMessage());
        }
    }
    
}
