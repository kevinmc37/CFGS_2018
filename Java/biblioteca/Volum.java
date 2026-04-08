/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author guest-i2rwly
 */
public final class Volum extends Obra {
    private short numVolum;
    
    public static final short numVolum_def = 1;
    
    public short getNumVolum() {
        return numVolum;
    }
    
    public void setNumVolum(short numVolum) {
        if (numVolum < 0) { this.numVolum = numVolum_def; }
        else { this.numVolum = numVolum; }
    }
    
    @Override
    public void visualitzar() {
        super.visualitzar();
        System.out.println("Nº volum: "+this.getNumVolum());
    }
        
    public Volum(short numVolum, String autor, short numPags, String referencia, String titol) {
        super(autor, numPags, referencia, titol);
        setNumVolum(numVolum);
    }
}
