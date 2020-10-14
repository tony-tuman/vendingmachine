package com.karmasoft.vendingmachine.model;

import java.util.ArrayList;

public class ProductWindow {
    ArrayList<ProductRow> rows = new ArrayList<>();

    public int getNumberOfRows() {
        return rows.size();
    }
}
