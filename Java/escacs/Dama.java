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
public class Dama extends Peça {
    private String nom = "Dama";
        
    @Override
    public String getNom() {
        return "Dama";
    }
    
    @Override
    public boolean moure(PosicioTaulell posicio) {
        PosicioTaulell posicioAssolir = new PosicioTaulell(8, 8);
        if ((posicio.getColumna()-posicioAssolir.getColumna() < 1) || ((posicio.getFila()-posicioAssolir.getFila() < 1))) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean menjar(Peça peça) {
        return false;
    }    
    
    Dama() {
        PosicioTaulell posicioD1 = new PosicioTaulell(1, 4);
        setPosicio(posicioD1);
        setColor("B");
    }
    
    Dama(PosicioTaulell posicio) {
        setPosicio(posicio);
        setColor("B");
    }
    
}
