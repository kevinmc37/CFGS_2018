/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escacs;

/**
 *
 * @author guest-5jrzxe
 */
public class DamaNegra extends Dama {
    
    @Override
    public void setColor(String color) {
        if (color == "N") { super.setColor(color); }
    }
    
    public void DamaNegra() {
        PosicioTaulell posicioE8 = new PosicioTaulell(8, 5);
        setPosicio(posicioE8);
        setColor("N");
    }
    
    public void DamaNegra(PosicioTaulell posicio) {
        setPosicio(posicio);
        setColor("N");
    }
}
