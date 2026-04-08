/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lliga;

/**
 *
 * @author guest-y4twla
 */
public class Lliga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Equip nouEquip = new Equip(15, "grgrt", "drgrgr", "grgrhr", "rigb");
        Equips.obtenirEquips();
        Equips.afegirEquip(nouEquip);
    }
    
}