/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author guest-ou7knn
 */
public class Cercle extends Forma {
    protected double radi;
    
    public static final double radi_def = 1;
    
    public double getRadi() { return radi; }
    
    public void setRadi(double radi) {
        if (radi < 0) {this.radi = radi_def; }
        else { this.radi = radi; }
    }
    
    @Override
    public double getArea() {
        return Math.PI*Math.pow(radi, 2);
    }
    
    @Override
    public double getPerimetre() {
        return 2*Math.PI*radi;
    }
    
    public Cercle() {
        this(radi_def);
    }
    
    public Cercle(double radi) {
        this(radi, Forma.color_def, Forma.solid_def);
    }
    
    public Cercle(double radi, String color, boolean solid) {
        super(color, solid);
        setRadi(radi);
    }
    
}
