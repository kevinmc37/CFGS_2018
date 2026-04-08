/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalegDeLlibres;

import java.util.HashMap;

/**
 *
 * @author guest-whfpv2
 */
public class Activitat5 {
    
    public static void main(String[] args) {
        
        String rutaFitxer = Dialegs.gestioFitxers.mostrarDialegGuardar(null); // Indiquem la ruta del fitxer de text.
        System.out.println(rutaFitxer);
        java.io.File entrada = new java.io.File(rutaFitxer); // Obrim el fitxer de text
        Cataleg cataleg = new Cataleg();
        Llibre meuLlibre = new Llibre("438753659365", "Titol guay", "collecio nova", (byte)7, "Kevs", "editorial xula", "Soc un resum!!!");
        try {
            java.util.Scanner lector = new java.util.Scanner(entrada);
            while (lector.hasNextLine()) {
                    String linia = lector.nextLine();
                    String[] camps = linia.split("::");
                    if ("".equals(camps[3])) {
                        camps[3] = "0";
                    }
                    Llibre llibre = new Llibre(camps[0], camps[1], camps[2], Byte.valueOf(camps[3], 10), camps[4], camps[5], camps[6]);
                    cataleg.afegirLlibre(llibre);
                }            
        }
        catch (Exception e) {
            System.out.println("El codi peta nano, "+e.getMessage());
        }
        System.out.println(cataleg.afegirLlibre(meuLlibre));
        System.out.println(cataleg.existeixLlibre(meuLlibre.getIsbn()));
        System.out.println(cataleg.mostrarLlibre(meuLlibre.getIsbn()));
        System.out.println(cataleg.eliminarLlibre(meuLlibre.getIsbn()));
        System.out.println(cataleg.obtenirTotalLlibres());
        System.out.println(cataleg.mostrarLlibres());
    }
    
}
