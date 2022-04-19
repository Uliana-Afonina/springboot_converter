package com.afonina.converter.springboot_converter.controller;

import com.afonina.converter.springboot_converter.service.api.CurrencyRateService;
import com.afonina.converter.springboot_converter.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private CurrencyRateService currencyRateService;

    @GetMapping("/currencyRates")
    public List<CurrencyRate> getAllCurrencyRates() {
        List<CurrencyRate> allCurrencyRates = currencyRateService.getAllCurrencies();
        return allCurrencyRates;
    }

    @PostMapping("/currencyRates")
    public List<CurrencyRate> saveAllCurrencyRates(@RequestBody List<CurrencyRate> currencyRates) {
        currencyRateService.saveAllCurrency(currencyRates);
        return currencyRates;
    }
//    @GetMapping()
//    public List<Currency> getAllCurrencies() {
//        return "index";
//    }
}
