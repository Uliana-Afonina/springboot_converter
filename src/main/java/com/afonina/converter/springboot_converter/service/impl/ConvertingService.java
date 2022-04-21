package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.service.api.CurrencyRateDAOService;
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
    private CurrencyRateDAOService currencyRateDAOService;
    @Autowired
    private LoadService loadService;
    @Autowired
    private CurrencyRateURLService currencyRateURLService;

    public BigDecimal getBigDecimalFromString(String string) {
        String replace = string.replace(",", ".");
        return new BigDecimal(replace);
    }


    public String convert(String sourceCurrencyCode, String targetCurrencyCode, String coefficient) {
        Map<String, CurrencyRate> currencyRateHashMap = getCurrencyRateMap();
        BigDecimal sourceCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(sourceCurrencyCode, currencyRateHashMap);
        BigDecimal targetCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(targetCurrencyCode, currencyRateHashMap);
        BigDecimal result = sourceCurrencyExchangeRateToRuble.divide(targetCurrencyExchangeRateToRuble, 4).multiply(new BigDecimal(coefficient));
        return result.toString();
    }

    private BigDecimal getSourceCurrencyExchangeRateToRuble(String sourceCurrencyCode, Map<String, CurrencyRate> currencyRateHashMap) {
        if (currencyRateHashMap.containsKey(sourceCurrencyCode)) {
            return getBigDecimalFromString(currencyRateHashMap.get(sourceCurrencyCode).getExchangeRateToRuble());
        } else {
            throw new RuntimeException();
        }
    }

    private Map<String, CurrencyRate> getCurrencyRateMap() {
        List<CurrencyRate> allCurrencyRatesByToday = currencyRateDAOService.findAllByDate(getCurrentDate());

        if (allCurrencyRatesByToday.isEmpty()) {
            allCurrencyRatesByToday = currencyRateURLService.getCurrencyRatesFromURL();
            currencyRateDAOService.saveAllCurrencyRates(allCurrencyRatesByToday);
        }

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
