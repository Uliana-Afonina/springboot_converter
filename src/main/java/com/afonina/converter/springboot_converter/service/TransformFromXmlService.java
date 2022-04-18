package com.afonina.converter.springboot_converter.service;

import com.afonina.converter.springboot_converter.entity.Сurrency;
import com.afonina.converter.springboot_converter.entity.ValutesCurses;

import java.util.ArrayList;
import java.util.List;

public class TransformFromXmlService {

    public List<Сurrency> getValutesFromValutesCurses(ValutesCurses valutesCurses) {
        String date = valutesCurses.getDate();
        List<ValutesCurses.Valute> valutes = valutesCurses.getValutes();
        List<Сurrency> currenciesList = new ArrayList<>();


        for (ValutesCurses.Valute valute : valutes) {
            currenciesList.add(
                    new Сurrency(
                            valute.getId(),
                            valute.getName(),
                            valute.getValue(),
                            valute.getNominal(),
                            valute.getCharCode(),
                            valute.getNumCode(),
                            date
                    )
            );
        }
        return currenciesList;
    }
}
