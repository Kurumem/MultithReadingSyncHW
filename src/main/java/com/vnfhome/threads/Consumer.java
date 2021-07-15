package com.vnfhome.threads;

public class Consumer extends Thread {
    Store store;

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            while (true) {
                store.fromStore();
                sleep(500);
            }
        } catch (Exception e) {
        }
    }
}
