package com.karmasoft.vendingmachine.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a collection of coins with a maximum number of coins that it can hold.
 * All methods are final.  Subclasses are only allowed to facilitate storing the objects in different tables.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "box_type")
public abstract class CoinBox {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, insertable = false )
    private Long id;

    @OneToOne
    private VendingMachine vendingMachine;

    @ElementCollection (fetch = FetchType.EAGER)
    @MapKeyColumn(name="value")
    @Column(name="number")
    @CollectionTable(name="coin_stacks", joinColumns=@JoinColumn(name="coinbox_id"))
    Map<Integer, Integer> coins;

    @Transient
    Map<Integer, Integer> maxCoins = new HashMap<>();

    public CoinBox() {
        coins = new HashMap<>();
    }

    public final Long getId() {
        return id;
    }

    public final CoinBox setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @param coin Type of coin to add to the CoinBox
     * @return 1 if the coin is added, 0 if the maximum number of coins is already in the coin box.
     */
    public final Integer addCoin (Coin coin) {
        Integer existingCoins = coins.get(coin.getValue());
        Integer maxNumberOfCoins = coins.get(coin.getValue());
        if (maxNumberOfCoins != null && maxNumberOfCoins < existingCoins) {
            return 1;
        }
        if (null != existingCoins) {
            coins.put(coin.getValue(), existingCoins + 1);
        } else {
            coins.put(coin.getValue(), 1);
        }
        return 0;
    }

    /**
     *
     * @param coin The type of coin to add
     * @param incomingCoins How many coins to add
     * @return the overflow number of coins that cannot fit.
     */
    public final Integer addCoins (Coin coin, Integer incomingCoins) {
        Integer maxNumberOfCoins = maxCoins.get(coin.getValue());
        Integer existingCoins = coins.get(coin.getValue());
        Integer coinsToAdd = incomingCoins;
        int overflowCoins = 0;
        if (maxNumberOfCoins != null  && incomingCoins + existingCoins > maxNumberOfCoins) {
            coinsToAdd = maxNumberOfCoins-existingCoins;
            overflowCoins = incomingCoins - coinsToAdd;
        }
        if (null != existingCoins) {
            coins.put(coin.getValue(), existingCoins + coinsToAdd);
        } else {
            coins.put(coin.getValue(), incomingCoins);
        }
        return overflowCoins;
    }

    /**
     * Remove a coin from the CoinBox
     * @param coin what kind of coin
     * @Throws RuntimeException If there are not coins already in the CoinBox
     */
    public final void removeCoin (Coin coin) {
        Integer numberOfCoins = coins.get(coin.getValue());
        if (null != numberOfCoins && numberOfCoins > 0) {
            coins.put(coin.getValue(), numberOfCoins - 1);
        } else {
            // TODO this needs to a better exception
            throw new RuntimeException();
        }
    }

    /** Gets the value of all coins in the coin box
     * @return total value of the coinbox
     */
    public final Integer getValue() {
        return coins.keySet().stream()
                .reduce(0, (subtotal, denomination) -> subtotal + (denomination * coins.get(denomination)));
    }

    public final void empty() {
        coins.clear();
    }

    /**
     * Set a maximum number of coins of a given type for a CoinBox
     * @param coin Type of coin to set a maximum for
     * @param maxNumber Maximum number of coins of the specified type allowed
     */
    public final void setMaxCoins(Coin coin, Integer maxNumber) {
        maxCoins.put(coin.getValue(), maxNumber);
    }

    /**
     * Transfer coins between CoinBoxes with overflow
     * @param from CoinBox to transfer coins from
     * @param to CoinBox to transfer coins into
     * @param overflow CoinBox to catch the overflow if to CoinBox is limited
     */
    public final void transferCoins (CoinBox from, CoinBox to, CoinBox overflow) {
        from.coins.keySet().forEach(coinValue -> {
                int overflowAmount = to.addCoins(Coin.fromValue(coinValue), from.coins.get(coinValue));
                overflow.addCoins(Coin.fromValue(coinValue), overflowAmount);
            }
        );
    }
}
