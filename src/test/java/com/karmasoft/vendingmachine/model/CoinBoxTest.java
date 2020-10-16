package com.karmasoft.vendingmachine.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoinBoxTest {
    private CashBox cashbox;

    private int COIN_MAX = 1000;
    private int QUARTER_START = 4;
    private int DIME_START = 4;
    private int NICKEL_START = 2;

    @BeforeEach
    public void setup() {
        cashbox = new CashBox();
        cashbox.addCoins(Coin.QUARTER, QUARTER_START);
        cashbox.addCoins(Coin.DIME, DIME_START);
        cashbox.addCoins(Coin.NICKEL, NICKEL_START);

        cashbox.setMaxCoins(Coin.QUARTER, COIN_MAX);
        cashbox.setMaxCoins(Coin.DIME, COIN_MAX);
        cashbox.setMaxCoins(Coin.NICKEL, COIN_MAX);
    }

    @Test
    public void getValueReturns150() {
        Assertions.assertEquals(150, cashbox.getValue());
    }

    @Test
    public void addCoinOverMaxReturnsNumberOfOverflowCoins() {
        Assertions.assertEquals(2000 - COIN_MAX + QUARTER_START, cashbox.addCoins(Coin.QUARTER, 2000));
    }
}