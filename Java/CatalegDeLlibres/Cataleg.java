/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalegDeLlibres;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author guest-whfpv2
 */
public class Cataleg {
    private HashMap<String, Llibre> llibres;
    
    public boolean afegirLlibre(Llibre llibre) {
        if (!(llibres.containsKey(llibre.getIsbn()))) {
            llibres.put(llibre.getIsbn(), llibre);
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean eliminarLlibre(String isbn) {
        if (llibres.containsKey(isbn)) {
            llibres.remove(isbn);
            return true;
        }
        else {
            return false;
        }
    }
    
    public String mostrarLlibre(String isbn) {
        if (llibres.containsKey(isbn)) {
            return llibres.get(isbn).toString();
        }
        else {
            return "No s'ha trobat el llibre.";
        }
    }
    
    public boolean existeixLlibre(String isbn) {
        if (llibres.containsKey(isbn)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public String mostrarLlibres() {
        java.util.Iterator<java.util.Map.Entry<String, Llibre>> iterador = llibres.entrySet().iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next().toString());
        }
        return "";
    }
    
    public int obtenirTotalLlibres() {
        return llibres.size();
    }

    public Cataleg() {
        this.llibres = new HashMap();
    }
    
}
