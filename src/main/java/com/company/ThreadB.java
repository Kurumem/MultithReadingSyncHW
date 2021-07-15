package com.company;

import java.math.BigDecimal;

public class ThreadB extends Thread {
    Accounts accounts;

    ThreadB(Accounts accounts) {
        this.accounts = accounts;
    }

    public void run() {
        for (int i = 0; i < 100000; ++i) {
            accounts.transferBA(new BigDecimal(5));
            System.out.println(accounts);
        }
    }
}
