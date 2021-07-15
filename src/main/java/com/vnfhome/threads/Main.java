package com.vnfhome.threads;

public class Main {

    public static void main(String[] args) {
        Store s = new Store();
        Thread p1 = new Producer(s);
        Thread p2 = new Producer(s);
        Thread p3 = new Producer(s);
        Thread c1 = new Consumer(s);
        Thread c2 = new Consumer(s);
        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
    }
}
