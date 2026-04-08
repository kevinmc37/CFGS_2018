/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

/**
 *
 * @author guest-ipvufx
 */
public class BBDD {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        String creaTaula = "CREATE TABLE EQUIPS" +
            "(EQ_ID NUMBER(8) PRIMARY KEY," +
            "EQ_NOM VARCHAR2(40) NOT NULL," +
            "ESTADI VARCHAR2(40) NOT NULL," +
            "POBLACIO VARCHAR2(20) NOT NULL," +
            "COD_POSTAL VARCHAR2(5))";
            
        // System.out.println(creaTaula);
        // JavaConnection.executarQueryCreacio(creaTaula);
        
        creaTaula = "CREATE TABLE JUGADORS" +
            "(JUG_ID NUMBER(8) PRIMARY KEY," +
            "EQ_ID NUMBER(8) NOT NULL," +
            "JUG_NOM VARCHAR2(40) NOT NULL," +
            "DORSAL NUMBER(2) NOT NULL," +
            "EDAT NUMBER(2) NOT NULL," +
            "CONSTRAINT FK_EQUIP FOREIGN KEY (EQ_ID) REFERENCES EQUIPS (EQ_ID))";
        
        // System.out.println(creaTaula);
        // JavaConnection.executarQueryCreacio(creaTaula);
        
       String insertQuery = "INSERT INTO EQUIPS VALUES(2, 'L''Hospitalet de Llobregat', 'Un lloc màgic', 'L''Hospitalet', '08508')";
       
       /* System.out.println(insertQuery);
       int numFiles = JavaConnection.inserirFila(insertQuery);
       if (numFiles > 0) {
           System.out.println("Bieeeeeeeeeen!!!");
       }
       else {
           System.out.println("Nooooooooooooo!!!");
       } */
       
       /* java.util.ArrayList<Equip> equips = new java.util.ArrayList();
       equips.add(new Equip("FC Barcelona", "Camp Nou", "Barcelona", "08508"));
       equips.add(new Equip("FC Hola", "holuta", "holita", "08508"));
       equips.add(new Equip("FC orjgj", "eufge", "kirhgi", "08508"));
       JavaConnection.inserirEquips(equips); */
       
       // String borrar = "DELETE FROM JUGADORS";
       // JavaConnection.executarQueryCreacio(borrar);
       
       /*java.util.ArrayList<Jugador> jugadors = new java.util.ArrayList();
       jugadors.add(new Jugador(1, "Pepito", 36, 99));
       jugadors.add(new Jugador(1, "Pepito2", 36, 66));
       jugadors.add(new Jugador(6, "Pepito3", 36, 33));
       JavaConnection.inserirJugador(jugadors);*/
       
       // java.util.ArrayList<Equip> equips = JavaConnection.obtenirEquips();
       // if (equips != null) { mostrarColeccio(equips);}
       
       java.util.ArrayList<Jugador> jugadors = JavaConnection.obtenirJugadors();
       if (jugadors != null) { mostrarColeccio(jugadors); }
       
       if(JavaConnection.modificarEdatJugadors()) {
           jugadors = JavaConnection.obtenirJugadors();
           if (jugadors != null) {
               mostrarColeccio(jugadors);
           }
       }
       
    }
    
    private static void mostrarColeccio(java.util.Collection col) {
        java.util.Iterator it = col.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
}