package com.karmasoft.vendingmachine.controllers;

import com.karmasoft.vendingmachine.model.Coin;
import com.karmasoft.vendingmachine.model.Display;
import com.karmasoft.vendingmachine.model.VendingMachine;
import com.karmasoft.vendingmachine.model.dto.CoinDepositDTO;
import com.karmasoft.vendingmachine.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinDepositController {
    private final VendingMachine vendingMachine;
    private final MachineRepository machineRepository;

    @Autowired
    public CoinDepositController(VendingMachine vendingMachine, MachineRepository machineRepository) {
        this.vendingMachine = vendingMachine;
        this.machineRepository = machineRepository;
    }

    @PostMapping("/coinDeposit")
    public ResponseEntity<Display> coinDeposit(@RequestBody CoinDepositDTO coinDepositDTO){
        Coin coinType = Coin.fromText(coinDepositDTO.getCoinName());
        if (null == coinType) {
            vendingMachine.getDisplay().setMessage("Coin Rejected");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vendingMachine.getDisplay());
        }

        vendingMachine.insertCoin(coinType);
        machineRepository.save(vendingMachine);
        return ResponseEntity.status(HttpStatus.OK).body(vendingMachine.getDisplay());
    }
}
