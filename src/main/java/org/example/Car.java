package org.example;

public class Car {
    public String carName;

    public Car() {}

    public Car(String carName) {
        this.carName = carName.toUpperCase();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime + ((carName == null) ? 0 : carName.hashCode());

    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Car)) {
            return false;
        }

        Car car = (Car) o;
        return (car.carName.equals(this.carName));
    }
}
