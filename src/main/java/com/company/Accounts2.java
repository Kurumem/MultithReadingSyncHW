package com.company;

import java.math.BigDecimal;

public class Accounts2 implements Accounts {
    private BigDecimal accountA;
    private BigDecimal accountB;
    private Object obj = new Object();

    Accounts2() {
        accountA = new BigDecimal(500000);
        accountB = new BigDecimal(100000);
    }

    public void transferAB(BigDecimal sum) {
        synchronized (obj) {
            accountA = accountA.subtract(sum);
            accountB = accountB.add(sum);
        }
    }

    public void transferBA(BigDecimal sum) {
        synchronized (obj) {
            accountB = accountB.subtract(sum);
            accountA = accountA.add(sum);
        }
    }

    public String toString() {
        return "Остаток A = " + accountA + ", Остаток B = " + accountB + ", Общий остаток = " + accountA.add(accountB);
    }
}

