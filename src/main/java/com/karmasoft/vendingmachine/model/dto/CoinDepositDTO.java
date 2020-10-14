package com.karmasoft.vendingmachine.model.dto;

import com.karmasoft.vendingmachine.model.Coin;

public class CoinDepositDTO {
    String coinName;

    public String getCoinName() {
        return coinName;
    }

    public CoinDepositDTO setCoinName(String coinName) {
        this.coinName = coinName;
        return this;
    }
}
