package com.afonina.converter.springboot_converter.dao;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, String> {
    default List<CurrencyRate> findAllByDate(String date) {
        return null;
    }
}
