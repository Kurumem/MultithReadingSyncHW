package com.company;

import java.math.BigDecimal;

public class ThreadA extends Thread {
    Accounts accounts;

    ThreadA(Accounts accounts) {
        this.accounts = accounts;
    }

    public void run() {
        for (int i = 0; i < 100000; ++i) {
            accounts.transferAB(new BigDecimal(10));
            System.out.println(accounts);
        }
    }
}
