package com.karmasoft.vendingmachine.model;

import java.util.Arrays;

public enum Coin {
    NICKEL(5, "nickel"),
    DIME(10, "dime"),
    PENNY(1, "penny"),
    QUARTER(25, "quarter"),
    HALF(50, "half"),
    DOLLAR(100, "dollar");

    private final int value;
    private final String text;

    Coin(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static Coin fromText (String coinName) {
        return Arrays.stream(values())
                .filter(c ->c.text.equalsIgnoreCase(coinName))
                .findFirst()
                .orElse(null);
    }

    public static Coin fromValue (Integer coinValue) {
        return Arrays.stream(values())
                .filter(c ->c.value == coinValue)
                .findFirst()
                .orElse(null);
    }
}
