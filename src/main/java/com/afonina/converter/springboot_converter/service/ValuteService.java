package com.afonina.converter.springboot_converter.service;

import com.afonina.converter.springboot_converter.entity.Valute;

import java.util.List;

public interface ValuteService {
    public List<Valute> getAllValutes ();

    public Valute getValute (String id);

    public void saveValute (Valute valute);
}
