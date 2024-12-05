"""
Напишите скрипт, который считывает данные из JSON файла и сохраняет их в CSV
файл. JSON файл содержит данные о продуктах (название, цена, количество на
складе). В CSV файле каждая строка должна соответствовать одному продукту.
Пример: Из файла products.json нужно создать products.csv.
"""

import json
import csv


def json_to_csv(json_file, csv_file):
    """
    Функция для преобразования данных из JSON в CSV.

    :param json_file: Путь к исходному JSON файлу
    :param csv_file: Путь к целевому CSV файлу
    """
    # Читаем данные из JSON файла
    with open(json_file, 'r', encoding='utf-8') as f:
        products = json.load(f)

    # Открываем CSV файл для записи
    with open(csv_file, 'w', newline='', encoding='utf-8') as f:
        writer = csv.DictWriter(f, fieldnames=["name", "price", "stock"])

        # Записываем заголовки в CSV
        writer.writeheader()

        # Записываем данные о каждом продукте
        writer.writerows(products)

    print(f"Данные успешно сохранены в файл {csv_file}")


# Пример использования
json_file = "products.json"  # Путь к исходному JSON файлу
csv_file = "products.csv"  # Путь к целевому CSV файлу

json_to_csv(json_file, csv_file)
