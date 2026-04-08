/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

/**
 *
 * @author guest-hiubkg
 */
public class Equip {
    
    private static int numInst = 5;
    private int eqId = 0;
    private String nom;
    private String estadi;
    private String municipi;
    private String cPostal;
    
    public Equip() { } // Extreure de la base de dades

    public Equip(String nom, String estadi, String municipi, String cPostal) {
        numInst++;
        this.eqId = numInst;
        this.nom = nom;
        this.estadi = estadi;
        this.municipi = municipi;
        this.cPostal = cPostal;
    }

    public static int getNumInst() { return numInst; }

    public int getEqId() { return eqId; }

    public String getNom() { return nom; }

    public String getEstadi() { return estadi; }

    public String getMunicipi() { return municipi; }

    public String getcPostal() { return cPostal; }

    public static void setNumInst(int numInst) { Equip.numInst = numInst; }

    public void setEqId(int eqId) { this.eqId = eqId; }

    public void setNom(String nom) { this.nom = nom; }

    public void setEstadi(String estadi) { this.estadi = estadi; }

    public void setMunicipi(String municipi) { this.municipi = municipi; }

    public void setcPostal(String cPostal) { this.cPostal = cPostal; }

    @Override
    public String toString() { return "Equip{" + "eqId=" + eqId + ", nom=" + nom + ", estadi=" + estadi + ", municipi=" + municipi + ", cPostal=" + cPostal + '}'; }
    
}