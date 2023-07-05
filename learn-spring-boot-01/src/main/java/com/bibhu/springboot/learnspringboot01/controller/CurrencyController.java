package com.bibhu.springboot.learnspringboot01.controller;

import com.bibhu.springboot.learnspringboot01.service.CurrencyServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    @Autowired
    private CurrencyServiceConfiguration currencyServiceConfiguration;

    @GetMapping("/currencyDetails")
    public CurrencyServiceConfiguration fetchCurrencyDetails() {
        return this.currencyServiceConfiguration;
    }
}
