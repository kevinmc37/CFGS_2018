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
public final class Revista extends Fitxa {
    private short anyo;
    private short numRevista;
    
    public static final short numRevista_def = 1;
    
    public short getAnyo() {
        return anyo;
    }
    
    public void setAnyo(short anyo) {
        this.anyo = anyo;
    }
    
    public short getNumRevista() {
        return numRevista;
    }
    
    public void setNumRevista(short numRevista) {
        if (numRevista < 0) { this.numRevista = numRevista_def; }
        else { this.numRevista = numRevista; }
    }
    
    @Override
    public void visualitzar() {
        super.visualitzar();
        System.out.println("Any: "+this.getAnyo()+"nº revista: "+this.getNumRevista());   
    }
    
    public Revista(short anyo, short numRevista, String referencia, String titol) {
        super(referencia, titol);
        setAnyo(anyo);
        setNumRevista(numRevista);
    }
}
