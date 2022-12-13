package org.example;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class UniqueEventsQueue<T> {
    private final Map<T, T> hashMap;
    private final Queue<T> queue;
    private int size;

    public UniqueEventsQueue() {
        hashMap = new HashMap<>();
        queue = new LinkedBlockingQueue<>();
    }

    public synchronized void add(T element) {
        if (hashMap.containsKey(element)) {
            return;
        }
        hashMap.put(element, element);
        queue.add(element);
        size++;
        notify();
    }

    public synchronized T get() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T elementToRemove = queue.poll();
        hashMap.remove(elementToRemove);
        size--;
        return elementToRemove;
    }

    public int size(){
        return size;
    }

    public void print(Car car, String thread) {
        if (thread.contains("consumer")) {
            System.out.printf("%s thread has removed a car with name: %s\n",thread, car.carName);
            return;
        }
        System.out.printf("%s thread has added a car with name %s\n",thread, car.carName);
    }

}


