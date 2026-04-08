/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llistes;

import java.util.ArrayList;

/**
 *
 * @author guest-lcea8d
 */
public class entrada {
    
    public static void main(String[] args) {
        String rutaFitxer = Dialegs.gestioFitxers.mostrarDialegGuardar(null); // Indiquem la ruta del fitxer de text.
        System.out.println(rutaFitxer);

        java.io.File entrada = new java.io.File(rutaFitxer); // Obrim el fitxer de text
        if (entrada.exists() && entrada.isFile()) { // Si el fitxer no existeix o no és un fitxer...
            try {
                java.util.Scanner lector = new java.util.Scanner(entrada); // Inicialitzem el lector de fitxers
                ArrayList<ArrayList> llista = new ArrayList();
                while (lector.hasNextLine()) { // Mentre existeixi una línia en el fitxer...
                    ArrayList<Integer> fila = new ArrayList();
                    String linia = lector.nextLine(); // Llegim la següent línia
                    System.out.println(linia);
                    String[] camps = linia.split("\t"); // Posem en un array cada informació, separant pels tabuladors
                    for (int compt = 0; compt < camps.length; compt++) {
                        fila.add(Integer.parseInt(camps[compt]));
                    }
                    llista.add(fila);
                    java.util.Iterator<Integer> iteradorFila = fila.iterator();
                    while (iteradorFila.hasNext()) {
                        if (iteradorFila.next().equals(0)) {
                            iteradorFila.remove();
                        }
                    }
                }
                lector.close(); // Tanquem el lector de fitxers
                java.util.Iterator<ArrayList> iteradorLlista = llista.iterator();
                while (iteradorLlista.hasNext()) {
                    if (iteradorLlista.next().isEmpty()) {
                        iteradorLlista.remove();
                    }
                }
                java.io.File novaLlista = new java.io.File("LlistaDeNombres.txt");
                java.io.PrintStream escriptor = new java.io.PrintStream(novaLlista);
                for (ArrayList list : llista) {
                    for (int compt = 0; compt < list.size(); compt++) {
                        escriptor.print(list.get(compt) + "\t");
                    }
                    escriptor.println();
                }
                escriptor.close();
                System.out.println(llista);
            }
            catch (Exception e) { // Si el lector falla...
                System.out.println("El codi peta nano, "+e.getMessage());
            }
        }
    }
}
