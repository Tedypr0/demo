package org.example;

public class Producer<T> extends Thread {
    private final T[] elements;
    private final UniqueEventsQueue<T> queue;

    public Producer(UniqueEventsQueue<T> queue, T[] elements) {
        this.queue = queue;
        this.elements = elements;
    }

    @Override
    public void run() {
        for (T element : elements) {
            try {
                produce(element);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void produce(T element) throws InterruptedException {
        synchronized (queue) {
            queue.add(element);
            queue.print((Car) element, this.getName());
        }
    }
}
