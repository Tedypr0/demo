package org.example.test;

import org.example.Car;
import org.example.UniqueEventsQueue;
import org.example.test.utils.Helpers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetTests {
    UniqueEventsQueue<Car> queue;

    @BeforeEach
    public void initializeQueue() {
        this.queue = new UniqueEventsQueue<>();
    }

    @Test
    public void get_should_returnAnElement_fromQueue() throws InterruptedException {
        //Arrange
        Car car = Helpers.createMockCar();

        //Act
        queue.add(car);
        Car receivedCar = queue.get();

        //Assert
        Assertions.assertEquals(car, receivedCar);
    }

    @Test
    public void get_should_removeAllElements_fromQueue() throws InterruptedException {
        //Arrange
        Car car = Helpers.createMockCar();
        Car car2 = Helpers.createMockCar("car");

        //Act
        queue.add(car);
        queue.get();
        queue.add(car2);
        queue.add(car);
        queue.get();
        queue.get();
        //Assert
        Assertions.assertEquals(0, queue.size());

    }
}
