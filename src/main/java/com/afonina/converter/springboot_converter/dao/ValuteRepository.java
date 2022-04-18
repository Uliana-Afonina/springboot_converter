package com.afonina.converter.springboot_converter.dao;

import com.afonina.converter.springboot_converter.entity.Сurrency;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ValuteRepository extends JpaRepository<Сurrency, String> {

}
