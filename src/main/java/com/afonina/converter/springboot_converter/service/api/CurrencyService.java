package com.afonina.converter.springboot_converter.service.api;

import com.afonina.converter.springboot_converter.entity.Currency;

import java.util.List;

public interface CurrencyService {
    public List<Currency> getAllCurrencies();

    public Currency getCurrency(String id);

    public void saveCurrency(Currency currency);
}
