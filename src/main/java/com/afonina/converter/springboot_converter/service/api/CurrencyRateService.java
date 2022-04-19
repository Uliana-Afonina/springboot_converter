package com.afonina.converter.springboot_converter.service.api;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;

import java.util.List;

public interface CurrencyRateService {
    public List<CurrencyRate> getAllCurrencies();

    public CurrencyRate getCurrency(String id);

    public void saveCurrency(CurrencyRate currencyRate);

    public void saveAllCurrency(List<CurrencyRate> currencyis);
}
