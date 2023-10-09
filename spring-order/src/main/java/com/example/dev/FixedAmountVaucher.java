package com.example.dev;

public class FixedAmountVaucher {
    private final long amount;

    public FixedAmountVaucher(long amount) {
        this.amount = amount;
    }

    public long discount(long beforeDiscount) {
        return beforeDiscount - amount;
    }
}
