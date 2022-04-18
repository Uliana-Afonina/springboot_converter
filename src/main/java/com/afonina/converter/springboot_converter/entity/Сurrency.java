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
@Table(name = "valutes")
public class Сurrency {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "Name")
    public String name;

    //    @Column(name = "Exchange_rate")
//    public String exchangeRate;
    @Column(name = "Value")
    public String value;

    @Column(name = "Nominal")
    public String nominal;

    @Column(name = "CharCode")
    private String charCode;

    @Column(name = "NumCode")
    private String numCode;

    @Column(name = "Date")
    private String date;

}
