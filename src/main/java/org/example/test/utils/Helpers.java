package org.example.test.utils;

import org.example.Car;

public class Helpers<T extends Car> {
    public static Car createMockCar(){
        return new Car("mockCar");
    }
    public static Car createMockCar(String carName){return new Car(carName);}

}
