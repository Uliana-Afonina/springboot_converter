package com.afonina.converter.springboot_converter.service;

import com.afonina.converter.springboot_converter.entity.ValutesCurses;
import com.afonina.converter.springboot_converter.service.impl.MarshallerService;
import org.junit.jupiter.api.Test;

class MarshallerServiceTest {
    MarshallerService marshallerService = new MarshallerService();
    private String pathName = "src/main/resources/xml/valutesFromCBRF.xml";
    @Test
    void getValutesCursesTest() {
        ValutesCurses valutesCurses = marshallerService.getValutesCursesFromXmlFile(pathName);
        System.out.println(valutesCurses);
    }

    @Test
    void getValutesTest() {
        ValutesCurses valutesCurses = marshallerService.getValutesCursesFromXmlFile(pathName);
        System.out.println(valutesCurses.getValutes());
    }
}