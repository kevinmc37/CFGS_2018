/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moraleskevinexuf5;

/**
 *
 * @author guest-nk7ql1
 */
public class Pilot {
    private int dorsal;
    private String nacionalitat;
    private String nom;
    private boolean titular;
    private String sigles;
    private String codiEscuderia;
    private String codiEscuderia2;

    public Pilot(int dorsal, String nacionalitat, String nom, boolean titular, String sigles, String codiEscuderia) {
        this.dorsal = dorsal;
        this.nacionalitat = nacionalitat;
        this.nom = nom;
        this.titular = titular;
        this.sigles = sigles;
        this.codiEscuderia = codiEscuderia;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getTitular() {
        return titular;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }

    public String getSigles() {
        return sigles;
    }

    public void setSigles(String sigles) {
        this.sigles = sigles;
    }

    public String getCodiEscuderia() {
        return codiEscuderia;
    }

    public void setCodiEscuderia(String codiEscuderia) {
        this.codiEscuderia = codiEscuderia;
    }

    public String getCodiEscuderia2() {
        return codiEscuderia2;
    }

    public void setCodiEscuderia2(String codiEscuderia2) {
        this.codiEscuderia2 = codiEscuderia2;
    }

    @Override
    public String toString() {
        return this.getDorsal() + "\n" + this.getNacionalitat() + "\n" + this.getNom() + "\n" + this.getTitular() + "\n" + this.getSigles() + "\n" + "\n" + this.getCodiEscuderia() + "\n" + this.getCodiEscuderia2() + "\n";
    }
    
}
