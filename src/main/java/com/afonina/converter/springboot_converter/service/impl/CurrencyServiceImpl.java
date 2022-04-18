package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.dao.ValuteRepository;
import com.afonina.converter.springboot_converter.entity.Currency;
import com.afonina.converter.springboot_converter.service.api.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private ValuteRepository valuteRepository;


    public List<Currency> getAllCurrencies() {
        return valuteRepository.findAll();
    }

    public Currency getCurrency(String id) {
        Currency currency = null;
        Optional<Currency> optional = valuteRepository.findById(id);
        if (optional.isPresent()){
            currency = optional.get();
        }
        return currency;
    }

    public void saveCurrency(Currency currency){
        valuteRepository.save(currency);
    }

    public void saveAllCurrency(List<Currency> currencies){
        valuteRepository.saveAll(currencies);
    }
}
