package com.afonina.converter.springboot_converter.repository;

import com.afonina.converter.springboot_converter.entity.CurrencyConversion;
import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Integer> {
}
