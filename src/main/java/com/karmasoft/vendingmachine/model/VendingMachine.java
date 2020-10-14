package com.karmasoft.vendingmachine.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "machines")
public class VendingMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long headerNumber;

    @Transient
    private final Display display=new Display();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CashBox cashBox;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Escrow escrow;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AvailableChange availableChange;

    @Transient
    private final ProductWindow productWindow=new ProductWindow();

    @Autowired
    public VendingMachine() {
    }

    public Long getMachineId() {
        return id;
    }

    public VendingMachine setMachineId(Long machineId) {
        this.id = machineId;
        return this;
    }

    public Display getDisplay() {
        return display;
    }

    public CashBox getCashBox() {
        return cashBox;
    }

    public ProductWindow getProductWindow() {
        return productWindow;
    }

    public void insertCoin (Coin coin) {
        escrow.addCoin(coin);
        getDisplay().setAmount(escrow.getValue());
    }

    public CoinBox getChangeMax() {
        return null;
    }

    public CoinBox getAvailableChange() {
        return availableChange;
    }

    public CoinBox getEscrow() {
        return escrow;
    }
}
