/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author guest-beu8q9
 */
public class Alumne extends Persona {
    private String grup;
    private double notaMitjana;
    
    public String getGrup() {
        return grup;
    }
    
    public double getNotaMitjana() {
        return notaMitjana;
    }
    
    public void setGrup(String grup) {
        this.grup = grup;
    }
    
    public void setNotaMitjana(double notaMitjana) {
        if (notaMitjana >= 0 && notaMitjana <= 10) {
            this.notaMitjana = notaMitjana;
        }
    }
    
    @Override
    public void saluda() {
        super.saluda();
        System.out.println("Salutacions des d'Alumne");
    }
    
    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Grup: "+getGrup());
        System.out.println("Nota mitjana: "+getNotaMitjana());
    }
    
    Alumne(String nom, String cognoms, java.util.Date dataNaixement, String grup, double notaMitjana) {
        super(nom, cognoms, dataNaixement);
        this.setGrup(grup);
        this.setNotaMitjana(notaMitjana);
    }
    
}