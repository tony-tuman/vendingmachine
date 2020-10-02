package com.karmasoft.vendingmachine.model;

public class VendingMachine {
    Long machineId;
    Display display;
    CoinBox cashBox;
    Changer changer;
    ProductWindow productWindow;

    public VendingMachine() {
    }

    public Long getMachineId() {
        return machineId;
    }

    public VendingMachine setMachineId(Long machineId) {
        this.machineId = machineId;
        return this;
    }

    public Display getDisplay() {
        return display;
    }

    public VendingMachine setDisplay(Display display) {
        this.display = display;
        return this;
    }

    public CoinBox getCashBox() {
        return cashBox;
    }

    public VendingMachine setCashBox(CoinBox cashBox) {
        this.cashBox = cashBox;
        return this;
    }

    public Changer getChanger() {
        return changer;
    }

    public VendingMachine setChanger(Changer changer) {
        this.changer = changer;
        return this;
    }

    public ProductWindow getProductWindow() {
        return productWindow;
    }

    public VendingMachine setProductWindow(ProductWindow productWindow) {
        this.productWindow = productWindow;
        return this;
    }
}
