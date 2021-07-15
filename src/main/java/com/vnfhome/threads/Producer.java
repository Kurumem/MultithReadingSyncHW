package com.vnfhome.threads;

public class Producer extends Thread {
    Store store;

    Producer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            while (true) {
                store.toStore();
                sleep(700);
            }
        } catch (Exception e) {
        }
    }
}
