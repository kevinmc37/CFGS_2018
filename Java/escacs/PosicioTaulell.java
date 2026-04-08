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
public final class PosicioTaulell {
    private int fila;
    private int columna;
        
    public int getFila() {
        return this.fila;
    }
    
    private void setFila(int fila) {
        if (fila >= 1 || fila <= 8) { this.fila = fila; }
        else { this.fila = 0; }
    }
    
    public int getColumna() {
        return this.columna;
    }
    
    private void setColumna(int columna) {
        if (columna >= 1 || columna <= 8) { this.columna = columna; }
        else { this.columna = 0; }
    }
    
    public String getPosicio() {
        String posicio = "";
        if (this.getFila() == 0 || this.getColumna() == 0) {
            return posicio;
        }
        int columnaLletra = this.getColumna()+96;
        char ascii = (char) columnaLletra;
        return posicio+(ascii)+this.getFila();
    }
    
    public String getColor() {
        if (((this.getColumna() % 2) == 0 && (this.getFila() % 2) == 0) || ((this.getColumna() % 2) != 0 && (this.getFila() % 2) != 0)) {
            return "B";
        }
        else if (((this.getColumna() % 2) != 0 && (this.getFila() % 2) == 0) || ((this.getColumna() % 2) == 0 && (this.getFila() % 2) != 0)) {
            return "N";
        }
        return "";
    }
    
    PosicioTaulell(int fila, int columna) {
        this.setFila(fila);
        this.setColumna(columna);
    }
    
}
