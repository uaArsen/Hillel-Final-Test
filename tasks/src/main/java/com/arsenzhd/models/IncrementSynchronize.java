package com.arsenzhd.models;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ArsZhd on 08.04.17.
 * Class for "synchronize" task. Contains method to synchronized increment value.
 */
public class IncrementSynchronize {
    /**
     * @param value value. Bonus can be changed to AtomicInteger that already has thread safe incrementAndGet method.
     */
    private int value = 0;

    /**
     * @param lock object lock for synchronization.
     */
    private final Object lock = new Object();

    /**
     * @param rLock reentrant lock for synchronization.
     */
    private final ReentrantLock rLock = new ReentrantLock();

    /**
     * First example of getNextValue method.
     */
    public synchronized void firstExample() {
        this.value++;
    }

    /**
     * Second example of getNextValue method.
     */
    public void secondExample() {
        synchronized (this.lock) {
            this.value++;
        }
    }

    /**
     * Third example of getNextValue method.
     */
    public void thirdExample() {
        rLock.lock();
        try {
            this.value++;
        } finally {
            rLock.unlock();
        }
    }

    /**
     * @return property value.
     */
    public int getValue() {
        return value;
    }
}
