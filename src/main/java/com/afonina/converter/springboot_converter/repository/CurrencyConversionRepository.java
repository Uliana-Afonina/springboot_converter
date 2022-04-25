package com.afonina.converter.springboot_converter.repository;

import com.afonina.converter.springboot_converter.entity.CurrencyConversion;
import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Integer> {
    List<CurrencyConversion> findAllByDate(String date);
}
