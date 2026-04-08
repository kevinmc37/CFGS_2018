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
public class Guerrer extends Personatge {
    private String arma;
    
    public String getArma() {
        return arma;
    }
    
    public void setArma(String arma) {
        this.arma = arma;
    }
    
    public String combatre(int gastarEnergia) {
        if (this.getEnergia()-gastarEnergia <= 0) {
            this.setEnergia(0);
        }
        else {
            this.setEnergia(this.getEnergia()-gastarEnergia);
        }
        return "Arma: "+this.getArma()+", energia: "+this.getEnergia();
    }
    
    @Override
    public void mostrar() {
        System.out.println("Nom: "+getNom());
        System.out.println("Energia: "+getEnergia());
        System.out.println("Arma: "+getArma());
    }
    
    public Guerrer(String nom, int energia, String arma) {
        super(nom, energia);
        this.setArma(arma);
    }
    
}