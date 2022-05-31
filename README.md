# springboot_converter
проект на Spring Boot.
Java 14, Maven, MySQL, Spring Data, Spring Security.

При запуске приложение получает список актуальных валют и их курсов с сайта ЦБРФ http://www.cbr.ru/scripts/XML_daily.asp и записывает их в БД (идентификаторы, коды, названия), а также курсы (привязанные к валюте) на дату запроса. В конвертере авторизация по логину и паролю. Пройдя авторизацию, пользователь попадает на главный экран: http://localhost:8080/converter. Необходимо указать, из какой валюты в какую будет конвертация, количество переводимых средств (сформировать get-запрос). Далее происходит запрос в БД на получение актуального курса на текущую дату. Если данные на текущую дату отсутствуют, производится получение актуальных курсов с сайта ЦБ и запись их в базу данных. В конвертере ведется история произведенных конвертаций с записью в базу данных с указанием даты и курса, по которому была произведена конвертация. Историю можно посмотреть по адресу: http://localhost:8080/history. 


Скрипт для создания таблиц в MySQL:

1. Таблица курсов валют

CREATE TABLE my_db.currencyRates (
  id varchar(15),
  name varchar(100),
  exchange_rate_to_ruble varchar(15),
  char_code varchar(15),
  num_code varchar(15),
  date varchar(10),
  PRIMARY KEY (char_code)
);

2. Таблица с историей конвертаций

CREATE TABLE my_db.currencyconversions (
  id int NOT NULL AUTO_INCREMENT,
  source_currency varchar(100),
  target_currency varchar(100),
  source_amount varchar(50),
  received_amount varchar(50),
  date varchar(10),
  PRIMARY KEY (id)
);

пример get-запроса для операции конвертации:

http://localhost:8080/converter?sourceCurrencyCode=AUD&targetCurrencyCode=AZN&coefficient=2
