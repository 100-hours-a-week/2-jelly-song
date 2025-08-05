package week2.practice;

import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private AtomicInteger value = new AtomicInteger(0);

    public synchronized void increment() {
        value.incrementAndGet();
    }

    public int getValue() {
        return value.get();
    }
}
