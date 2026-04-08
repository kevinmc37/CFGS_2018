/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lliga;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guest-prcnpy
 */
public class Equips {
    
    private static ResultSet resultat;

    private static ResultSet getResultat() { return resultat; }

    private static void setResultat(ResultSet resultat) { Equips.resultat = resultat; }
    
    public static ResultSet obtenirEquips() {
        setResultat(JavaConnection.executarConsultaSeleccio(Equip.crearConsulta()));
        return getResultat();
    }
    
    public static ResultSet obtenirEquips(java.util.Collection<String> campsWhere) {
        setResultat(JavaConnection.executarConsultaSeleccio(Equip.crearConsulta(campsWhere)));
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
    
    public static Equip actual() {
        ResultSet rs = getResultat();
        Equip equip = null;
        try {
            if (hiHaRegistre()) {
                equip = new Equip();
                equip.setEqId(rs.getInt(Equip.ID_FIELD));
                equip.setEqNom(rs.getString(Equip.NAME_FIELD));
                equip.setEstadi(rs.getString(Equip.STADIUM_FIELD));
                equip.setPoblacio(rs.getString(Equip.POBLATION_FIELD));
                equip.setCodPostal(rs.getString(Equip.POSTAL_CODE_FIELD));
            }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return equip;
    }
    
    public static Equip primer() {
        try {
            if (resultat != null && !resultat.isFirst()) { resultat.first(); }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return actual();
    }
    
    public static Equip ultim() {
        try {
            if (resultat != null && !resultat.isLast()) { resultat.last(); }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return actual();
    }
    
    public static Equip anterior() {
        try {
            if (resultat != null && !resultat.isFirst()) { resultat.previous(); }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return actual();
    }
    
    public static Equip posterior() {
        try {
            if (resultat != null && !resultat.isLast()) { resultat.next(); }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return actual();
    }
    
    public static void afegirEquip(Equip equip) {
        try {
            ResultSet rs = getResultat();
            rs.moveToInsertRow();
            rs.updateString(Equip.NAME_FIELD, equip.getEqNom());
            rs.updateString(Equip.STADIUM_FIELD, equip.getEstadi());
            rs.updateString(Equip.POBLATION_FIELD, equip.getPoblacio());
            rs.updateString(Equip.POSTAL_CODE_FIELD, equip.getCodPostal());
            rs.insertRow();
            setResultat(rs);
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static void updateEquip(Equip equip) {
        try {
            ResultSet rs = getResultat();
            rs.updateInt(Equip.ID_FIELD, equip.getEqId());
            rs.updateString(Equip.NAME_FIELD, equip.getEqNom());
            rs.updateString(Equip.STADIUM_FIELD, equip.getEstadi());
            rs.updateString(Equip.POBLATION_FIELD, equip.getPoblacio());
            rs.updateString(Equip.POSTAL_CODE_FIELD, equip.getCodPostal());
            rs.updateRow();
            setResultat(rs);
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static boolean eliminarEquip() {
        try {
            ResultSet rs = getResultat();
            int rowActual = rs.getRow();
            if (rs.isLast()) { rowActual--; }
            rs.deleteRow();
            rs.absolute(rowActual);
            setResultat(rs);
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }
   
    public static boolean eliminarEquip(int eqId) {
        try {
            ResultSet rs = getResultat();
            if (rs != null) {
                while (rs.next()) {
                    if (rs.getInt(Equip.ID_FIELD) == eqId) {
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