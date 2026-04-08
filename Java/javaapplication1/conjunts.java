package javaapplication1;
import java.util.HashSet;

public class conjunts {
    
    public static void main(String[] args) {
        
        HashSet<Integer> enters = new HashSet<Integer>(); // Cerques ràpides sense ordenar
        if (enters.add(3)) { System.out.println("El valor 3 ja exiteix a la col·lecció"); }
        // Add retorna true o false
        java.util.Random randomGenerator = new java.util.Random();
        for (int compt = 0; compt <= 10; compt++) {
            int randomInt = randomGenerator.nextInt(20); // Aleatoris entre 0 i 20
            if (!enters.add(randomInt)) { System.out.println("El valor "+randomInt+" ja exiteix a la col·lecció"); }
        }
        System.out.println("Els valors de la col·leccó són:");
        for (Integer num : enters) {
            System.out.println(num);
        }
        
        
        
    }
    
    
}