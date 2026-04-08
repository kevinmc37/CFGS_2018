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
public class ComunitatAutonoma {
    private int codiCA;
    private String nomCA;

    public int getCodiCA() {
        return codiCA;
    }

    public String getNomCA() {
        return nomCA;
    }

    public void setCodiCA(int codiCA) {
        this.codiCA = codiCA;
    }

    public void setNomCA(String nomCA) {
        this.nomCA = nomCA;
    }
    
    @Override
    public String toString() {
        return "#"+getCodiCA()+" "+getNomCA();
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
        final ComunitatAutonoma other = (ComunitatAutonoma) obj;
        if (this.codiCA != other.codiCA) {
            return false;
        }
        return true;
    }

    public ComunitatAutonoma(int codiCA, String nomCA) {
        setCodiCA(codiCA);
        setNomCA(nomCA);
    }
    
}
