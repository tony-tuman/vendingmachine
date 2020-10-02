package com.karmasoft.vendingmachine.model;

import org.springframework.data.util.Pair;

public class Changer {
    CoinBox escrow;
    CoinBox change;
    CoinBox changeMax;

    @SafeVarargs
    public Changer (Pair<Coin, Integer>... maxCoinPairs) {
        escrow = new CoinBox();
        change = new CoinBox();
        for (Pair<Coin, Integer> coinMax : maxCoinPairs) {
            change.setMaxCoins(coinMax.getFirst(), coinMax.getSecond());
        }
        changeMax =  new CoinBox();
    }

    public CoinBox getEscrow() {
        return escrow;
    }

    public Changer setEscrow(CoinBox escrow) {
        this.escrow = escrow;
        return this;
    }

    public CoinBox getChange() {
        return change;
    }

    public Changer setChange(CoinBox change) {
        this.change = change;
        return this;
    }

    public CoinBox getChangeMax() {
        return changeMax;
    }

    public Changer setChangeMax(CoinBox changeMax) {
        this.changeMax = changeMax;
        return this;
    }
}
