package com.afonina.converter.springboot_converter.service.api;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;

import java.util.List;

public interface CurrencyRateDAOService {
    List<CurrencyRate> getAllCurrencyRates();

    CurrencyRate getCurrencyRateByCharCode(String id);

    void saveAllCurrencyRates(List<CurrencyRate> currencyRates);

    List<CurrencyRate> findAllByDate(String date);
}
