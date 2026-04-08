/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lliga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author guest-ipvufx
 */
public class JavaConnection {
    
    private static Connection conn = null;
    
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("oracle.jdbc.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1520:XE", "esponjab", "ADMIN");
            }
            catch (ClassNotFoundException | SQLException e) {
                Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return conn;
    }
    
    public static ResultSet executarConsultaSeleccio(String query) {
        ResultSet rs = null;
        try {
            Statement select = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = select.executeQuery(query);
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return rs;
    }
    
    public static ResultSet obtenirById(String query, int id) {
        ResultSet rs = null;
        try {
            PreparedStatement select = getConnection().prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            select.setInt(1, id);
            rs = select.executeQuery();
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return rs;
    }
    
    /*
    
    public static boolean executarQueryCreacio(String query) {
        boolean bRet = false;
        Statement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.createStatement();
            stat.executeUpdate(query);
            bRet = true;
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return bRet;
    }
    
    public static int inserirFila(String query) {
        int iRet = -1;
        Statement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.createStatement();
            iRet = stat.executeUpdate(query);
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return iRet;
    }
    
    public static void inserirEquips(java.util.ArrayList<Equip> equips) {
        try {
            PreparedStatement insertEquips = getConnection().prepareStatement("INSERT INTO equips VALUES(?, ?, ?, ?, ?)");
            java.util.Iterator<Equip> eqIterator = equips.iterator();
            while (eqIterator.hasNext()) {
                Equip eqActual = eqIterator.next();
                insertEquips.setInt(1, eqActual.getEqId());
                insertEquips.setString(2, eqActual.getNom());
                insertEquips.setString(3, eqActual.getEstadi());
                insertEquips.setString(4, eqActual.getMunicipi());
                insertEquips.setString(5, eqActual.getcPostal());
                insertEquips.executeUpdate();
                insertEquips.clearParameters();
            }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static void inserirJugador(java.util.ArrayList<Jugador> jugadors) {
        try {
            PreparedStatement insertJugadors = getConnection().prepareStatement("INSERT INTO jugadors VALUES(?, ?, ?, ?, ?)");
            java.util.Iterator<Jugador> jugIterator = jugadors.iterator();
            while (jugIterator.hasNext()) {
                Jugador jugActual = jugIterator.next();
                insertJugadors.setInt(1, jugActual.getJugId());
                insertJugadors.setInt(2, jugActual.getEqId());
                insertJugadors.setString(3, jugActual.getNom());
                insertJugadors.setInt(5, jugActual.getEdat());
                insertJugadors.setInt(4, jugActual.getDorsal());
                insertJugadors.executeUpdate();
                insertJugadors.clearParameters();
            }
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static java.util.ArrayList<Equip> obtenirEquips() {
        java.util.ArrayList<Equip> equips = null;
        ResultSet eqs = executarConsultaSeleccio("SELECT * FROM EQUIPS");
        if (eqs != null) {
            equips = new java.util.ArrayList();
            try {
                while (eqs.next()) {
                    Equip actual = new Equip();
                    actual.setEqId(eqs.getInt(1));
                    actual.setNom(eqs.getString(2));
                    actual.setEstadi(eqs.getString("ESTADI"));
                    actual.setMunicipi(eqs.getString("POBLACIO"));
                    actual.setcPostal(eqs.getString("COD_POSTAL"));
                    equips.add(actual);
                }
            }
            catch (SQLException e) {
                Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return equips;
    }
    
    public static java.util.ArrayList<Jugador> obtenirJugadors() {
        java.util.ArrayList<Jugador> jugadors = null;
        ResultSet jugs = executarConsultaSeleccio("SELECT * FROM JUGADORS");
        if (jugs != null) {
            jugadors = new java.util.ArrayList();
            try {
                while (jugs.next()) {
                    Jugador actual = new Jugador();
                    actual.setJugId(jugs.getInt("JUG_ID"));
                    actual.setEqId(jugs.getInt("EQ_ID"));
                    actual.setNom(jugs.getString("JUG_NOM"));
                    actual.setDorsal(jugs.getInt("DORSAL"));
                    actual.setEdat(jugs.getInt("EDAT"));
                    jugadors.add(actual);
                }
            }
            catch (SQLException e) {
                Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return jugadors;
    }
    
    public static boolean modificarEdatJugadors() {
        boolean bRet = false;
        try {
            Statement stat = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stat.executeQuery("SELECT edat FROM JUGADORS");
            while (rs.next()) {
                int i = (int)(-8 + Math.random()*16);
                rs.updateInt("EDAT", rs.getInt("EDAT")+i);
                rs.updateRow();
            }
            bRet = true;
        }
        catch (SQLException e) {
            Logger.getLogger(JavaConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return bRet;
    }
    */
}