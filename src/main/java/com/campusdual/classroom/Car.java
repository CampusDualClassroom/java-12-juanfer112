package com.campusdual.classroom;

public class Car {
    public String brand;
    public String model;
    public static final int MAX_SPEED = 120;
    public String fuel;
    public int speedometer = 0;
    public int tachometer = 0;
    public String gear = "N";
    public boolean reverse = false;
    public int wheelsAngle = 0;

    public Car(){}

    public Car(String brand, String model, String fuel) {
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
    }


    public void start() {
        if(this.isTachometerGreaterThanZero()){
            System.out.println("O Vehiculo xa está encendido");
        } else {
            this.tachometer = 1000;
            System.out.println("Vehiculo acendido");
        }
    }
    public void stop() {
        if( this.speedometer == 0 ) {
            this.tachometer = 0;
            System.out.println("Vehiculo apagado");
        } else {
            System.out.println("Non se pode apagar o vehiculo, primero ten que estar detenido");
        }
    }

    public boolean isTachometerGreaterThanZero(){
        return this.tachometer > 0;
    }

    public boolean isTachometerEqualToZero() {
        return this.tachometer == 0;
    }

    public void accelerate(){
        if(this.speedometer < MAX_SPEED) {
            this.speedometer += 5;
            System.out.println("acelerando Vehiculo");
        } else {
            System.out.println("Non se pode acelerar mas o vehiculo");
        }
    }


    public void brake(){
        if(this.speedometer > 0) {
            this.speedometer -=5;
            System.out.println("frenando Vehiculo");
        } else {
            System.out.println("Vehiculo detenido");
        }
    }

    public void turnAngleOfWheels(int angle){
        if(angle < -45) {
            this.wheelsAngle = -45;
        } else if (angle > 45) {
            this.wheelsAngle = 45;
        } else {
            this.wheelsAngle = angle;
        }
    }

    public String showSteeringWheelDetail(){
        return "";
    }
    public boolean isReverse() {
        return false;
    }
    public void setReverse(boolean reverse){
        if(this.speedometer == 0 && reverse) {
            this.reverse = reverse;
            this.gear = "R";
        } else {
            System.out.println("No es posible cambiar a retroceso cuando el vehiculo esta en movimiento");
        }
    }

    public void showDetails(){}

}
