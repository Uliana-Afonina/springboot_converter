package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import org.junit.jupiter.api.Test;

import java.util.List;

class CurrencyRateURLServiceImplTest {
    CurrencyRateURLServiceImpl currencyRateURLServiceImpl = new CurrencyRateURLServiceImpl();
    LoadService loadService = new LoadService();
    TransformFromXmlService transformFromXmlService = new TransformFromXmlService();
    MarshallerService marshallerService = new MarshallerService();

    @Test
    public void getCurrencyRateFromURLTest() {
        currencyRateURLServiceImpl.setLoadService(loadService);
        currencyRateURLServiceImpl.setTransformFromXmlService(transformFromXmlService);
        currencyRateURLServiceImpl.setMarshallerService(marshallerService);
        List<CurrencyRate> currencyRatesFromURL = currencyRateURLServiceImpl.getCurrencyRatesFromURL();
        System.out.println(currencyRatesFromURL);
    }
}