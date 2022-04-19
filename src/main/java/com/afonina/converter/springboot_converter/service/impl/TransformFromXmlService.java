package com.afonina.converter.springboot_converter.service.impl;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import com.afonina.converter.springboot_converter.entity.ValutesCurses;

import java.util.ArrayList;
import java.util.List;

public class TransformFromXmlService {

    public List<CurrencyRate> getCurrenciesFromValutesCurses(ValutesCurses valutesCurses) {
        String date = valutesCurses.getDate();
        List<ValutesCurses.Valute> valutes = valutesCurses.getValutes();
        List<CurrencyRate> currenciesList = new ArrayList<>();

        for (ValutesCurses.Valute valute : valutes) {
            currenciesList.add(
                    new CurrencyRate(
                            valute.getId(),
                            valute.getName(),
                            valute.getExchangeRateToRuble(valute.getValue(), valute.getNominal()),
                            valute.getCharCode(),
                            valute.getNumCode(),
                            date
                    )
            );
        }
        return currenciesList;
    }
}



