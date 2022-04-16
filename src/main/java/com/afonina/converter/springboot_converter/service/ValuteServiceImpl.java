package com.afonina.converter.springboot_converter.service;

import com.afonina.converter.springboot_converter.dao.ValuteRepository;
import com.afonina.converter.springboot_converter.entity.Valute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValuteServiceImpl implements ValuteService {

    @Autowired
    private ValuteRepository valuteRepository;


    public List<Valute> getAllValutes () {
        return valuteRepository.findAll();
    }

    public Valute getValute (String id) {
        Valute valute = null;
        Optional<Valute> optional = valuteRepository.findById(id);
        if (optional.isPresent()){
            valute = optional.get();
        }
        return valute;
    }

    public void saveValute (Valute valute){
        valuteRepository.save(valute);
    }
}
