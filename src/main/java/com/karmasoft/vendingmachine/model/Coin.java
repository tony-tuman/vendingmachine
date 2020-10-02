package com.karmasoft.vendingmachine.model;

public enum Coin {
    NICKEL(5), DIME(10), PENNY(1), QUARTER(25), HALF(50), DOLLAR(100);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
