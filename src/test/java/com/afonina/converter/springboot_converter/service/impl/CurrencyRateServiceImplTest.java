package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyRateServiceImplTest {
    ConvertService convertService = new ConvertService();
    CurrencyRateServiceImpl currencyRateService = new CurrencyRateServiceImpl();

    private CurrencyRate sourceCurrency = new CurrencyRate();
    private CurrencyRate targetCurrency;

    @Test
    public void convertTest() {


        CurrencyRate targetCurrency = new CurrencyRate();
        CurrencyRateServiceImpl currencyRateService = new CurrencyRateServiceImpl();
        String convert = currencyRateService.convert(,,);
        System.out.println(convert);
    }
}