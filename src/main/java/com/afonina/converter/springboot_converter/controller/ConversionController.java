package com.afonina.converter.springboot_converter.controller;

import com.afonina.converter.springboot_converter.entity.CurrencyConversion;
import com.afonina.converter.springboot_converter.service.api.CurrencyConversionDAOService;
import com.afonina.converter.springboot_converter.service.api.CurrencyRateDAOService;
import com.afonina.converter.springboot_converter.service.impl.conversion.ConvertingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ConversionController {

    @Autowired
    private CurrencyRateDAOService currencyRateDAOService;
    @Autowired
    private ConvertingService convertingService;
    @Autowired
    private CurrencyConversionDAOService currencyConversionDAOService;

    //в полях ввода на фронте будут charCode-ы
    @GetMapping(value = "/converter")
    public String getConversionResult(
            @RequestParam(value = "sourceCurrencyCode") String sourceCurrencyCode,
            @RequestParam(value = "targetCurrencyCode") String targetCurrencyCode,
            @RequestParam(value = "coefficient") String coefficient) {

        String result = convertingService.convert(sourceCurrencyCode, targetCurrencyCode, coefficient);
        return result;
    }

    @GetMapping(value = "/history")
    public List<CurrencyConversion> getConversionsHistory() {
        List<CurrencyConversion> allCurrencyConversions = currencyConversionDAOService.findAllCurrencyConversions();
        return allCurrencyConversions;
    }

    @GetMapping(value = "/history/{date}")
    public List<CurrencyConversion> getConversionsByDate(@PathVariable String date) {
        List<CurrencyConversion> allCurrencyConversions = currencyConversionDAOService.findAllByDate(date);
        return allCurrencyConversions;
    }
}
