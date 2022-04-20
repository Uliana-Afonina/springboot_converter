package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.entity.ValutesCurses;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Setter
public class CurrencyRateURLService {
    public static final String URL_CBRF_RATES = "http://www.cbr.ru/scripts/XML_daily.asp";
    public static final String RATES_XML_FILERATH = "src/main/resources/xml/valutesFromCBRF.xml";

    @Autowired
    private LoadService loadService;
    @Autowired
    private MarshallerService marshallerService;
    @Autowired
    private TransformFromXmlService transformFromXmlService;

    public List<CurrencyRate> getCurrencyRatesFromURL() {
        List<CurrencyRate> currencyRates;
        loadService.loadXMLfromURL(URL_CBRF_RATES, RATES_XML_FILERATH);
        ValutesCurses valutesCursesFromXmlFile = marshallerService.getValutesCursesFromXmlFile(RATES_XML_FILERATH);
        currencyRates = transformFromXmlService.getCurrenciesFromValutesCurses(valutesCursesFromXmlFile);
        return currencyRates;
    }
}
