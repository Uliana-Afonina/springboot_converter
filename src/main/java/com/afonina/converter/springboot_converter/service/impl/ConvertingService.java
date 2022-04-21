package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.service.api.CurrencyRateService;
import com.afonina.converter.springboot_converter.service.api.CurrencyRateURLService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Setter
public class ConvertingService {

    @Autowired
    private CurrencyRateService currencyRateService;
    @Autowired
    private LoadService loadService;
    @Autowired
    private CurrencyRateURLService currencyRateURLService;

    public BigDecimal getBigDecimalFromString(String string) {
        String replace = string.replace(",", ".");
        return new BigDecimal(replace);
    }


    public String convert(String sourceCurrencyCode, String targetCurrencyCode, String coefficient) {
        BigDecimal sourceCurrencyExchangeRateToRuble = BigDecimal.ZERO;
        BigDecimal targetCurrencyExchangeRateToRuble = BigDecimal.ZERO;
        BigDecimal coefficientToDecimal = new BigDecimal(coefficient);

        Map<String, CurrencyRate> currencyRateHashMap = getCurrencyRateMap();

        if (currencyRateHashMap.containsKey(sourceCurrencyCode)) {
            sourceCurrencyExchangeRateToRuble = getBigDecimalFromString(currencyRateHashMap.get(sourceCurrencyCode).getExchangeRateToRuble());
        }
        if (currencyRateHashMap.containsKey(targetCurrencyCode)) {
            targetCurrencyExchangeRateToRuble = getBigDecimalFromString(currencyRateHashMap.get(targetCurrencyCode).getExchangeRateToRuble());
        }

        BigDecimal result = sourceCurrencyExchangeRateToRuble.divide(targetCurrencyExchangeRateToRuble, 4).multiply(coefficientToDecimal);
        return result.toString();
    }

    private Map<String, CurrencyRate> getCurrencyRateMap() {
        List<CurrencyRate> allCurrencyRatesByToday = currencyRateService.findAllByDate(getCurrentDate());
        Map<String, CurrencyRate> currencyRateHashMap = new HashMap<>();
        allCurrencyRatesByToday.forEach(currencyRate -> currencyRateHashMap.put(currencyRate.getCharCode(), currencyRate));
        return currencyRateHashMap;
    }

    private String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.YYYY");
        String currentDate = formatter.format(date);
        return currentDate;
    }

}
