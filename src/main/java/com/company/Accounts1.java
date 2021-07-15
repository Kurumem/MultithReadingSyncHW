package com.company;

import java.math.BigDecimal;

public class Accounts1 implements Accounts {
    private BigDecimal accountA;
    private BigDecimal accountB;

    Accounts1() {
        accountA = new BigDecimal(500000);
        accountB = new BigDecimal(100000);
    }

    public synchronized void transferAB(BigDecimal sum) {
        accountA = accountA.subtract(sum);
        accountB = accountB.add(sum);
    }

    public synchronized void transferBA(BigDecimal sum) {
        accountB = accountB.subtract(sum);
        accountA = accountA.add(sum);
    }

    public synchronized String toString() {
        return "Остаток A = " + accountA + ", Остаток B = " + accountB + ", Общий остаток = " + accountA.add(accountB);
    }
}
