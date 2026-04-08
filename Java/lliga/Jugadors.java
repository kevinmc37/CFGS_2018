/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lliga;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guest-zd73pj
 */
public class Jugadors {
    
    private static ResultSet resultat;

    private static ResultSet getResultat() { return resultat; }

    private static void setResultat(ResultSet resultat) { Jugadors.resultat = resultat; }
    
    public static ResultSet obtenirJugadors() {
        setResultat(JavaConnection.executarConsultaSeleccio(Jugador.crearConsulta()));
        return getResultat();
    }
    
    public static ResultSet obtenirJugadors(java.util.Collection<String> campsWhere) {
        setResultat(JavaConnection.executarConsultaSeleccio(Jugador.crearConsulta(campsWhere)));
        return getResultat();
    }
    
    public static ResultSet obtenirJugadorsByEquip(int eqId) {
        java.util.ArrayList<String> campsWhere = new java.util.ArrayList();
        campsWhere.add(Jugador.TEAM_ID_FIELD);
        setResultat(JavaConnection.obtenirById(Jugador.crearConsulta(campsWhere), eqId));
        return getResultat();
    }
    
    private static boolean hiHaRegistre() {
        try {
            if (getResultat() == null || getResultat().isAfterLast() || getResultat().isBeforeFirst()) { return false; }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }
    
    public static boolean pucEnrere() {
        try {
            if (getResultat() == null || getResultat().isFirst() || getResultat().isBeforeFirst()) { return false; }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }
    
    public static boolean pucEndavant() {
        try {
            if (getResultat() == null || getResultat().isLast() || getResultat().isAfterLast()) { return false; }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }
    
    public static Jugador actual() {
        ResultSet rs = getResultat();
        Jugador jugador = null;
        try {
            if (hiHaRegistre()) {
                jugador = new Jugador();
                jugador.setJugId(rs.getInt(Jugador.PLAYER_ID_FIELD));
                jugador.setEqId(rs.getInt(Jugador.TEAM_ID_FIELD));
                jugador.setJugNom(rs.getString(Jugador.PLAYER_NAME_FIELD));
                jugador.setDorsal(rs.getInt(Jugador.DORSAL_FIELD));
                jugador.setEdat(rs.getInt(Jugador.AGE_FIELD));
            }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return jugador;
    }
    
    public static Jugador primer() {
        try {
            if (resultat != null && !resultat.isFirst()) { resultat.first(); }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return actual();
    }
    
    public static Jugador ultim() {
        try {
            if (resultat != null && !resultat.isLast()) { resultat.last(); }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return actual();
    }
    
    public static Jugador anterior() {
        try {
            if (resultat != null && !resultat.isFirst()) { resultat.previous(); }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return actual();
    }
    
    public static Jugador posterior() {
        try {
            if (resultat != null && !resultat.isLast()) { resultat.next(); }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return actual();
    }
    
    public static void afegirJugador(Jugador jugador) {
        try {
            ResultSet rs = getResultat();
            rs.moveToInsertRow();
            rs.updateInt(Jugador.PLAYER_ID_FIELD, jugador.getJugId());
            rs.updateInt(Jugador.TEAM_ID_FIELD, jugador.getEqId());
            rs.updateString(Jugador.PLAYER_NAME_FIELD, jugador.getJugNom());
            rs.updateInt(Jugador.DORSAL_FIELD, jugador.getDorsal());
            rs.updateInt(Jugador.AGE_FIELD, jugador.getEdat());
            rs.insertRow();
            tancar();
            setResultat(rs);
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static void updateJugador(Jugador jugador) {
        try {
            ResultSet rs = getResultat();
            rs.updateInt(Jugador.PLAYER_ID_FIELD, jugador.getJugId());
            rs.updateInt(Jugador.TEAM_ID_FIELD, jugador.getEqId());
            rs.updateString(Jugador.PLAYER_NAME_FIELD, jugador.getJugNom());
            rs.updateInt(Jugador.DORSAL_FIELD, jugador.getDorsal());
            rs.updateInt(Jugador.AGE_FIELD, jugador.getEdat());
            rs.updateRow();
            setResultat(rs);
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static boolean eliminarJugador() {
        try { getResultat().deleteRow(); }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }
   
    public static boolean eliminarJugador(int jugId) {
        try {
            ResultSet rs = getResultat();
            if (rs != null) {
                while (rs.next()) {
                    if (rs.getInt(Jugador.PLAYER_ID_FIELD) == jugId) {
                        rs.deleteRow();
                        break;
                    }
                }
            }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }
    
    private static void tancar() {
        try { getResultat().close(); }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
