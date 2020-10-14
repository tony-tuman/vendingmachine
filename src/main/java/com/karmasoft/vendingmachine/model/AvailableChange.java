package com.karmasoft.vendingmachine.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name ="AvailableChange")
@DiscriminatorValue("AvailableChange")
public class AvailableChange extends CoinBox {
}