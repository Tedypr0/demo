package org.example.test;

import org.example.Car;
import org.example.UniqueEventsQueue;
import org.example.test.utils.Helpers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UniqueEventsQueueTests {
    UniqueEventsQueue<Car> queue;

    @BeforeEach
    public void initializeQueue(){
        this.queue = new UniqueEventsQueue<>();
    }

    @Test
    public void checkIf_queueWorks_withFIFO_method() throws InterruptedException{
        //Arrange
        Car car = Helpers.createMockCar("1");
        Car car2 = Helpers.createMockCar("2");

        //Act
        queue.add(car);
        queue.add(car2);
        queue.get();

        //Assert
        Assertions.assertEquals(queue.get(), car2);
    }
}
