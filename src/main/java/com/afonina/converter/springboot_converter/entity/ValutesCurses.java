package com.afonina.converter.springboot_converter.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@XmlRootElement(name = "ValCurs")
public class ValutesCurses {

    @XmlAttribute(name = "Date")
    private String date;
//
//    @XmlAttribute(name = "name")
//    public String name;

    @XmlElement(name = "Valute")
    private List<Valute> valutes;

    @Getter
    public static class Valute {

        @XmlAttribute(name = "ID")
        private String id;

        @XmlElement(name = "Name")
        private String name;

        @XmlElement(name = "Value")
        private String value;

        @XmlElement(name = "Nominal")
        private String nominal;

        @XmlElement(name = "CharCode")
        private String charCode;

        @XmlElement(name = "NumCode")
        private String numCode;

        @Override
        public String toString() {
            return "Valute {" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", value='" + value + '\'' +
                    ", nominal='" + nominal + '\'' +
                    ", charCode='" + charCode + '\'' +
                    ", numCode='" + numCode + '\'' +
                    " }";
        }

        public BigDecimal getBigDecimalFromString (String string) {
            String replace = string.replace(",", ".");
            return new BigDecimal(replace);
        }

        public String getExchangeRateToRuble (String divisible, String divisor) {
            BigDecimal num1 = getBigDecimalFromString(divisible);
            BigDecimal num2 = getBigDecimalFromString(divisor);

            BigDecimal result = num1.divide(num2);
            return result.toString();
        }
    }


    @Override
    public String toString() {
        return "ValutesCurses {" +
                "date='" + date + '\'' +
//                ", name='" + name + '\'' +
                ", valutes=" + valutes +
                " }";
    }
}
