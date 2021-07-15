package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Worker2 extends Thread {
    ReentrantLock lock;

    Worker2(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30000; ++i) {
            boolean locked = false;
            try {
                locked = lock.tryLock(2, TimeUnit.SECONDS);
                if (locked)
                    System.out.println("2 копает " + i);
                else {
                    System.out.println("2 не дождался");
                    ++i;
                }
            } catch (InterruptedException e) {

            } finally {
                if (locked)
                    lock.unlock();
            }
        }
    }
}
