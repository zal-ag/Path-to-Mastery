package com.Silas.oop.senior.test6;

public class MeansOfTransportation {
    private String brand;
    private double speed;

    public MeansOfTransportation() {
    }

    public MeansOfTransportation(String brand, double speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void move(){
        System.out.println(brand+"正在以"+speed+"km/h的速度行驶");
    }
}
