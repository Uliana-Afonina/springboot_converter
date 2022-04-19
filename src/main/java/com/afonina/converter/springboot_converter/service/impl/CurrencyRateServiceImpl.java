package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.dao.CurrencyRateRepository;
import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.service.api.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyRateServiceImpl implements CurrencyRateService {

    @Autowired
    private CurrencyRateRepository currencyRateRepository;


    public List<CurrencyRate> getAllCurrencyRates() {
        return currencyRateRepository.findAll();
    }

    public CurrencyRate getCurrencyRateByCharCode(String charCode) {
        CurrencyRate currencyRate = null;
        Optional<CurrencyRate> optional = currencyRateRepository.findById(charCode); //в CurrencyRate качестве @Id указано поле charCode
        if (optional.isPresent()){
            currencyRate = optional.get();
        }
        return currencyRate;
    }

    public void saveCurrencyRate(CurrencyRate currencyRate){
        currencyRateRepository.save(currencyRate);
    }

    public void saveAllCurrencyRates(List<CurrencyRate> currencyRates){
        currencyRateRepository.saveAll(currencyRates);
    }


}
