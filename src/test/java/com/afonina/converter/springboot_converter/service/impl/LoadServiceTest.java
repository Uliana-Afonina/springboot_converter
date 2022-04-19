package com.afonina.converter.springboot_converter.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoadServiceTest {
    LoadService loadService = new LoadService();
    private String url = "http://www.cbr.ru/scripts/XML_daily.asp";
    private String filePath = "src/main/resources/xml/valutesFromCBRF.xml";
    @Test
    public void getXMLFromUrlTest() {
        loadService.loadXMLfromURL(url, filePath);
    }
}