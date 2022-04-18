package com.afonina.converter.springboot_converter.service;

import com.afonina.converter.springboot_converter.entity.Сurrency;
import com.afonina.converter.springboot_converter.entity.ValutesCurses;
import org.junit.jupiter.api.Test;

import java.util.List;

class TransformFromXmlServiceTest {

    TransformFromXmlService transformFromXmlService = new TransformFromXmlService();
    MarshallerService marshallerService = new MarshallerService();

    @Test
    public void getCurrencies () {
        ValutesCurses valutesCurses = marshallerService.getValutesCurses();
        List<Сurrency> сurrencies = transformFromXmlService.getValutesFromValutesCurses(valutesCurses);
        System.out.println(сurrencies);
    }
}