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
public class Professor extends Persona {
    private String especialitat;
    private double salari;
    
    public String getEspecialitat() {
        return especialitat;
    }
    
    public double getSalari() {
        return salari;
    }
    
    public void setEspecialitat(String especialitat) {
        this.especialitat = especialitat;
    }
    
    public void setSalari(double salari) {
        this.salari = salari;
    }
    
    @Override
    public void saluda() {
        super.saluda();
        System.out.println("Salutacions des de Professor");
    }
    
    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Especialitat: "+getEspecialitat());
        System.out.println("Salari: "+getSalari());
    }
    
    Professor(String nom, String cognoms, java.util.Date dataNaixement, String especialitat, double salari) {
        super(nom, cognoms, dataNaixement);
        this.setEspecialitat(especialitat);
        this.setSalari(salari);
    }
    
}
