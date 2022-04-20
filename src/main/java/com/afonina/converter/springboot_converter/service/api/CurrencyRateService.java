package com.afonina.converter.springboot_converter.service.api;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;

import java.util.List;

public interface CurrencyRateService {
    public List<CurrencyRate> getAllCurrencyRates();

    public CurrencyRate getCurrencyRateByCharCode(String id);

    public void saveCurrencyRate(CurrencyRate currencyRate);

    public void saveAllCurrencyRates(List<CurrencyRate> currencyRates);

    public List<CurrencyRate> getAllCurrencyRatesByToday();
}
