package org.example;

public class Consumer<T> extends Thread {
    final UniqueEventsQueue<T> queue;
    public Consumer(UniqueEventsQueue<T> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    private void consume() throws InterruptedException {
        synchronized (queue) {
            T element = queue.get();
            queue.print((Car) element, this.getName());
        }
    }
}
