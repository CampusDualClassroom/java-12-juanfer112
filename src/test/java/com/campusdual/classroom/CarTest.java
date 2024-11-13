package com.campusdual.classroom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    private Car myCar;

    @BeforeEach
    void setup() {
        this.myCar = new Car();
    }

    @Test
    @DisplayName("Verify if a started car has a tachometer greater than zero")
    void testCarStart() {
        int intialTach = this.myCar.tachometer;
        this.myCar.start();
        assertTrue(this.myCar.isTachometerGreaterThanZero());
        assertTrue(intialTach < this.myCar.tachometer);
    }

    @Test
    @DisplayName("Verify that cannot start a car twice or more")
    void testCarStartWhenAlreadyRunning() {
        this.myCar.start();
        int intialTach = this.myCar.tachometer;
        this.myCar.start();
        assertFalse(intialTach < this.myCar.tachometer);
    }

    @Test
    @DisplayName("Verify that a stopped car has its tachometer is zero")
    void testCarStop() {
        this.myCar.start();
        this.myCar.stop();
        assertTrue(this.myCar.isTachometerEqualToZero());
    }

    @Test
    @DisplayName("Checking that a car cannot be turned off while in motion")
    void testCarStopWhileInMotion() {
        this.myCar.start();
        this.myCar.accelerate();
        this.myCar.stop();
        assertFalse(this.myCar.isTachometerEqualToZero());
    }

    @Test
    @DisplayName("Verify that when accelerate, current speed is greater than previous speed")
    void testCarAccelerate() {
        this.myCar.start();
        int initialSpeed = myCar.speedometer;
        myCar.accelerate();
        int newSpeed = myCar.speedometer;
        assertTrue(newSpeed > initialSpeed);
    }

    @Test
    @DisplayName("Verify that when accelerate, not exceed maximum speed")
    void testAccelerateNotExceedMaximumSpeed() {
        this.myCar.start();
        for (int i = 0; i < 26; i++) {
            myCar.accelerate();
        }
        assertEquals(this.myCar.MAX_SPEED, this.myCar.speedometer);
    }


    @Test
    @DisplayName("Verify that when brake, current speed is lower than previous speed")
    void testCarBrake() {
        myCar.start();
        myCar.accelerate();
        int initialSpeed = myCar.speedometer;
        myCar.brake();
        int newSpeed = myCar.speedometer;
        assertTrue(newSpeed < initialSpeed);
    }

    @Test
    @DisplayName("Verify that when brake, speed cannot be lower than zero")
    void testBrakeNotExceedMinimumSpeed() {
        this.myCar.start();
        myCar.accelerate();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(2, 6); i++) {
            myCar.brake();
        }
        assertEquals(0, this.myCar.speedometer);
    }

    @Test
    @DisplayName("Verify that when the angle of the wheels changes, the current angle changes accordingly")
    void testCarTurnSteeringWheel() {
        myCar.start();
        int initialAngle = myCar.wheelsAngle;
        myCar.turnAngleOfWheels(20);
        int newAngle = myCar.wheelsAngle;
        assertEquals(initialAngle + 20, newAngle);
    }

    @Test
    @DisplayName("Verify that when wheels angle change, must be between -45º and 45º")
    void testCarTurnSteeringWheelOutOfRange() {
        myCar.start();
        myCar.turnAngleOfWheels(20);
        assertEquals(20, myCar.wheelsAngle);
        myCar.turnAngleOfWheels(200);
        assertEquals(45, myCar.wheelsAngle);
        myCar.turnAngleOfWheels(-200);
        assertEquals(-45, myCar.wheelsAngle);
    }

    @Test
    @DisplayName("Verify that it is possible to shift to reverse gear when the car is stationary")
    void testCarSetReverse() {
        myCar.start();
        myCar.setReverse(true);
        assertEquals("R", myCar.gear);
    }

    @Test
    @DisplayName("Verify that it is not possible to shift to reverse gear when the car is in motion")
    void testCarSetReverseWhileInMotion() {
        myCar.start();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(1, 25); i++) {
            myCar.accelerate();
        }
        String prevGear = myCar.gear;
        myCar.setReverse(true);
        assertEquals(prevGear, myCar.gear);
    }
}
