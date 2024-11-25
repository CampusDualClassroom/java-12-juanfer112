package com.campusdual.classroom;

/**
 * Representa un coche con funcionalidades básicas para encender, apagar, acelerar, frenar y girar las ruedas.
 */
public class Car {

    static final int MAX_SPEED = 120;
    private static final int MIN_WHEEL_ANGLE = -45;
    private static final int MAX_WHEEL_ANGLE = 45;
    private static final int ACCELERATION_INCREMENT = 5;
    private static final int BRAKE_DECREMENT = 5;

    public String brand;
    public String model;

    public String fuel;
    public int speedometer;
    public int tachometer;
    public String gear;
    public boolean reverse ;
    public int wheelsAngle;

    public Car(){
        this.speedometer = 0;
        this.tachometer = 0;
        this.gear = "N"; // Neutro por defecto
        this.reverse = false;
        this.wheelsAngle = 0;
    }

    public Car(String brand, String model, String fuel) {
        this();
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
    }

    /**
     * Enciende el coche si no está encendido.
     */
    public void start() {
        if(this.isTachometerGreaterThanZero()){
            System.out.println("O Vehiculo xa está encendido");
        } else {
            this.tachometer = 1000;
            System.out.println("Vehiculo acendido");
        }
    }

    /**
     * Apaga el coche si está completamente detenido.
     */
    public void stop() {
        if( this.speedometer == 0 ) {
            this.tachometer = 0;
            System.out.println("Vehiculo apagado");
        } else {
            System.out.println("Non se pode apagar o vehiculo, primero ten que estar detenido");
        }
    }

    /**
     * Acelera el coche aumentando la velocidad.
     */
    public void accelerate(){
        if(this.speedometer < MAX_SPEED) {
            this.speedometer += ACCELERATION_INCREMENT;
            System.out.println("acelerando Vehiculo");
        } else {
            System.out.println("Non se pode acelerar mas o vehiculo");
        }
    }

    /**
     * Reduce la velocidad del coche frenando.
     */
    public void brake(){
        if(this.speedometer > 0) {
            this.speedometer -= BRAKE_DECREMENT;
            System.out.println("frenando Vehiculo");
        } else {
            System.out.println("Vehiculo detenido");
        }
    }

    /**
     * Gira las ruedas del coche a un ángulo específico dentro del rango permitido.
     *
     * @param angle Ángulo al que se deben girar las ruedas.
     */
    public void turnAngleOfWheels(int angle){
        if(angle < MIN_WHEEL_ANGLE) {
            this.wheelsAngle = MIN_WHEEL_ANGLE;
        } else if (angle > MAX_WHEEL_ANGLE) {
            this.wheelsAngle = MAX_WHEEL_ANGLE;
        } else {
            this.wheelsAngle = angle;
        }
        System.out.println("Ángulo de las ruedas ajustado a: " + this.wheelsAngle + " grados.");
    }

    /**
     * Cambia la marcha a reversa si el coche está detenido.
     *
     * @param reverse True si se desea activar la reversa, False en caso contrario.
     */
    public void setReverse(boolean reverse){
        if(this.speedometer == 0 && reverse) {
            this.reverse = reverse;
            this.gear = "R";
        } else if(reverse) {
            System.out.println("No es posible cambiar a reversa mientras el vehículo está en movimiento.");
        }else {
            this.reverse = false;
            this.gear = "N";
            System.out.println("Saliendo de marcha atrás.");
        }
    }

    /**
     * Verifica si el motor del coche está encendido con respecto al tacometro.
     *
     * @return True si el motor está encendido, False en caso contrario.
     */
    public boolean isTachometerGreaterThanZero(){
        return this.tachometer > 0;
    }

    /**
     * Verifica si el motor del coche está apagado con respecto al tacometro.
     *
     * @return True si el motor está apagado, False en caso contrario.
     */
    public boolean isTachometerEqualToZero() {
        return this.tachometer == 0;
    }

    /**
     * Muestra los detalles del coche.
     */
    public void showDetails() {
        System.out.println("Detalles del vehículo:");
        System.out.println("Marca: " + this.brand);
        System.out.println("Modelo: " + this.model);
        System.out.println("Tipo de combustible: " + this.fuel);
        System.out.println("Velocímetro: " + this.speedometer + " km/h.");
        System.out.println("Tacómetro: " + this.tachometer + " rpm.");
        System.out.println("Marcha actual: " + this.gear);
        System.out.println("Reversa: " + (this.reverse ? "Activada" : "Desactivada"));
        System.out.println("Ángulo de las ruedas: " + this.wheelsAngle + " grados.");
    }
}
