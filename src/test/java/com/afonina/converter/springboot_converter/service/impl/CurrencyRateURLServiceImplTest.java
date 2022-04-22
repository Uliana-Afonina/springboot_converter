package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.service.impl.url.CurrencyRateURLServiceImpl;
import com.afonina.converter.springboot_converter.service.impl.url.LoadService;
import com.afonina.converter.springboot_converter.service.impl.url.MarshallerService;
import com.afonina.converter.springboot_converter.service.impl.url.TransformFromXmlService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CurrencyRateURLServiceImplTest {
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
        //TODO Assert.assertEquals(currencyRatesFromURL.get(0), new CurrencyRate())




        System.out.println(currencyRatesFromURL);
    }
}