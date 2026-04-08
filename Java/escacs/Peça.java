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
public abstract class Peça {
    private String color;
    private PosicioTaulell posicio;
    private boolean mort = false;
        
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        if (color == "B" || color == "N") { this.color = color; }
    }
    
    public PosicioTaulell getPosicio() {
        return this.posicio;
    }
    
    public void setPosicio(PosicioTaulell posicio) {
        if (posicio.getPosicio() != "") { this.posicio = posicio; }
        else { this.posicio = null; }
    }
    
    public void setPosicio(int fila, int columna) {
        if (fila != 0 && columna != 0) {
            PosicioTaulell posicioTauler = new PosicioTaulell(fila, columna);
            this.setPosicio(posicioTauler);
        }
    }
    
    public void matar() {
        this.mort = true;
        PosicioTaulell posicioNova = new PosicioTaulell(0, 0);
        this.setPosicio(posicioNova);
    }
    
    public abstract String getNom();
    
    public abstract boolean moure(PosicioTaulell posicio);
    
    public abstract boolean menjar(Peça peça);
    
}
