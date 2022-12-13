package org.example;

public class Main {
    public static void main(String[] args){
        Car[] cars = {new Car("1"), new Car("2"), new Car("3"), new Car("4"),
                new Car("5"), new Car("6"), new Car("7"), new Car("8"), new Car("POISON")};
        Car[] cars2 = {new Car("21"), new Car("22"), new Car("23"), new Car("24")
                , new Car("25"), new Car("26"), new Car("27"), new Car("28"),};
        Car[] cars3 = {new Car("31")};
        UniqueEventsQueue<Car> queue = new UniqueEventsQueue<>();
        Producer<Car> producer1 = new Producer<>(queue, cars);
        Consumer<Car> consumer1 = new Consumer<>(queue);
        // Producer producer2 = new Producer(queue, cars2);
        Consumer<Car> consumer2 = new Consumer<>(queue);
        // producer2.setName("Producer2");
        producer1.setName("Producer");
        consumer1.setName("Consumer");
        consumer1.start();
        consumer2.start();


        producer1.start();



    }
}

