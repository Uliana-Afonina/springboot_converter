package com.afonina.converter.springboot_converter.service;

import com.afonina.converter.springboot_converter.entity.Сurrency;

import java.util.List;

public interface CurrencyService {
    public List<Сurrency> getAllCurrencies();

    public Сurrency getCurrency(String id);

    public void saveCurrency(Сurrency сurrency);
}
