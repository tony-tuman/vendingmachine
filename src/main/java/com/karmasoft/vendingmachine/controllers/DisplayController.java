package com.karmasoft.vendingmachine.controllers;

import com.karmasoft.vendingmachine.model.CashBox;
import com.karmasoft.vendingmachine.model.VendingMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisplayController {

    private final VendingMachine vendingMachine;

    @Autowired
    public DisplayController(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @GetMapping("/display")
    public VendingMachine display(){
        StringBuilder sb  = new StringBuilder();
        sb.append ("ID = ");
        sb.append (vendingMachine.getMachineId());
        sb.append ("\n");

        sb.append ("Display = ");
        sb.append (vendingMachine.getDisplay().getMessage());
        sb.append ("\n");

        sb.append ("Cashbox = ");
        CashBox tempCashBox = vendingMachine.getCashBox();
        sb.append (tempCashBox.getValue());
        sb.append ("\n");

        sb.append ("Changer Maximum = ");
        sb.append (vendingMachine.getChangeMax());
        sb.append ("\n");

        sb.append ("Changer Change = ");
        sb.append (vendingMachine.getAvailableChange().getValue());
        sb.append ("\n");

        sb.append ("Escrow = ");
        sb.append (vendingMachine.getEscrow().getValue());
        sb.append ("\n");

        sb.append ("Products = ");
        sb.append (vendingMachine.getProductWindow().getNumberOfRows());
        sb.append ("\n");
        System.out.println(sb.toString());
        return vendingMachine;
    }
}
