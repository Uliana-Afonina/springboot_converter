package com.afonina.converter.springboot_converter.controller;

import com.afonina.converter.springboot_converter.service.api.CurrencyRateDAOService;
import com.afonina.converter.springboot_converter.entity.*;
import com.afonina.converter.springboot_converter.service.impl.ConvertingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ConvertionController {

    @Autowired
    private CurrencyRateDAOService currencyRateDAOService;
    @Autowired
    private ConvertingService convertingService;

    @GetMapping("/currencyRates")
    public List<CurrencyRate> getAllCurrencyRates() {
        List<CurrencyRate> allCurrencyRates = currencyRateDAOService.getAllCurrencyRates();
        return allCurrencyRates;
    }

    @PostMapping("/currencyRates")
    public List<CurrencyRate> saveAllCurrencyRates(@RequestBody List<CurrencyRate> currencyRates) {
        currencyRateDAOService.saveAllCurrencyRates(currencyRates);
        return currencyRates;
    }

    @GetMapping("/currencyRates/{charCode}")
    public CurrencyRate getCurrencyRates(@PathVariable String charCode) {
        CurrencyRate currencyRate = currencyRateDAOService.getCurrencyRateByCharCode(charCode);
        return currencyRate;
    }

    //в полях ввода на фронте будут charCode-ы
    @GetMapping(value = "/converter")
    public String getConversionResult(
            @RequestParam(value = "sourceCurrencyCode") String sourceCurrencyCode,
            @RequestParam(value = "targetCurrencyCode") String targetCurrencyCode,
            @RequestParam(value = "coefficient") String coefficient
            ) {

        String result = convertingService.convert(sourceCurrencyCode, targetCurrencyCode, coefficient);
        return result;
    }
//    @GetMapping()
//    public List<Currency> getAllCurrencies() {
//        return "index";
//    }
}
