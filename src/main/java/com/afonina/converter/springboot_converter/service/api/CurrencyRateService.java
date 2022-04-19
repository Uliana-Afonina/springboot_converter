package com.afonina.converter.springboot_converter.service.api;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;

import java.util.List;

public interface CurrencyRateService {
    public List<CurrencyRate> getAllCurrencyRates();

    public CurrencyRate getCurrencyRate(String id);

    public void saveCurrencyRate(CurrencyRate currencyRate);

    public void saveAllCurrencyRates(List<CurrencyRate> currencyRates);
}
