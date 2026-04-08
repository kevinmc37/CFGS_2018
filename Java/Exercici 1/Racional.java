/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author guest-cpermd
 */
public class Racional {
    private int numerador;
    private int denominador;
    
    public int getNumerador() {
        return numerador;
    }
    
    public int getDenominador() {
        return denominador;
    }
    
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }
    
    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
    
    public int mcd(int numerador, int denominador) {
        int mcd;
        if (denominador == 0) { mcd = numerador; }
        else { mcd = mcd(denominador,numerador % denominador); }
        return mcd;
    }
        
    public void simplifica(int numerador, int denominador) {
        int mcd = mcd(numerador, denominador);
        this.numerador = numerador/mcd;
        this.denominador = denominador/mcd;
    }
    
    public void suma(int numerador, int denominador) {
        if (this.getDenominador() != denominador) {
            this.numerador = (this.getNumerador() * denominador) + (numerador * this.getDenominador());
            this.denominador = this.getDenominador() * denominador;
        }
        else { this.numerador = this.getNumerador() + numerador; }
        simplifica(this.getNumerador(), this.getDenominador());
    }
    
    public void resta(int numerador, int denominador) {
        this.numerador = (this.getNumerador() * denominador) - (numerador * this.getDenominador());
        this.denominador = this.getDenominador() * denominador;
        simplifica(this.getNumerador(), this.getDenominador());
    }
    
    public void multiplicaPer(int numerador, int denominador) {
        this.numerador = this.getNumerador() * numerador;
        this.denominador = this.getDenominador() * denominador;
        simplifica(this.getNumerador(), this.getDenominador());
    }
    
    public void divideixPer(int numerador, int denominador) {
        this.numerador = this.getNumerador() * denominador;
        this.denominador = this.getDenominador() * numerador;
        simplifica(this.getNumerador(), this.getDenominador());
    }
    
    public String aString() {
        String cadena = this.getNumerador()+"/"+this.getDenominador();
        return cadena;
    }
    
    Racional() {
        this.setNumerador(0);
        this.setDenominador(1);
    }
    
    Racional(int numerador, int denominador) {
        this.setNumerador(numerador);
        this.setDenominador(denominador);
    }
    
}