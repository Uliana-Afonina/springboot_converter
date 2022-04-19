package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyRateServiceImplTest {
    ConvertService convertService = new ConvertService();
    CurrencyRateServiceImpl currencyRateService = new CurrencyRateServiceImpl();

    private CurrencyRate sourceCurrency = new CurrencyRate(
            "R01010",
            "Австралийский доллар",
            "59.2560",
            "AUD",
            "036",
            "16.04.2022"
    );
    private CurrencyRate targetCurrency = new CurrencyRate(
            "R01020A",
            "Азербайджанский манат",
            "46.7370",
            "AZN",
            "944",
            "16.04.2022"
    );

    @Test
    public void convertTest() {
        String convert = convertService.convert(sourceCurrency, targetCurrency, "3");
        System.out.println(convert);
    }
}