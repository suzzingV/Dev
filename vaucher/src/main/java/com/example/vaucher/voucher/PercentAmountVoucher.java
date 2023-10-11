package com.example.vaucher.voucher;

public class PercentAmountVoucher implements Voucher{
    private long percent;
    @Override
    public long discount(long beforeDiscount) {
        return beforeDiscount - beforeDiscount * percent / 100;
    }
}
