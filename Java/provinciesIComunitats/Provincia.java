/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provinciesIComunitats;

/**
 *
 * @author guest-mramzu
 */
public class Provincia {
    private int codiProv;
    private int codiCA;
    private String nomProv;

    public int getCodiProv() {
        return codiProv;
    }

    public int getCodiCA() {
        return codiCA;
    }

    public String getNomProv() {
        return nomProv;
    }

    public void setCodiProv(int codiProv) {
        this.codiProv = codiProv;
    }

    public void setCodiCA(int codiCA) {
        this.codiCA = codiCA;
    }

    public void setNomProv(String nomProv) {
        this.nomProv = nomProv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.codiCA;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Provincia other = (Provincia) obj;
        if (this.codiProv != other.codiProv) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "Província: "+getNomProv()+", codi província: "+getCodiProv()+", codi comunitat autònoma: "+getCodiCA();
    }

    public Provincia(int codiProv, int codiCA, String nomProv) {
        setCodiProv(codiProv);
        setCodiCA(codiCA);
        setNomProv(nomProv);
    }

}
