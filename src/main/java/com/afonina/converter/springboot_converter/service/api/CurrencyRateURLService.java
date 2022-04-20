package com.afonina.converter.springboot_converter.service.api;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;

import java.util.List;

public interface CurrencyRateURLService {
    List<CurrencyRate> getCurrencyRatesFromURL();
}
