package com.afonina.converter.springboot_converter.service;

import com.afonina.converter.springboot_converter.dao.ValuteRepository;
import com.afonina.converter.springboot_converter.entity.Сurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValuteServiceImpl implements ValuteService {

    @Autowired
    private ValuteRepository valuteRepository;


    public List<Сurrency> getAllValutes () {
        return valuteRepository.findAll();
    }

    public Сurrency getValute (String id) {
        Сurrency сurrency = null;
        Optional<Сurrency> optional = valuteRepository.findById(id);
        if (optional.isPresent()){
            сurrency = optional.get();
        }
        return сurrency;
    }

    public void saveValute (Сurrency сurrency){
        valuteRepository.save(сurrency);
    }
}
