package com.Silas.oop.advanced.test3;

public class Circle {
    private double radii;
    private final double PI = 3.14;

    public Circle() {
    }

    public Circle(double radii) {
        this.radii = radii;
    }

    public double getRadii() {
        return radii;
    }

    public void setRadii(double radii) {
        this.radii = radii;
    }

    public double getPI() {
        return PI;
    }

    public double getArea(){
        return PI*radii*radii;
    }

    public double getLength(){
        return 2*PI*radii;
    }

}
