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
public class Cafetera {
    private int maxCap;
    private int quantActual;
    
    public int getMaxCap() {
        return maxCap;
    }
    
    public void setMaxCap(int maxCap) {
        if (maxCap <= 0) {
            this.maxCap = 1;
        }
        else {
            this.maxCap = maxCap;
        }
    }
    
    public int getQuantActual() {
        return quantActual;
    }
    
    public void setQuantActual(int quantActual) {
        if (quantActual < 0) {
            this.quantActual = 0;
        }
        else {
            this.quantActual = quantActual;
        }
    }
    
    public void emplenarCafetera() {
        this.setQuantActual(this.getMaxCap());
    }
    
    public void servirTassa(int dosi) {
        if (this.quantActual < dosi) {
            this.setQuantActual(0);
        }
        else {
            this.setQuantActual(this.quantActual - dosi);
        }
    }
    
    public void buidarCafetera() {
        this.setQuantActual(0);
    }
    
    public void afegirCafe(int dosi) {
        if ((this.quantActual + dosi) < this.maxCap) {
            this.setQuantActual(this.quantActual + dosi);
        }
        else {
            this.setQuantActual(this.maxCap);
        }
    }
    
    Cafetera() {
        this.maxCap = 1000;
        this.quantActual = 0;
    }
    
    Cafetera(int maxCap) {
        this.maxCap = maxCap;
        this.quantActual = maxCap;
    }
    
    Cafetera(int maxCap, int quantActual) {
        this.maxCap = maxCap;
        if (quantActual > maxCap) {
            this.quantActual = maxCap;
        }
        else {
            this.quantActual = quantActual;
        }
    }
}
