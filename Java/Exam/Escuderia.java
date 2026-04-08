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
public class Escuderia {
    private int num_inst = 0;
    private int codi;
    private String nom;
    private String pais;
    private String xassis;
    private String motor;
    private String neumatics = "Pirelli";

    public Escuderia(String nom, String pais, String xassis, String motor) {
        this.nom = nom;
        this.pais = pais;
        this.xassis = xassis;
        this.motor = motor;
        this.codi = this.num_inst;
    }

    public void setNum_inst(int num_inst) {
        this.num_inst++;
    }

    public int getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getXassis() {
        return xassis;
    }

    public void setXassis(String xassis) {
        this.xassis = xassis;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getNeumatics() {
        return neumatics;
    }

    public void setNeumatics(String neumatics) {
        this.neumatics = neumatics;
    }

    @Override
    public String toString() {
        return this.getNom() + "\n" + this.getPais()+ "\n" + this.getXassis()+ "\n" + this.getMotor()+ "\n" + this.getNeumatics()+ "\n";
    }
    
}
