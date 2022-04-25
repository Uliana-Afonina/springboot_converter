package com.afonina.converter.springboot_converter.service.impl.dao;

import com.afonina.converter.springboot_converter.entity.CurrencyConversion;
import com.afonina.converter.springboot_converter.repository.CurrencyConversionRepository;
import com.afonina.converter.springboot_converter.service.api.CurrencyConversionDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyConversionDAOServiceImpl implements CurrencyConversionDAOService {

    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;

    @Override
    public void saveCurrencyConversion(CurrencyConversion currencyConversion) {
        currencyConversionRepository.save(currencyConversion);
    }

    @Override
    public List<CurrencyConversion> findAllCurrencyConversions() {
        List<CurrencyConversion> allCurrencyConversions = currencyConversionRepository.findAll();
        return allCurrencyConversions;
    }
}
