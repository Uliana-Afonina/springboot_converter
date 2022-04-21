package com.afonina.converter.springboot_converter.service.api;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;

import java.util.List;

public interface CurrencyRateService {
    List<CurrencyRate> getAllCurrencyRates();

    CurrencyRate getCurrencyRateByCharCode(String id);

    void saveCurrencyRate(CurrencyRate currencyRate);

    void saveAllCurrencyRates(List<CurrencyRate> currencyRates);

    List<CurrencyRate> getAllCurrencyRatesByToday();
}
