package com.Silas.oop.senior.test6;

public class Car extends MeansOfTransportation{
    public Car() {
    }

    public Car(String brand, double speed) {
        super(brand, speed);
    }

    public void move(){
        System.out.println(getBrand()+"汽车正在以"+getSpeed()+"km/h的速度行驶");
    }

    public void honk(){
        System.out.println("鸣笛——");
    }
}
