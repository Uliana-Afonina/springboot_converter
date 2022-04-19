package com.afonina.converter.springboot_converter.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "currencyrates")
public class CurrencyRate {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    public String name;

    @Column(name = "exchange_rate_to_ruble")
    public String exchangeRateToRuble;

    @Column(name = "char_code")
    private String charCode;

    @Column(name = "num_code")
    private String numCode;

    @Column(name = "date")
    private String date;

}
