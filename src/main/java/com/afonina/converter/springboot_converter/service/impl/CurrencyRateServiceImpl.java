package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.dao.ValuteRepository;
import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.service.api.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyRateServiceImpl implements CurrencyRateService {

    @Autowired
    private ValuteRepository valuteRepository;


    public List<CurrencyRate> getAllCurrencies() {
        return valuteRepository.findAll();
    }

    public CurrencyRate getCurrency(String id) {
        CurrencyRate currencyRate = null;
        Optional<CurrencyRate> optional = valuteRepository.findById(id);
        if (optional.isPresent()){
            currencyRate = optional.get();
        }
        return currencyRate;
    }

    public void saveCurrency(CurrencyRate currencyRate){
        valuteRepository.save(currencyRate);
    }

    public void saveAllCurrency(List<CurrencyRate> currencies){
        valuteRepository.saveAll(currencies);
    }
}
