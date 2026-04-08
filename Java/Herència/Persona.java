/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author guest-mmscal
 */
public class Persona {
    private String nom;
    private String cognoms;
    private java.util.Date dataNaixement;
    
    public String getNom() {
        return nom;
    }
    
    public String getCognoms() {
        return cognoms;
    }
    
    public Date getDataNaixement() {
        return dataNaixement;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }
    
    public void setDataNaixement(Date dataNaixement) {
        this.dataNaixement = dataNaixement;
    }
    
    public void saluda() {
        System.out.println("Salutacions des de persona");
    }
    
    public void mostrar() {
        System.out.println("Nom: "+getNom());
        System.out.println("Cognoms: "+getCognoms());
        java.text.SimpleDateFormat dtf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Data de naixement: "+dtf.format(getDataNaixement()));
    }
    
    Persona(String nom, String cognoms, java.util.Date dataNaixement) {
        this.setNom(nom);
        this.setCognoms(cognoms);
        this.setDataNaixement(dataNaixement);
    }
    
    public static void main(String[] args) {
        Alumne alum = new Alumne("Kevin", "Morales Cano", new java.util.Date(97, 3, 05), "2n DAW A", 9.8);
        Professor profe = new Professor("Sergi", "Moreno", new java.util.Date(72, 7, 20), "Programació en entorn servidor", 1000.87);
        
        alum.saluda();
        profe.saluda();
        
        System.out.println("\nDades de l'alumne:");
        alum.mostrar();
        System.out.println("\nDades del professor:");
        profe.mostrar();
    }
    
}