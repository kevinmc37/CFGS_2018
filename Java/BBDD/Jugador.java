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
public class Jugador {
    
    private static int numInst = 5;
    private int jugId;
    private int eqId;
    private String nom;
    private int edat;
    private int dorsal;

    public Jugador() { } // Extreure de la base de dades

    public Jugador(int eqId, String nom, int edat, int dorsal) {
        numInst++;
        this.jugId = numInst;
        this.eqId = eqId;
        this.nom = nom;
        this.edat = edat;
        this.dorsal = dorsal;
    }

    public static int getNumInst() { return numInst; }

    public int getJugId() { return jugId; }

    public int getEqId() { return eqId; }

    public String getNom() { return nom; }

    public int getEdat() { return edat; }

    public int getDorsal() { return dorsal; }

    public static void setNumInst(int numInst) { Jugador.numInst = numInst; }

    public void setJugId(int jugId) { this.jugId = jugId; }

    public void setEqId(int eqId) { this.eqId = eqId; }

    public void setNom(String nom) { this.nom = nom; }

    public void setEdat(int edat) { this.edat = edat; }

    public void setDorsal(int dorsal) { this.dorsal = dorsal; }

    @Override
    public String toString() { return "Jugador{" + "jugId=" + jugId + ", eqId=" + eqId + ", nom=" + nom + ", edat=" + edat + ", dorsal=" + dorsal + '}'; }
    
}