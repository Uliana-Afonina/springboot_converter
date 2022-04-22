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
@Table(name = "currencyconversions")
public class CurrencyConversion {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="source_currency")
    private String sourceCurrency;

    @Column(name="target_currency")
    private String targetCurrency;

    @Column(name="source_amount")
    private String sourceAmount;

    @Column(name="received_amount")
    private String receivedAmount;

    @Column(name="date")
    private String date;
}
