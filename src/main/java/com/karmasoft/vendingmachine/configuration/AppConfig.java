package com.karmasoft.vendingmachine.configuration;

import com.karmasoft.vendingmachine.model.*;
import com.karmasoft.vendingmachine.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Autowired
    private MachineRepository machineRepository;

    @Bean("VendingMachine")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public VendingMachine getVendingMachine() {
        return machineRepository.findById(1L).orElseThrow();
    }

    @Bean("display")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Display getDisplay() {
        return new Display();
    }

    @Bean("productWindow")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ProductWindow getProductWindow() {
        return new ProductWindow();
    }
}
