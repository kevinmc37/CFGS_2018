/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author guest-o12ltw
 */
public class Punt {
    private float xcoord = 0;
    private float ycoord = 0;
    
    public float getX() {
        return xcoord;
    }
    
    public float getY() {
        return ycoord;
    }
    
    public void setX(float xcoord) {
        this.xcoord = xcoord;
    }
    
    public void setY(float ycoord) {
        this.ycoord = ycoord;
    }
    
    Punt(float xcoord, float ycoord) {
        this.setX(xcoord);
        this.setY(ycoord);
    }
    
    @Override
    public String toString() {
        return "("+getX()+","+getY()+")";
    }
}