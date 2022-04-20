package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.service.api.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ConvertingService {

    @Autowired
    private CurrencyRateService currencyRateService;
    @Autowired
    private LoadService loadService;

    public BigDecimal getBigDecimalFromString(String string) {
        String replace = string.replace(",", ".");
        return new BigDecimal(replace);
    }


    public String convert(String sourceCurrencyCode, String targetCurrencyCode, String coefficient) {
        currencyRateService.getAllCurrencyRatesByToday();
//
//
//        //идем в БД искать указанные курсы валют
//        CurrencyRate sourceCurrencyRate = currencyRateService.getCurrencyRateByCharCode(sourceCurrencyCode);
//        CurrencyRate targetCurrencyRate = currencyRateService.getCurrencyRateByCharCode(targetCurrencyCode);
//        //если курс валют не сегодняшний, закачиваем с сайта ЦБРФ файл с актуальными курсами валют, заливаем их в БД
////        if (!sourceCurrencyRate.getDate().equals(getCurrentDate())) {
////            loadService.loadXMLfromURL("http://www.cbr.ru/scripts/XML_daily.asp", "src/main/resources/xml/file_name.xml");
////        }
//
////        BigDecimal sourceCurrencyExchangeRateToRuble = new BigDecimal(sourceCurrency.getExchangeRateToRuble());
////        BigDecimal targetCurrencyExchangeRateToRuble = new BigDecimal(targetCurrency.getExchangeRateToRuble());
////        BigDecimal coefficientToDecimal = new BigDecimal(coefficient);
//
////        BigDecimal result = sourceCurrencyExchangeRateToRuble.divide(targetCurrencyExchangeRateToRuble, 4).multiply(coefficientToDecimal);
        return "";
    }


}
