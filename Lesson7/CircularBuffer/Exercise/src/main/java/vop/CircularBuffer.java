package vop;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CircularBuffer {

    private Integer[] buffer;
    private int size;
    int putIndex = 0;
    int getIndex = 0;
    private Lock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();

    public CircularBuffer(int size) {
        buffer = new Integer[size];
        this.size = size;
    }

    void get() {
        lock.lock();
        try {
            while (getIndex == 0) {
                empty.await();
            }
            System.out.println(getIndex);
            getIndex = 0;
            empty.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    void put(int n) {
        lock.lock();
        try {
            while (getIndex != 0) {
                empty.await();
            }
            System.out.println(++putIndex);
            getIndex = putIndex;
            empty.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }


    public String toString() {
        return "Buff: " + Arrays.toString(buffer);
    }
}

