package com.campusdual.classroom;

public class Exercise12 {
    public static void main(String[] args) {
        Car myCar = new Car("Citroën", "Xsara", "Diesel");

        myCar.start();

        for(int acc = 0; acc <= 6; acc++) {
            myCar.accelerate();
        }

        myCar.brake();

        myCar.showDetails();
    }

}