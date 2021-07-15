package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        //methods();
        //blocks();
        //locks();
        locksWithTimeout();
    }

    private static void methods() {
        Accounts accounts = new Accounts1();
        ThreadA threadA = new ThreadA(accounts);
        ThreadB threadB = new ThreadB(accounts);
        threadA.start();
        threadB.start();
        System.out.println("Main end");
    }

    private static void blocks() {
        Accounts accounts = new Accounts2();
        ThreadA threadA = new ThreadA(accounts);
        ThreadB threadB = new ThreadB(accounts);
        threadA.start();
        threadB.start();
        System.out.println("Main end");
    }

    private static void locks() {
        Accounts accounts = new Accounts3();
        ThreadA threadA = new ThreadA(accounts);
        ThreadB threadB = new ThreadB(accounts);
        threadA.start();
        threadB.start();
        System.out.println("Main end");
    }

    private static void locksWithTimeout() {
        ReentrantLock lock = new ReentrantLock();
        Thread w1 = new Worker1(lock);
        Thread w2 = new Worker2(lock);
        w1.start();
        w2.start();
        System.out.println("Main end");
    }

}
