package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.service.impl.url.CurrencyRateURLServiceImpl;
import com.afonina.converter.springboot_converter.service.impl.url.LoadService;
import com.afonina.converter.springboot_converter.service.impl.url.MarshallerService;
import com.afonina.converter.springboot_converter.service.impl.url.TransformFromXmlService;
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