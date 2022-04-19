package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.service.api.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConvertService {

    @Autowired
    private CurrencyRateService currencyRateService;

    public BigDecimal getBigDecimalFromString (String string) {
        String replace = string.replace(",", ".");
        return new BigDecimal(replace);
    }

    public String convert(CurrencyRate sourceCurrency, CurrencyRate targetCurrency, String coefficient) {

        BigDecimal sourceCurrencyExchangeRateToRuble = new BigDecimal(sourceCurrency.getExchangeRateToRuble());
        BigDecimal targetCurrencyExchangeRateToRuble = new BigDecimal(targetCurrency.getExchangeRateToRuble());
        BigDecimal coefficientToDecimal = new BigDecimal(coefficient);

        BigDecimal result = sourceCurrencyExchangeRateToRuble.divide(targetCurrencyExchangeRateToRuble, 4).multiply(coefficientToDecimal);
        return result.toString();
    }

}
