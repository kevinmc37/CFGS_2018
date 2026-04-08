/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lliga;

import java.util.Iterator;

/**
 *
 * @author guest-y4twla
 */
public class Generic {
    
    public static String crearConsulta(String fields, String table) { return "SELECT " + fields + " FROM " + table; }
    
    public static String crearConsulta(String fields, String table, java.util.Collection<String> campsWhere) {
        String query = crearConsulta(fields, table);
        String where = "";
        if (campsWhere != null && !campsWhere.isEmpty()) {
            String and = "";
            where = " WHERE ";
            Iterator<String> it = campsWhere.iterator();
            while (it.hasNext()) {
                String camp = it.next();
                where += and + camp + " = ?";
                and = " AND ";
            }
        }
        return query + where;
    }
    
    public static String crearConsulta(String fields, String table, java.util.Collection<String> campsWhere, String order) {
        String query = crearConsulta(fields, table, campsWhere);
        if (order.length() > 0) { query += " ORDER BY " + order; }
        return query;
    }
    
}