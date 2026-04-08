/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author guest-o12ltw
 */
public class Vector {
    private Punt origen;
    private Punt desviacio;
    
    public Punt getOrig() {
        return origen;
    }
    
    public Punt getDesv() {
        return desviacio;
    }
    
    public void setOrig(Punt origen) {
        this.origen = origen;
    }
    
    public void setDesv(Punt desviacio) {
        this.desviacio = desviacio;
    }
    
    public double modul() {
        //float base = desviacio.getX() - origen.getX();
        //float alt = desviacio.getY() - origen.getY();
        return modul(this); //Math.sqrt(((Math.pow(base, 2))+(Math.pow(alt, 2))));
    }
    
    public static double modul(Vector v) {
        float base = v.desviacio.getX() - v.origen.getX();
        float alt = v.desviacio.getY() - v.origen.getY();
        return Math.sqrt(((Math.pow(base, 2))+(Math.pow(alt, 2))));
    }
    
    Vector() { // Inicialitzem sempre al constructor
        origen = new Punt(0,0);
        desviacio = new Punt(0,0);
    }
    
    Vector(Punt origen, Punt desviacio) {
        this.origen = origen;
        this.desviacio = desviacio;
    }
    
    @Override
    public String toString() {
        return "Origen: "+this.getOrig().toString()+"\nDesviació: "+this.getDesv().toString();
    }
    
}