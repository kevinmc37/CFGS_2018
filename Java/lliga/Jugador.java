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
public class Jugador {
    
    public static final String TABLE_NAME = "JUGADORS";
    public static final String PLAYER_ID_FIELD = "JUG_ID";
    public static final String TEAM_ID_FIELD = "EQ_ID";
    public static final String PLAYER_NAME_FIELD = "JUG_NOM";
    public static final String DORSAL_FIELD = "DORSAL";
    public static final String AGE_FIELD = "EDAT";
    public static final String ALL_FIELDS =
            PLAYER_ID_FIELD + ", " + TEAM_ID_FIELD + ", " + PLAYER_NAME_FIELD + ", " +
            DORSAL_FIELD + ", " + AGE_FIELD;
    
    private int jugId;
    private int eqId;
    private String jugNom;
    private int dorsal;
    private int edat;

    public Jugador() { } // Extreure de la base de dades

    public Jugador(int jugId, int eqId, String jugNom, int dorsal, int edat) {
        this.jugId = jugId;
        this.eqId = eqId;
        this.jugNom = jugNom;
        this.dorsal = dorsal;
        this.edat = edat;
    }

    public int getJugId() { return jugId; }

    public int getEqId() { return eqId; }

    public String getJugNom() { return jugNom; }
    
    public int getDorsal() { return dorsal; }

    public int getEdat() { return edat; }

    public void setJugId(int jugId) { this.jugId = jugId; }

    public void setEqId(int eqId) { this.eqId = eqId; }

    public void setJugNom(String jugNom) { this.jugNom = jugNom; }
    
    public void setDorsal(int dorsal) { this.dorsal = dorsal; }

    public void setEdat(int edat) { this.edat = edat; }

    @Override
    public String toString() { return "Jugador{" + "jugId=" + jugId + ", eqId=" + eqId + ", jugNom=" + jugNom + ", dorsal=" + dorsal + ", edat=" + edat + '}'; }
    
    public static String crearConsulta() { return Generic.crearConsulta(ALL_FIELDS, TABLE_NAME); }
    
    public static String crearConsulta(java.util.Collection<String> campsWhere) { return Generic.crearConsulta(ALL_FIELDS, TABLE_NAME, campsWhere); }
    
    public static String crearConsulta(java.util.Collection<String> campsWhere, String order) { return Generic.crearConsulta(ALL_FIELDS, TABLE_NAME, campsWhere, order); }
    
    public int compareTo(Jugador t) {
        if (this.toString() == t.toString()) { return 0; }
        return -1;
    }
        
}