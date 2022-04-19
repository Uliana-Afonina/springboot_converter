package com.afonina.converter.springboot_converter.service;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.entity.ValutesCurses;
import com.afonina.converter.springboot_converter.service.impl.MarshallerService;
import com.afonina.converter.springboot_converter.service.impl.TransformFromXmlService;
import org.junit.jupiter.api.Test;

import java.util.List;

class TransformFromXmlServiceTest {

    TransformFromXmlService transformFromXmlService = new TransformFromXmlService();
    MarshallerService marshallerService = new MarshallerService();

    @Test
    public void getCurrencies () {
        ValutesCurses valutesCurses = marshallerService.getValutesCurses();
        List<CurrencyRate> сurrencies = transformFromXmlService.getCurrenciesFromValutesCurses(valutesCurses);
        System.out.println(сurrencies);
    }
}