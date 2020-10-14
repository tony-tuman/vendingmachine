package com.karmasoft.vendingmachine.model;

public class Display {
    String message = "";
    Integer amount = 0;
    Boolean exactChange;

    public Display() {
        resetDisplay();
    }

    private void resetDisplay() {
        message = "";
        amount = 0;
        exactChange = false;
    }

    public String getMessage() {
        return message;
    }


    public Display setMessage(String message) {
        this.message = message;
        return this;
    }

    public Boolean getExactChange() {
        return exactChange;
    }

    public Display setExactChange(Boolean exactChange) {
        this.exactChange = exactChange;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public Display setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }
}
