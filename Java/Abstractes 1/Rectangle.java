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
public final class Rectangle extends Quadrat {
    protected double alçada;
    
    public static final double alçada_def = 1;
    
    public double getAlçada() {
        return this.alçada;
    }
    
    public void setAlçada(double alçada) {
        if (alçada < 0) {
            this.alçada = alçada_def;
        }
        else {
            this.alçada = alçada;
        }
    }
    
    @Override
    public double getArea() {
        return getBase()*getAlçada();
    }
    
    @Override
    public double getPerimetre() {
        return 2*(getBase()+getAlçada());
    }
    
    public Rectangle() {
        this(alçada_def);
    }
    
    public Rectangle(double alçada) {
        super();
        this.setAlçada(alçada);
    }
    
    public Rectangle(double alçada, double base, String color, boolean solid) {
        super(base, color, solid);
        setAlçada(alçada);
    }
}
