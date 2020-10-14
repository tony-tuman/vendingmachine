package com.karmasoft.vendingmachine.repository;

import com.karmasoft.vendingmachine.model.VendingMachine;
import org.springframework.data.repository.CrudRepository;

public interface MachineRepository extends CrudRepository <VendingMachine, Long> {
}
