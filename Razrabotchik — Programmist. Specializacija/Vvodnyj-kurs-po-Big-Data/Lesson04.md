Вот обновленное руководство, написанное от первого лица и учитывающее, что мы загружаем датасет и выполняем задачи:

### Шаг 1: Загрузка датасета

Мы начнем с загрузки датасета с Kaggle. Для этого:

1. Перейдем на страницу [New York City Airbnb Open Data](https://www.kaggle.com/dgomonov/new-york-city-airbnb-open-data).
2. Скачаем файл `AB_NYC_2019.csv`.

### Шаг 2: Подготовка данных и Hive

Теперь мы загрузим датасет в Hive и выполним расчеты. Для этого:

1. Создадим таблицу в Hive для хранения данных:

    ```sql
    CREATE TABLE airbnb_prices (
        id INT,
        name STRING,
        host_id INT,
        host_name STRING,
        neighbourhood_group STRING,
        neighbourhood STRING,
        latitude DOUBLE,
        longitude DOUBLE,
        room_type STRING,
        price INT,
        minimum_nights INT,
        number_of_reviews INT,
        last_review STRING,
        reviews_per_month DOUBLE,
        calculated_host_listings_count INT,
        availability_365 INT
    )
    ROW FORMAT DELIMITED
    FIELDS TERMINATED BY ','
    STORED AS TEXTFILE;
    ```

2. Загрузим данные из CSV в эту таблицу:

    ```sql
    LOAD DATA LOCAL INPATH '/path/to/AB_NYC_2019.csv' INTO TABLE airbnb_prices;
    ```

3. Выполним запрос для подсчета среднего значения и дисперсии цен:

    ```sql
    SELECT
        AVG(price) AS mean_price,
        VAR_POP(price) AS variance_price
    FROM
        airbnb_prices;
    ```

### Шаг 3: Реализация MapReduce на Python

Теперь мы реализуем MapReduce для расчета статистики. Мы создадим два файла: `mapper.py` и `reducer.py`.

#### `mapper.py`

В `mapper.py` мы будем читать строки из входного потока и выводить ключ-значение для каждой записи:

```python
#!/usr/bin/env python3
import sys

# Mapper: читает строки и выводит ключ-значение для каждой записи
for line in sys.stdin:
    line = line.strip()
    if not line:
        continue
    fields = line.split(',')
    try:
        price = float(fields[9])  # Индекс 9 соответствует колонке 'price'
        print(f"price\t{price}")
    except ValueError:
        continue
```

#### `reducer.py`

В `reducer.py` мы вычислим среднее значение и дисперсию:

```python
#!/usr/bin/env python3
import sys

# Reducer: вычисляет среднее значение и дисперсию
n, mean, M2 = 0, 0.0, 0.0

for line in sys.stdin:
    line = line.strip()
    if not line:
        continue
    _, price_str = line.split('\t')
    try:
        price = float(price_str)
        n += 1
        delta = price - mean
        mean += delta / n
        M2 += delta * (price - mean)
    except ValueError:
        continue

if n > 0:
    variance = M2 / n
    print(f"Mean: {mean}")
    print(f"Variance: {variance}")
else:
    print("No data")
```

### Шаг 4: Запуск MapReduce

Теперь мы запустим MapReduce задачи для обработки данных:

1. Сначала скопируем данные в HDFS:

    ```sh
    hdfs dfs -mkdir /user/azer-agazade/airbnb
    hdfs dfs -put /path/to/AB_NYC_2019.csv /user/azer-agazade/airbnb/
    ```

2. Запустим MapReduce задачу:

    ```sh
    hadoop jar /path/to/hadoop-streaming.jar \
        -input /user/azer-agazade/airbnb/AB_NYC_2019.csv \
        -output /user/azer-agazade/airbnb/output \
        -mapper /path/to/mapper.py \
        -reducer /path/to/reducer.py
    ```

3. Просмотрим результаты выполнения:

    ```sh
    hdfs dfs -cat /user/azer-agazade/airbnb/output/part-*
    ```

### Шаг 5: Сравнение результатов

Мы сравним результаты, полученные из Hive и MapReduce. Они должны совпадать, если все сделано правильно.

- **Среднее значение (`mean_price`)** и **дисперсия (`variance_price`)** из Hive должны совпадать с теми, что мы получили из MapReduce.

Следуя этим шагам, мы сможем подсчитать среднее значение и дисперсию по признаку `price` как в Hive, так и с помощью MapReduce на Python. Убедимся, что пути к файлам и команды указаны корректно для нашей среды выполнения.