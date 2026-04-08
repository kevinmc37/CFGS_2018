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
public class Obra extends Fitxa {
    protected String autor;
    protected short numPags;
    
    public static final short numPags_def = 1;
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public short getNumPags() {
        return numPags;
    }
    
    public void setNumPags(short numPags) {
        if (numPags < 0) { this.numPags = numPags_def; }
        else { this.numPags = numPags; }
    }
    
    @Override
    public void visualitzar() {
        super.visualitzar();
        System.out.println("Autor: "+this.getAutor()+", nº pàgines: "+this.getNumPags());
    }
    
    public Obra(String autor, short numPags, String referencia, String titol) {
        super(referencia, titol);
        setAutor(autor);
        setNumPags(numPags);
    }
}
