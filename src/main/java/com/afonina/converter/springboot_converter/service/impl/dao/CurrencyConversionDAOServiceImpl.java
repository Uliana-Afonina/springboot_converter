package com.afonina.converter.springboot_converter.service.impl.dao;

import com.afonina.converter.springboot_converter.entity.CurrencyConversion;
import com.afonina.converter.springboot_converter.service.api.CurrencyConversionDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionDAOServiceImpl implements CurrencyConversionDAOService {
    @Autowired
    private CurrencyConversionDAOService currencyConversionDAOService;

    @Override
    public void saveCurrencyConversion(CurrencyConversion currencyConversion) {
        currencyConversionDAOService.saveCurrencyConversion(currencyConversion);
    }
}
