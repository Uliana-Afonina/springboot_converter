package com.afonina.converter.springboot_converter.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "currencyconversions")
public class CurrencyConversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public CurrencyConversion(String sourceCurrency, String targetCurrency, String sourceAmount, String receivedAmount, String date) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.sourceAmount = sourceAmount;
        this.receivedAmount = receivedAmount;
        this.date = date;
    }
}
