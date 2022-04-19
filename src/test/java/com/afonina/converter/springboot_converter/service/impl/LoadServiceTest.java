package com.afonina.converter.springboot_converter.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoadServiceTest {
    LoadService loadService = new LoadService();

    @Test
    public void getXMLFromUrlTest() {
        loadService.loadXMLfromURL();
    }
}