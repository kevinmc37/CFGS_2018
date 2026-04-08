/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diccionaris;

/**
 *
 * @author guest-whfpv2
 */
public class Diccionaris {
    
    public static void main(String[] args) {
        java.util.HashMap<String, Punt> elsMeusPunts = new java.util.HashMap();
        for (int compt1 = 0; compt1 < 20; compt1++) {
            Punt nouPunt = generarPuntAleatori();   // Generem un punt aleatori
            if (!elsMeusPunts.containsKey(nouPunt.toString())) {
                elsMeusPunts.put(nouPunt.toString(), nouPunt);    // Afegim el punt al diccionari
            }
        }
        
        // Intentem modificar la col·lecció. Per poder recórrer-la hem de fer servir l'entrySet() o
        // algun objecte navigable com navigableMap()
        java.util.Iterator<java.util.Map.Entry<String, Punt>> iterador = elsMeusPunts.entrySet().iterator();
        int compt2 = 0;
        while (iterador.hasNext()) {
            System.out.println(compt2+"."+iterador.next());
            compt2++;
        }
        
    }
    
    private static Punt generarPuntAleatori() {
        Punt p;
        p = new Punt(generarNumAleatori(-3, 3), generarNumAleatori(-3, 3));
        return p;
    }
    
    private static int generarNumAleatori(int min, int max) {
        return min+(int)(Math.random()*(max-min));
    }
    
}
