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
public class Quadrat extends Forma {
    protected double base;
    
    public static final double base_def = 1;
    
    public double getBase() {
        return base;
    }
    
    public void setBase(double base) {
        if (base < 0) {
            this.base = base_def;
        }
        else {
            this.base = base;
        }
    }
    
    @Override
    public double getArea() {
        return Math.pow(base, 2);
    }
    
    @Override
    public double getPerimetre() {
        return 4*base;
    }
    
    public Quadrat() {
        this(base_def);
    }
    
    public Quadrat(double base) {
        this(base, Forma.color_def, Forma.solid_def);
    }
    
    public Quadrat(double base, String color, boolean solid) {
        super(color, solid);
        setBase(base);
    }
    
}
