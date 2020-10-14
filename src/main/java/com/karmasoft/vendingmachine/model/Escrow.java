package com.karmasoft.vendingmachine.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name ="Escrow")
@DiscriminatorValue("Escrow")
public class Escrow extends CoinBox {
}
