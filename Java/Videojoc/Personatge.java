/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.Videojoc;

/**
 *
 * @author guest-beu8q9
 */
public class Personatge {
    private String nom;
    private int energia;
    
    public String getNom() {
        return nom;
    }
    
    public int getEnergia() {
        return energia;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    
    public void alimentarse(int energiaNova) {
        this.energia = this.getEnergia()+energiaNova;
    }
    
    public void consumirEnergia(int despesaEnergia) {
        this.energia = this.getEnergia()-despesaEnergia;
    }
    
    public void mostrar() {
        System.out.println("Nom: "+getNom());
        System.out.println("Energia: "+getEnergia());
    }
    
    public Personatge(String nom) {
        this.setNom(nom);
        this.setEnergia(100);
    }
    
    public Personatge(String nom, int energia) {
        this.setNom(nom);
        this.setEnergia(energia);
    }
    
    public static void main(String[] args) {
        Guerrer guerr = new Guerrer("Maria la loka", 999, "Ballesta");
        Mag mago = new Mag("jorgeatucasa.com", "Fueeeeeeegoooooo");
        
        System.out.println("\nDades del guerrer:");
        guerr.alimentarse(150);
        guerr.combatre(800);
        guerr.consumirEnergia(200);
        guerr.alimentarse(340);
        guerr.mostrar();
        
        System.out.println("\nDades del mag:");
        mago.encantar();
        mago.encantar();
        mago.alimentarse(3);
        mago.encantar();
        mago.consumirEnergia(35);
        mago.mostrar();
        
    }
    
}