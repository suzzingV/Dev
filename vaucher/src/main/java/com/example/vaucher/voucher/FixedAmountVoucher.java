package com.example.vaucher.voucher;

public class FixedAmountVoucher implements Voucher {

    private long amount;
    @Override
    public long discount(long beforeDiscount) {
        return beforeDiscount - amount;
    }
}
