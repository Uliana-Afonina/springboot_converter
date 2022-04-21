package com.afonina.converter.springboot_converter.service.impl.dao;

import com.afonina.converter.springboot_converter.repository.CurrencyRateRepository;
import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.service.api.CurrencyRateDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyRateDAOServiceImpl implements CurrencyRateDAOService {

    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    @Override
    public List<CurrencyRate> getAllCurrencyRates() {
        return currencyRateRepository.findAll();
    }

    @Override
    public CurrencyRate getCurrencyRateByCharCode(String charCode) {
        CurrencyRate currencyRate = null;
        Optional<CurrencyRate> optional = currencyRateRepository.findById(charCode); //в CurrencyRate качестве @Id указано поле charCode
        if (optional.isPresent()) {
            currencyRate = optional.get();
        }
        return currencyRate;
    }

    @Override
    public void saveAllCurrencyRates(List<CurrencyRate> currencyRates) {
        currencyRateRepository.saveAll(currencyRates);
    }

    @Override
    public List<CurrencyRate> findAllByDate(String date) {
        List<CurrencyRate> currencyRates = currencyRateRepository.findAllByDate(date);
        return currencyRates;
    }
}
