package com.karmasoft.vendingmachine.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name ="CashBox")
@DiscriminatorValue("CashBox")
public class CashBox extends CoinBox {
}
