package com.afonina.converter.springboot_converter.service;

import com.afonina.converter.springboot_converter.entity.Сurrency;

import java.util.List;

public interface ValuteService {
    public List<Сurrency> getAllValutes ();

    public Сurrency getValute (String id);

    public void saveValute (Сurrency сurrency);
}
