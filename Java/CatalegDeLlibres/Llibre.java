/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalegDeLlibres;

/**
 *
 * @author guest-whfpv2
 */
public class Llibre {
    private String isbn;
    private String titol;
    private String coleccio;
    private byte volum;
    private String autor;
    private String editorial;
    private String resum;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getColeccio() {
        return coleccio;
    }

    public void setColeccio(String coleccio) {
        this.coleccio = coleccio;
    }

    public byte getVolum() {
        return volum;
    }

    public void setVolum(byte volum) {
        this.volum = volum;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getResum() {
        return resum;
    }

    public void setResum(String resum) {
        this.resum = resum;
    }

    @Override
    public String toString() {
        return this.getIsbn() + "\n" + this.getTitol() + "\n" + this.getColeccio() + "\n" + this.getVolum() + "\n" + this.getAutor()+ "\n" + this.getEditorial()+ "\n" + this.getResum() + "\n";
    }

    public Llibre(String isbn, String titol, String coleccio, byte volum, String autor, String editorial, String resum) {
        this.isbn = isbn;
        this.titol = titol;
        this.coleccio = coleccio;
        this.volum = volum;
        this.autor = autor;
        this.editorial = editorial;
        this.resum = resum;
    }
        
}
