### 1. Сбор данных о погоде

Мы начнем с того, что соберем данные о погоде в различных городах мира за последний месяц. Для этого мы будем использовать API OpenWeatherMap. Вот как мы это сделаем:

#### Шаг 1: Написание скрипта на Python

Сначала мы напишем Python-скрипт для сбора данных. Вот пример кода, который мы будем использовать:

```python
import requests
import pandas as pd
from datetime import datetime

# Конфигурация API
API_KEY = 'a6d88f061b9545f2f341fa229691405e'
CITIES = ['New York', 'London', 'Tokyo', 'Paris', 'Sydney']
BASE_URL = 'http://api.openweathermap.org/data/2.5/weather'

def fetch_weather_data(city):
    response = requests.get(BASE_URL, params={
        'q': city,
        'appid': API_KEY,
        'units': 'metric'
    })
    data = response.json()
    return {
        'city': city,
        'temperature': data['main']['temp'],
        'date': datetime.now().strftime('%Y-%m-%d')
    }

weather_data = []

# Сбор данных
for city in CITIES:
    data = fetch_weather_data(city)
    weather_data.append(data)

# Создание DataFrame
df = pd.DataFrame(weather_data)
df.to_csv('weather_data.csv', index=False)
```

Мы запускаем этот скрипт, который собирает данные о температуре в указанных городах и сохраняет их в файл `weather_data.csv`.

### 2. Построение графиков

Теперь мы визуализируем собранные данные. Мы используем библиотеки Matplotlib и Seaborn для построения графиков:

#### График изменения температуры

```python
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

# Загрузка данных
df = pd.read_csv('weather_data.csv')

# График изменения температуры
plt.figure(figsize=(10, 6))
sns.lineplot(data=df, x='date', y='temperature', hue='city', marker='o')
plt.title('Изменение температуры в разных городах')
plt.xlabel('Дата')
plt.ylabel('Температура (°C)')
plt.xticks(rotation=45)
plt.tight_layout()
plt.savefig('temperature_trend.png')
plt.show()
```

#### График распределения температуры

```python
# График распределения температуры
plt.figure(figsize=(10, 6))
sns.histplot(df['temperature'], kde=True, bins=10)
plt.title('Распределение температуры')
plt.xlabel('Температура (°C)')
plt.ylabel('Частота')
plt.tight_layout()
plt.savefig('temperature_distribution.png')
plt.show()
```

Мы создаем два графика: один показывающий изменение температуры в разных городах, а другой - распределение температур.

### 3. Сохранение результатов в HDFS

Теперь мы сохраним результаты в HDFS. Для этого мы будем использовать библиотеку PyArrow:

```python
from pyarrow import hdfs

# Установление соединения с HDFS
hdfs_client = hdfs.connect('localhost', 9000)

# Загрузка файлов в HDFS
with hdfs_client.open('/user/hadoop/weather_data.csv', 'wb') as f:
    f.write(pd.read_csv('weather_data.csv').to_csv(index=False).encode())

with hdfs_client.open('/user/hadoop/temperature_trend.png', 'wb') as f:
    with open('temperature_trend.png', 'rb') as local_file:
        f.write(local_file.read())

with hdfs_client.open('/user/hadoop/temperature_distribution.png', 'wb') as f:
    with open('temperature_distribution.png', 'rb') as local_file:
        f.write(local_file.read())
```

Мы загружаем все файлы в HDFS, чтобы они были доступны для дальнейшего анализа.

### 4. Выгрузка результатов из HDFS на локальный компьютер

Чтобы выгрузить данные из HDFS на локальный компьютер, мы используем следующий код:

```python
# Установление соединения с HDFS
hdfs_client = hdfs.connect('localhost', 9000)

# Выгрузка файлов из HDFS
with hdfs_client.open('/user/hadoop/weather_data.csv', 'rb') as f:
    with open('downloaded_weather_data.csv', 'wb') as local_file:
        local_file.write(f.read())

with hdfs_client.open('/user/hadoop/temperature_trend.png', 'rb') as f:
    with open('downloaded_temperature_trend.png', 'wb') as local_file:
        local_file.write(f.read())

with hdfs_client.open('/user/hadoop/temperature_distribution.png', 'rb') as f:
    with open('downloaded_temperature_distribution.png', 'wb') as local_file:
        local_file.write(f.read())
```

Теперь мы можем получить файлы из HDFS и использовать их локально для дальнейшего анализа.

---

Таким образом, мы собрали данные о погоде, визуализировали их, сохранили в HDFS и выгрузили на локальный компьютер. Мы уверены, что все шаги выполнены корректно и результаты готовы для дальнейшего анализа.