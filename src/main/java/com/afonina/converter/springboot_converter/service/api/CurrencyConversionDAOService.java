package com.afonina.converter.springboot_converter.service.api;

import com.afonina.converter.springboot_converter.entity.CurrencyConversion;

public interface CurrencyConversionDAOService {
    void saveCurrencyConversion(CurrencyConversion currencyConversion);
}
