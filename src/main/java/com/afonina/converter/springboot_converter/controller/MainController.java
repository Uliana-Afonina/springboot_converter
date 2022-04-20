package com.afonina.converter.springboot_converter.controller;

import com.afonina.converter.springboot_converter.service.api.CurrencyRateService;
import com.afonina.converter.springboot_converter.entity.*;
import com.afonina.converter.springboot_converter.service.impl.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private CurrencyRateService currencyRateService;
    @Autowired
    private ConvertService convertService;

    @GetMapping("/currencyRates")
    public List<CurrencyRate> getAllCurrencyRates() {
        List<CurrencyRate> allCurrencyRates = currencyRateService.getAllCurrencyRates();
        return allCurrencyRates;
    }

    @PostMapping("/currencyRates")
    public List<CurrencyRate> saveAllCurrencyRates(@RequestBody List<CurrencyRate> currencyRates) {
        currencyRateService.saveAllCurrencyRates(currencyRates);
        return currencyRates;
    }

    @GetMapping("/currencyRates/{charCode}")
    public CurrencyRate getCurrencyRates(@PathVariable String charCode) {
        CurrencyRate currencyRate = currencyRateService.getCurrencyRateByCharCode(charCode);
        return currencyRate;
    }

    @GetMapping("/currencyRates")
    public String getConversionResult(@RequestBody CurrencyRate sourceCurrency, CurrencyRate targetCurrency, String coefficient) {
        String result = convertService.convert(sourceCurrency, targetCurrency, coefficient);
        return result;
    }
//    @GetMapping()
//    public List<Currency> getAllCurrencies() {
//        return "index";
//    }
}
