/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Abdelrahman Hany
 */
public class node {
   private char sympol;
   private double Low_Range;
   private double High_Range;

    public node(char sympol, double Low_Range, double High_Range) {
        this.sympol = sympol;
        this.Low_Range = Low_Range;
        this.High_Range = High_Range;
    }

    public char getSympol() {
        return sympol;
    }

    public void setSympol(char sympol) {
        this.sympol = sympol;
    }

    public double getLow_Range() {
        return Low_Range;
    }

    public void setLow_Range(double Low_Range) {
        this.Low_Range = Low_Range;
    }

    public double getHigh_Range() {
        return High_Range;
    }

    public void setHigh_Range(double High_Range) {
        this.High_Range = High_Range;
    }

    @Override
    public String toString() {
        return "node{" + "sympol=" + sympol + ", Low_Range=" + Low_Range + ", High_Range=" + High_Range + '}';
    }
   

}
