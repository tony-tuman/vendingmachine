package com.karmasoft.vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

public class CoinBox {
    Map<Coin, Integer> coins;
    Map<Coin, Integer> maxCoins;

    public CoinBox() {
        coins = new HashMap<>();
    }

    /**
     *
     * @param coin Type of coin to add to the CoinBox
     * @return 1 if the maximum number of coins is already in the coin box.
     */
    public Integer addCoin (Coin coin) {
        Integer existingCoins = coins.get(coin);
        Integer maxNumberOfCoins = coins.get(coin);
        if (maxNumberOfCoins != null && maxNumberOfCoins < existingCoins) {
            return 1;
        }
        if (null == existingCoins) {
            coins.put(coin, existingCoins + 1);
        } else {
            coins.put(coin, 1);
        }
        return 0;
    }

    /**
     *
     * @param coin The type of coin to add
     * @param incomingCoins How many coins to add
     * @return the overflow number of coins that cannot fit.
     */
    public Integer addCoins (Coin coin, Integer incomingCoins) {
        Integer maxNumberOfCoins = maxCoins.get(coin);
        Integer existingCoins = coins.get(coin);
        Integer coinsToAdd = incomingCoins;
        int overflowCoins = 0;
        if (maxNumberOfCoins != null  && incomingCoins + existingCoins > maxNumberOfCoins) {
            coinsToAdd = maxNumberOfCoins-existingCoins;
            overflowCoins = incomingCoins - coinsToAdd;
        }
        if (null == existingCoins) {
            coins.put(coin, existingCoins + coinsToAdd);
        } else {
            coins.put(coin, incomingCoins);
        }
        return overflowCoins;
    }

    /**
     * Remove a coin from the CoinBox
     * @param coin what kind of coin
     * @Throws RuntimeException If there are not coins already in the CoinBox
     */
    public void removeCoin (Coin coin) {
        Integer numberOfCoins = coins.get(coin);
        if (null != numberOfCoins || numberOfCoins > 0) {
            coins.put(coin, numberOfCoins - 1);
        } else {
            // TODO this needs to a better exception
            throw new RuntimeException();
        }
    }

    // TODO This might be refactored to use streams and a BiConsumer
    // However the code is actually more readable this way.
    public Integer getValue() {
        int total = 0;
        for (Coin coin : coins.keySet()) {
            total += coins.get(coin)*coin.getValue();
        }
        return total;
    }

    public void empty() {
        coins.clear();
    }

    /**
     * Set a maximum number of coins of a given type for a CoinBox
     * @param coin Type of coin to set a maximum for
     * @param maxNumber Maximum number of coins of the specified type allowed
     */
    public void setMaxCoins(Coin coin, Integer maxNumber) {
        maxCoins.put(coin, maxNumber);
    }

    /**
     * Transfer coins between CoinBoxes with overflow
     * @param from CoinBox to transfer coins from
     * @param to CoinBox to transfer coins into
     * @param overflow CoinBox to catch the overflow if to CoinBox is limited
     */
    public void transferCoins (CoinBox from, CoinBox to, CoinBox overflow) {
        from.coins.keySet().forEach(coin -> {
                int overflowAmount = to.addCoins(coin, from.coins.get(coin));
                overflow.addCoins(coin, overflowAmount);
            }
        );
    }
}
