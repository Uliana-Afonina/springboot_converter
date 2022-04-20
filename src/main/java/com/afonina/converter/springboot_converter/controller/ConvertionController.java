package com.afonina.converter.springboot_converter.controller;

import com.afonina.converter.springboot_converter.service.api.CurrencyRateService;
import com.afonina.converter.springboot_converter.entity.*;
import com.afonina.converter.springboot_converter.service.impl.ConvertionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ConvertionController {

    @Autowired
    private CurrencyRateService currencyRateService;
    @Autowired
    private ConvertionService convertionService;

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

    //в полях ввода на фронте будут charCode-ы
//    @GetMapping("/currencyRates")
//    public String getConversionResult(@RequestBody String sourceCurrencyCode, String targetCurrencyCode, String coefficient) {
//        String result = convertionService.convert(sourceCurrencyCode, targetCurrencyCode, coefficient);
//        return result;
//    }
//    @GetMapping()
//    public List<Currency> getAllCurrencies() {
//        return "index";
//    }
}
