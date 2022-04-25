package com.afonina.converter.springboot_converter.service.api;

import com.afonina.converter.springboot_converter.entity.CurrencyConversion;

import java.util.List;

public interface CurrencyConversionDAOService {
    void saveCurrencyConversion(CurrencyConversion currencyConversion);

    List<CurrencyConversion> findAllCurrencyConversions();
}
