package org.example.test;

import org.example.Car;
import org.example.UniqueEventsQueue;
import org.example.test.utils.Helpers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTests {

    UniqueEventsQueue<Car> queue;

    @BeforeEach
    public void initializeQueue() {
        this.queue = new UniqueEventsQueue<>();
    }

    @Test
    public void add_should_addAnElement_toQueue() {
        //Arrange
        Car car = Helpers.createMockCar();

        //Act
        queue.add(car);

        //Assert

        Assertions.assertEquals(1, queue.size());
    }

    @Test
    public void add_shouldDo_nothing_whenObject_alreadyExists() {
        //Arrange
        Car car = Helpers.createMockCar();
        //Act
        queue.add(car);
        queue.add(car);

        //Assert
        Assertions.assertEquals(1, queue.size());
    }


}
