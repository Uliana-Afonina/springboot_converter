package com.afonina.converter.springboot_converter.service.impl;

class CurrencyRateDAOServiceImplTest {
    ConvertionService convertionService = new ConvertionService();
    CurrencyRateDAOServiceImpl currencyRateService = new CurrencyRateDAOServiceImpl();

    //    private CurrencyRate sourceCurrency = new CurrencyRate(
//            "R01010",
//            "Австралийский доллар",
//            "59.2560",
//            "AUD",
//            "036",
//            "16.04.2022"
//    );
//    private CurrencyRate targetCurrency = new CurrencyRate(
//            "R01020A",
//            "Азербайджанский манат",
//            "46.7370",
//            "AZN",
//            "944",
//            "16.04.2022"
//    );
    private String sourceCurrencyCode = "AUD";
    private String targetCurrencyCode = "AZN";

//    @Test
//    public void convertTest() {
//        String convert = convertionService.convert(sourceCurrencyCode, targetCurrencyCode, "3");
//        System.out.println(convert);
//    }
}