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
public class Mag extends Personatge {
    private String poder;
    
    public String getPoder() {
        return poder;
    }
    
    public void setPoder(String poder) {
        this.poder = poder;
    }
    
    public String encantar() {
        if (this.getEnergia() > 2) {
            this.setEnergia(this.getEnergia()-2);
        }
        return this.getPoder();
    }
    
    @Override
    public void alimentarse(int energianova) {
        if (this.getEnergia()+energianova > 100) {
            this.setEnergia(100);
        }
        else {
            this.setEnergia(this.getEnergia()+energianova);
        }
    }
    
    @Override
    public void mostrar() {
        System.out.println("Nom: "+getNom());
        System.out.println("Energia: "+getEnergia());
        System.out.println("Poder: "+getPoder());
    }
    
    public Mag(String nom, String poder) {
        super(nom);
        this.setPoder(poder);
    }
    
}