package com.afonina.converter.springboot_converter.dao;

import com.afonina.converter.springboot_converter.entity.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, String> {

        List<CurrencyRate> findAllByDate(String date);
}
