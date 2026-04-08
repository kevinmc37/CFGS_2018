/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iteradors;

import java.util.LinkedList;

/**
 *
 * @author guest-8ze2qr
 */
public class iteradors {
    
    public static void main(String[] args) {
        java.util.ArrayList<Integer> llistaEnters = new java.util.ArrayList();
        for (int i = 0; i < 10; i++) {
            llistaEnters.add((int)Math.pow(i+5, 2));
        }
        System.out.println("Abans d'eliminar elements " + llistaEnters.toString());
        
        // Imaginem que volem eliminar de la llista tots aquells elements que siguin múltiples de 3
        // Hem de recórrer la llista i cada vegada que trobem un element que sigui múltiple de 3 l'hem d'eliminar
        // Provem a fer-ho amb un foreach
        
        /*
        
        for (Integer element : llistaEnters) {
            // Comprovem di l'element és múltiple de 3
            if (element % 3 == 0) {
                llistaEnters.remove(element);
            }
        }
        
        */
        
        // Aquest codi dóna error perquè s'està modifican't el tamany de l'estructura que s'està recorrent
        // Si afegim o eliminem elements d'aquesta col·lecció, estem modificant el nombre d'elements que ha de recórrer el bucle
        
        // Declarem un iterador per poder recórrer la col·lecció d'elements
        
        java.util.Iterator<Integer> itEnters = llistaEnters.iterator();
        
        // Recorrem l'iterador amb un bucle while
        // Mentre tinguem un element següent a la col·lecció...
        
        while (itEnters.hasNext()) {
            Integer actual = itEnters.next(); // Amb això consumim el següent element
            if (actual % 3 == 0) {
                // llistaEnters.remove(actual);     // No podem fer això, ho hem de fer a través de l'iterador
                itEnters.remove();
            }
        }
        
        System.out.println("Després d'eliminar elements " + llistaEnters.toString());
        
        // Cridem a les llistesenllaçades
        
        System.out.println("\nLlistes Enllaçades:");
        llistesEnllaçades(llistaEnters);
        
    }
    
    private static void llistesEnllaçades(java.util.Collection<Integer> col) {
        java.util.LinkedList<Integer> llistaEnters = new LinkedList(col);
        
        java.util.Iterator<Integer> descIterator = llistaEnters.descendingIterator();
        
        System.out.println("\nRecorrem a l'invers");
        
        while (descIterator.hasNext()) {
            System.out.println(descIterator.next());
        }
        
        java.util.Iterator<Integer> forIterator = llistaEnters.iterator();
        
        System.out.println("\nRecorregut directe");
        
        while (forIterator.hasNext()) {
            System.out.println(forIterator.next());
        }
        
        java.util.ListIterator<Integer> listIterator = llistaEnters.listIterator();
        
        System.out.println("\nRecorregut directe i invers");
        
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        
        java.util.Scanner sc = new java.util.Scanner(System.in);
        sc.useDelimiter("[:\\s]");

        byte by = 0;
        do {
            by = sc.nextByte();
            switch (by) {
                case 4:
                    if (listIterator.hasPrevious()) {
                        System.out.println("Index: " + listIterator.previousIndex() + "\tValue: " + listIterator.previous());
                    }
                    break;
                case 6:
                    if (listIterator.hasNext()) {
                        System.out.println("Index: " + listIterator.nextIndex() + "\tValue: " + listIterator.next());
                    }
                    break;
            }
        }
        while (by != 0);
    }
    
}
