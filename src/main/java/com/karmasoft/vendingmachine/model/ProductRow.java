package com.karmasoft.vendingmachine.model;

import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.IntStream;

public class ProductRow {
    String buttonCombo;
    Integer price;
    LinkedList<Product> products;

    public ProductRow(String buttonCombo, Integer price) {
        this.buttonCombo = buttonCombo;
        this.price = price;
        products = new LinkedList<>();
    }

    public Integer getPrice() {
        return price;
    }

    public ProductRow setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getButtonCombo() {
        return buttonCombo;
    }

    public ProductRow setButtonCombo(String buttonCombo) {
        this.buttonCombo = buttonCombo;
        return this;
    }

    public Optional<Product> getFrontProduct() {
        return products.isEmpty() ? Optional.empty() : Optional.of(products.getFirst());
    }

    public void fillProduct(Product product, Integer number) {
        IntStream.range(0, number).forEach(i -> products.add(product));
    }

    public void vendProduct() {
        products.removeFirst();
    }
}
