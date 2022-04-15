package com.afonina.converter.springboot_converter.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name="valutes")
public class Valute {
    @Id
    @Column(name = "ID")
    public String id;

    @Column(name = "Name")
    public String name;

    @Column(name = "Exchange_rate")
    public String exchangeRate;

    @Column(name = "CharCode")
    public String charCode;

    @Column(name = "NumCode")
    public String numCode;

    @Column(name = "Date")
    public String date;

}
