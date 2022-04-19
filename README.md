# springboot_converter

Скрипт для создания таблицы в MySQL:

CREATE TABLE my_db.currencyRates (
  id varchar(15),
  name varchar(100),
  exchange_rate_to_ruble varchar(15),
  char_code varchar(15),
  num_code varchar(15),
  date varchar(10),
  PRIMARY KEY (id)
);
