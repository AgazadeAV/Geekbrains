"""
1. Проверить есть ли в файле пустые значения
2. Показать median_house_value где median_income < 2
3. Показать данные в первых 2 столбцах
4. Выбрать данные где housing_median_age < 20 и
median_house_value > 70000
"""

from pandas import read_csv

data = read_csv("california_housing_test.csv")

# 1. Проверить есть ли в файле пустые значения
print(data.isnull().sum())

# 2. Показать median_house_value где median_income < 2
print(data[data["median_income"] < 2]["median_house_value"])

# 3. Показать данные в первых 2 столбцах
print(data[["longitude", "latitude"]])  # if we know columns' names
print(data.iloc[:, :2])  # if we don't know columns' names

# 4. Выбрать данные где housing_median_age < 20 и median_house_value > 70000
print(data[(data["housing_median_age"] < 20) & (data["median_house_value"] > 70000)])
