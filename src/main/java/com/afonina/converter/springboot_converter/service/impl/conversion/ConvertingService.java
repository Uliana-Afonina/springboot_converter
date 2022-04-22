package com.afonina.converter.springboot_converter.service.impl.conversion;

import com.afonina.converter.springboot_converter.entity.CurrencyConversion;
import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.service.api.CurrencyConversionDAOService;
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
    private CurrencyRateURLService currencyRateURLService;
    @Autowired
    private CurrencyConversionDAOService currencyConversionDAOService;
    @Autowired
    private RubleCurrencyConverterService rubleCurrencyConverterService;
    @Autowired
    private NonRubleCurrencyConversionService nonRubleCurrencyConversionService;

    public String conversionWithRuble(String sourceCurrencyCode, String targetCurrencyCode, String coefficient, Map<String, CurrencyRate> currencyRateHashMapForToday) {
        BigDecimal sourceCurrencyExchangeRateToRuble = BigDecimal.ZERO;
        BigDecimal targetCurrencyExchangeRateToRuble = BigDecimal.ZERO;

        if (sourceCurrencyCode.equals("RUB")) {
            sourceCurrencyExchangeRateToRuble = new BigDecimal("1.0000");
            targetCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(targetCurrencyCode, currencyRateHashMapForToday);
        }
        if (targetCurrencyCode.equals("RUB")) {
            sourceCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(sourceCurrencyCode, currencyRateHashMapForToday);
            targetCurrencyExchangeRateToRuble = new BigDecimal("1.0000");
        }
        BigDecimal result = sourceCurrencyExchangeRateToRuble.divide(targetCurrencyExchangeRateToRuble, 4).multiply(new BigDecimal(coefficient));
        return result.toString();
    }

    public String conversionWithoutRuble(String sourceCurrencyCode, String targetCurrencyCode, String coefficient, Map<String, CurrencyRate> currencyRateHashMapForToday) {

        BigDecimal sourceCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(sourceCurrencyCode, currencyRateHashMapForToday);
        BigDecimal targetCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(targetCurrencyCode, currencyRateHashMapForToday);

        BigDecimal result = sourceCurrencyExchangeRateToRuble.divide(targetCurrencyExchangeRateToRuble, 4).multiply(new BigDecimal(coefficient));
        return result.toString();
    }

    public String convert(String sourceCurrencyCode, String targetCurrencyCode, String coefficient) {
        Map<String, CurrencyRate> currencyRateHashMapForToday = getCurrencyRateMap();
        String result;

        if (sourceCurrencyCode.equals("RUB")||targetCurrencyCode.equals("RUB")) {
            result = conversionWithRuble(sourceCurrencyCode, targetCurrencyCode, coefficient, currencyRateHashMapForToday);
        } else {
            result = conversionWithoutRuble(sourceCurrencyCode, targetCurrencyCode, coefficient, currencyRateHashMapForToday);
        }

//        BigDecimal sourceCurrencyExchangeRateToRuble = BigDecimal.ZERO;
//        BigDecimal targetCurrencyExchangeRateToRuble = BigDecimal.ZERO;
//
//        if (sourceCurrencyCode.equals("RUB")) {
//            sourceCurrencyExchangeRateToRuble = new BigDecimal("1.0000");
//            targetCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(targetCurrencyCode, currencyRateHashMapForToday);
//        }
//        if (targetCurrencyCode.equals("RUB")) {
//            sourceCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(sourceCurrencyCode, currencyRateHashMapForToday);
//            targetCurrencyExchangeRateToRuble = new BigDecimal("1.0000");
//        }
//        if (!(sourceCurrencyCode.equals("RUB")) && !(targetCurrencyCode.equals("RUB"))) {
//            sourceCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(sourceCurrencyCode, currencyRateHashMapForToday);
//            targetCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(targetCurrencyCode, currencyRateHashMapForToday);
//        }
//        if (sourceCurrencyCode.equals(null)||targetCurrencyCode.equals(null)) {
//            throw new RuntimeException();
//        }
//        BigDecimal result = sourceCurrencyExchangeRateToRuble.divide(targetCurrencyExchangeRateToRuble, 4).multiply(new BigDecimal(coefficient));
        currencyConversionDAOService.saveCurrencyConversion(
                new CurrencyConversion(
                        currencyRateHashMapForToday.get(sourceCurrencyCode).getCharCode()
                                + "("
                                + currencyRateHashMapForToday.get(sourceCurrencyCode).getName()
                                + ")",
                        currencyRateHashMapForToday.get(targetCurrencyCode).getCharCode()
                                + "("
                                + currencyRateHashMapForToday.get(targetCurrencyCode).getName()
                                + ")",
                        coefficient,
                        result,
                        currencyRateHashMapForToday.get(sourceCurrencyCode).getDate()
                )
        );
        return result;
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
        return formatter.format(date);
    }

    public BigDecimal getBigDecimalFromString(String string) {
        String replace = string.replace(",", ".");
        return new BigDecimal(replace);
    }
}
