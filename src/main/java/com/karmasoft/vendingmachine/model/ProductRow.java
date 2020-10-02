package com.karmasoft.vendingmachine.model;

import java.util.ArrayList;

public class ProductRow {
    String ButtonCombo;
    Integer price;
    ArrayList<Product> products;

    public ProductRow (String buttonCombo, Integer price) {
        this.ButtonCombo = buttonCombo;
        this.price=price;
        products = new ArrayList<>();
    }

    public Integer getPrice() {
        return price;
    }

    public ProductRow setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getButtonCombo() {
        return ButtonCombo;
    }

    public ProductRow setButtonCombo(String buttonCombo) {
        ButtonCombo = buttonCombo;
        return this;
    }

    public Product getFrontProduct() {
        return products.get(0);
    }

    public void fillProduct(Product product, Integer number) {
        for (int i = 0; i<number; i++) {
            products.add(product);
        }
    }

    public void vendProduct() {
        products.remove(0);
    }
}
