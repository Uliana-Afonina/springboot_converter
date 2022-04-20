package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyRateURLServiceTest {
    CurrencyRateURLService currencyRateURLService = new CurrencyRateURLService();
    LoadService loadService = new LoadService();
    TransformFromXmlService transformFromXmlService = new TransformFromXmlService();
    MarshallerService marshallerService = new MarshallerService();

    @Test
    public void getCurrencyRateFromURLTest() {
        currencyRateURLService.setLoadService(loadService);
        currencyRateURLService.setTransformFromXmlService(transformFromXmlService);
        currencyRateURLService.setMarshallerService(marshallerService);
        List<CurrencyRate> currencyRatesFromURL = currencyRateURLService.getCurrencyRatesFromURL();
        System.out.println(currencyRatesFromURL);
    }
}