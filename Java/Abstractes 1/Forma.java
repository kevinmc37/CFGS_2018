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
public abstract class Forma {
    protected String color;
    protected boolean solid;
    
    public static final String color_def = "White";
    public static final boolean solid_def = true;
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean getSolid() {
        return solid;
    }
    
    public void setSolid(boolean solid) {
        this.solid = solid;
    }
    
    public abstract double getArea();
    
    public abstract double getPerimetre();
    
    public Forma() {
        this(color_def, solid_def);
    }
    
    public Forma(String color, boolean solid) {
        this.color = color;
        this.solid = solid;
    }
}
