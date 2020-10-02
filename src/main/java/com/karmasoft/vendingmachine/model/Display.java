package com.karmasoft.vendingmachine.model;

public class Display {
    String text;
    Boolean exactChange;

    public Display() {
        resetDisplay();
    }

    private void resetDisplay() {
        text="0.00";
        exactChange = false;
    }

    public String getText() {
        return text;
    }

    public Display setText(String text) {
        this.text = text;
        return this;
    }

    public Boolean getExactChange() {
        return exactChange;
    }

    public Display setExactChange(Boolean exactChange) {
        this.exactChange = exactChange;
        return this;
    }
}
