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
public abstract class Fitxa {
    protected String referencia;
    protected String titol;
    
    public String getReferencia() {
        return referencia;
    }
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    public String getTitol() {
        return titol;
    }
    
    public void setTitol(String titol) {
        this.titol = titol;
    }
    
    public void visualitzar() {
        System.out.println("Referència: "+this.getReferencia()+", títol: "+this.getTitol());
    }
    
    @Override
    public String toString() {
        return this.getReferencia()+" - "+this.getTitol();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        else if (this.getClass() == o.getClass() && this.getReferencia().compareTo(((Fitxa)o).getReferencia()) == 0) {
            return true;
        }
        return false;
    }

    public Fitxa(String referencia, String titol) {
        setReferencia(referencia);
        setTitol(titol);
    }
    
    public static void main(String[] args) {
        
        Volum vol = new Volum((short)10, "Sergi", (short)10, "Ref", "El volum");
        Volum vol2 = new Volum((short)12, "Kevin", (short)9, "Ref", "El volum2");
        
        System.out.println(vol.equals(vol2));
        
        Obra obra1 = new Obra("Sergiu", (short)6, "trihgitb", "el titol");
        
        obra1.visualitzar();
                        
    }
}
