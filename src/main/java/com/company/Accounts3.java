package com.company;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

public class Accounts3 implements Accounts {
    private BigDecimal accountA;
    private BigDecimal accountB;
    private ReentrantLock lock = new ReentrantLock();

    Accounts3() {
        accountA = new BigDecimal(500000);
        accountB = new BigDecimal(100000);
    }

    public void transferAB(BigDecimal sum) {
        lock.lock();
        accountA = accountA.subtract(sum);
        accountB = accountB.add(sum);
        lock.unlock();
    }

    public void transferBA(BigDecimal sum) {
        lock.lock();
        accountB = accountB.subtract(sum);
        accountA = accountA.add(sum);
        lock.unlock();
    }

    public String toString() {
        return "Остаток A = " + accountA + ", Остаток B = " + accountB + ", Общий остаток = " + accountA.add(accountB);
    }
}
