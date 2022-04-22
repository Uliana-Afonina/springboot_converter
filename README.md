# springboot_converter

Скрипт для создания таблиц в MySQL:

CREATE TABLE my_db.currencyRates (
  id varchar(15),
  name varchar(100),
  exchange_rate_to_ruble varchar(15),
  char_code varchar(15),
  num_code varchar(15),
  date varchar(10),
  PRIMARY KEY (char_code)
);

CREATE TABLE my_db.currencyconversions (
  id int NOT NULL AUTO_INCREMENT,
  source_currency varchar(100),
  target_currency varchar(100),
  source_amount varchar(50),
  received_amount varchar(50),
  date varchar(10),
  PRIMARY KEY (id)
);

пример get-запроса:

http://localhost:8080/converter?sourceCurrencyCode=AUD&targetCurrencyCode=AZN&coefficient=2
