package com.Silas.oop.senior.test6;

public class Bicycle extends MeansOfTransportation{
    public Bicycle() {
    }

    public Bicycle(String brand, double speed) {
        super(brand, speed);
    }

    public void move(){
        System.out.println(getBrand()+"自行车正在以"+getSpeed()+"km/h的速度行驶");
    }

    public void ringBell(){
        System.out.println("响铃——");
    }
}
