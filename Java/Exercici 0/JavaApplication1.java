/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author guest-rzjr3w
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        --------Declaració de variables------

        primera lletra minuscula. Següents paraules, primera lletra majuscula.

        tipus nomDeLaVariable = valor

        int s'inicialitza sempre a 0
        booleans a false
        strings amb cadena buida ""
        objectes amb NULL


        -------Tipus de dades---------

        valors enters:
        byte = 8 bits
        short = 16 bits
        int = 32 bits
        long = 64 bits

        valors decimals:
        float = 32 bits
        double = 64 bits

        caracters:
        char = 16 bits

        logic:
        boolean = true/false (valor diferent de 0 = true)

        objectes:
        object


        -------Literals---------

        \n = salt de línia
        \t = tabulador
        \' = escriu comilla simple
        \" escriu comilla doble
        \\ = escriu barra invertida


        --------Operadors-----------

        Assignació:
        =   (x=y)   assigna el valor de y a x

        Aritmètics:
        ++  (x++)   incrementa el valor en 1
        --  (x--)   decreix el valor en 1
        -   (-x)    canvia de signe
        *   (x*y)   multiplica x per y
        /   (x/y)   divideix x per y
        %   (x%y)   residu de la divisió entera (si el residu de x/2 es 0 es parell)
        +=  (x=x+y)
        -=  (x=x-y)
        *=  (x=x*y)
        /=  (x=x/y)
        %=  (x=x%y)

        Binaris:
        (!)     Not     (!x)
        <<      Desplaçament a l'esquerra   (x<<2)
        >>      Desplaçament a la dreta     (x>>2)
        &       And
        |       Or
        ^       Xor

        Comparació: (Només es poden comparar dos variables amb el mateix tipus)
        !=      Diferent
        ==      Igual
        >       Major
        >=      Major o igual
        <       Menor
        <=      Menor o igual

        Mai comparar objectes.
        Per comparar strings variable.equals(variable2)


        -------Sentències-------

        En "general" totes les sentències acaben amb ";"

        Sentències en bloc:
        sentencia1;
        sentencia2;


        Sèntencies condicionals:
        if (condicio) sentencia;
        else if (condicio) {
            sentencia1;
            sentencia2;
        }
        else { sentencia }
        
        switch (expressio) {
            case valor1:
                sentencia1;
                sentencia2;
                break;
            case valor2;
                sentencia;
                break;
            default:
                break;
        }

        Bucles:

        while (condicio) {
            sentenica1;
            sentenica2;
        }
        
        do {
            sentencia;
        } while(true);
        
        do {
        sentencia;
        break;
        }
        
        for (inicialització; terminació(mentre); operació) {
            sentencia;
        }
        
        foreach () {
            
        }
        El foreach necessita una col·lecció de dades del tipus que sigui. Ex.: array d'enters
        
        */
        String hola = "\'hola\'";

        String uno = "hyh";
        String dos = "feeg";
        if (uno.equals(dos)) { dos = "igbrig"; }

        if(2%2==0) System.out.println("El nombre es parell");
        else { System.out.println("El nombre es senar"); }

        switch (1+2) {
            case 1:
                int x = 0;
                int y = x++;
                break;
            case 2:
                int xy = 445;
                break;
            default:
                break;
        }
        
        int edatDelGos = 3, edatDelGat = 0;
        while (edatDelGat!=edatDelGos) {
            edatDelGat++;
        }
        
        for (int x = 0; x < 15; x++) {
            int y = 2;
        }
        
        int a = 1;
        for (int i = 1; i <= 100; i++) {
            if (a%5==0) continue;
            if (a > 1000) break;
            a += a*2+1;
        }
        
        int[] array = new int[10];
        for (int element:array) {
            System.out.println("L'element actual de l'array es "+element);
        }
        
        Punt elMeuPunt;
        elMeuPunt = new Punt(1, 1);     // Instància/objecte de la classe Punt
        Punt segonPunt = new Punt(5, 5);
        System.out.println("Ara el meu punt val "+elMeuPunt.toString());
        System.out.println("Ara el segon punt val "+segonPunt.toString());
        
        elMeuPunt.setX(0);
        
        Vector vect1 = new Vector(elMeuPunt, segonPunt);
        System.out.println("vect1 val "+vect1.toString());
        
        
        Vector vect2 = new Vector(new Punt(7, 8), new Punt(66,9));
        System.out.println("vect2 val "+vect2.toString());
        vect2.getDesv().setY(666);
        System.out.println("vect2 val "+vect2.toString());
        
        double origX, origY, desvX, desvY, modul;
        origX = vect2.getOrig().getX();
        origY = vect2.getOrig().getY();
        desvX = vect2.getDesv().getX();
        desvY = vect2.getDesv().getY();
        modul = Math.sqrt(((Math.pow(desvX-origX, 2))+(Math.pow(desvY-origY, 2))));
        System.out.println("modul val "+modul);
        
        double mod = vect2.modul();
        System.out.println("mod val "+mod);
        System.out.println(vect2.modul());
        
        System.out.println(Vector.modul(vect2));
        
        
    }
    
    public static int edat() {
        return 0;
    }
}