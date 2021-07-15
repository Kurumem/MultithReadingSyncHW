package com.company;

import java.math.BigDecimal;

public interface Accounts {
    void transferAB(BigDecimal sum);
    void transferBA(BigDecimal sum);
}
