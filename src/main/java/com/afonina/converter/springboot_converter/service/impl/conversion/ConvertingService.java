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

    public String convert(String sourceCurrencyCode, String targetCurrencyCode, String coefficient) {
        Map<String, CurrencyRate> currencyRateHashMapForToday = getCurrencyRateMap();
        String result;

        if (sourceCurrencyCode.equals("RUB") || targetCurrencyCode.equals("RUB")) {
            result = conversionWithRuble(sourceCurrencyCode, targetCurrencyCode, coefficient, currencyRateHashMapForToday);
        } else {
            result = conversionWithoutRuble(sourceCurrencyCode, targetCurrencyCode, coefficient, currencyRateHashMapForToday);
        }
        saveCurrencyConversion(sourceCurrencyCode, targetCurrencyCode, coefficient, currencyRateHashMapForToday, result);
        return result;
    }

    public String conversionWithRuble(String sourceCurrencyCode, String targetCurrencyCode, String coefficient, Map<String, CurrencyRate> currencyRateHashMapForToday) {
        BigDecimal amount = new BigDecimal(coefficient + ".0000");
        BigDecimal result = BigDecimal.ZERO;

        if (sourceCurrencyCode.equals("RUB")) {
            BigDecimal targetCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(targetCurrencyCode, currencyRateHashMapForToday);
            result = amount.divide(targetCurrencyExchangeRateToRuble, 4);
        }
        if (targetCurrencyCode.equals("RUB")) {
            BigDecimal sourceCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(sourceCurrencyCode, currencyRateHashMapForToday);
            result = sourceCurrencyExchangeRateToRuble.multiply(amount);
        }
        return result.toString();
    }

    public String conversionWithoutRuble(String sourceCurrencyCode, String targetCurrencyCode, String coefficient, Map<String, CurrencyRate> currencyRateHashMapForToday) {
        BigDecimal sourceCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(sourceCurrencyCode, currencyRateHashMapForToday);
        BigDecimal targetCurrencyExchangeRateToRuble = getSourceCurrencyExchangeRateToRuble(targetCurrencyCode, currencyRateHashMapForToday);
        BigDecimal result = sourceCurrencyExchangeRateToRuble.divide(targetCurrencyExchangeRateToRuble, 4).multiply(new BigDecimal(coefficient));
        return result.toString();
    }

    private void saveCurrencyConversion(String sourceCurrencyCode, String targetCurrencyCode, String coefficient, Map<String, CurrencyRate> currencyRateHashMapForToday, String result) {
        String source = sourceCurrencyCode.equals("RUB") ? "RUB(Российский рубль)" : getCurrencyForCurrencyConversions(sourceCurrencyCode, currencyRateHashMapForToday);
        String target = targetCurrencyCode.equals("RUB") ? "RUB(Российский рубль)" : getCurrencyForCurrencyConversions(targetCurrencyCode, currencyRateHashMapForToday);

        currencyConversionDAOService.saveCurrencyConversion(
                new CurrencyConversion(
                        source,
                        target,
                        coefficient,
                        result,
                        getCurrentDate()
                )
        );
    }

    private String getCurrencyForCurrencyConversions(String sourceCurrencyCode, Map<String, CurrencyRate> currencyRateHashMapForToday) {
        return currencyRateHashMapForToday.get(sourceCurrencyCode).getCharCode()
                + "("
                + currencyRateHashMapForToday.get(sourceCurrencyCode).getName()
                + ")";
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
