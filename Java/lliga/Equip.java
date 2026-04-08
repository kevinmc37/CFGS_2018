/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lliga;

/**
 *
 * @author guest-hiubkg
 */
public class Equip implements Comparable<Equip> {
    
    public static final String TABLE_NAME = "EQUIPS";
    public static final String ID_FIELD = "EQ_ID";
    public static final String NAME_FIELD = "EQ_NOM";
    public static final String STADIUM_FIELD = "ESTADI";
    public static final String POBLATION_FIELD = "POBLACIO";
    public static final String POSTAL_CODE_FIELD = "COD_POSTAL";
    public static final String ALL_FIELDS =
            ID_FIELD + ", " + NAME_FIELD + ", " + STADIUM_FIELD + ", " +
            POBLATION_FIELD + ", " + POSTAL_CODE_FIELD;
    
    private int eqId;
    private String eqNom;
    private String estadi;
    private String poblacio;
    private String codPostal;
    
    public Equip() { } // Extreure de la base de dades

    public Equip(int eqId, String eqNom, String estadi, String poblacio, String codPostal) {
        this.eqId = eqId;
        this.eqNom = eqNom;
        this.estadi = estadi;
        this.poblacio = poblacio;
        this.codPostal = codPostal;
    }

    public int getEqId() { return eqId; }

    public String getEqNom() { return eqNom; }

    public String getEstadi() { return estadi; }

    public String getPoblacio() { return poblacio; }

    public String getCodPostal() { return codPostal; }

    public void setEqId(int eqId) { this.eqId = eqId; }

    public void setEqNom(String nom) { this.eqNom = nom; }

    public void setEstadi(String estadi) { this.estadi = estadi; }

    public void setPoblacio(String municipi) { this.poblacio = municipi; }

    public void setCodPostal(String cPostal) { this.codPostal = cPostal; }

    @Override
    public String toString() { return "Equip{" + "eqId=" + eqId + ", eqNom=" + eqNom + ", estadi=" + estadi + ", poblacio=" + poblacio + ", codPostal=" + codPostal + '}'; }
    
    public static String crearConsulta() { return Generic.crearConsulta(ALL_FIELDS, TABLE_NAME); }
    
    public static String crearConsulta(java.util.Collection<String> campsWhere) { return Generic.crearConsulta(ALL_FIELDS, TABLE_NAME, campsWhere); }
    
    public static String crearConsulta(java.util.Collection<String> campsWhere, String order) { return Generic.crearConsulta(ALL_FIELDS, TABLE_NAME, campsWhere, order); }

    public int compareTo(Equip t) {
        if (this.toString() == t.toString()) { return 0; }
        return -1;
    }
        
}