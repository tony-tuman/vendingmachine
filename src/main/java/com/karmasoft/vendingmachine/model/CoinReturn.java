package com.karmasoft.vendingmachine.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name ="CoinReturn")
@DiscriminatorValue("CoinReturn")
public class CoinReturn extends CoinBox {
}
