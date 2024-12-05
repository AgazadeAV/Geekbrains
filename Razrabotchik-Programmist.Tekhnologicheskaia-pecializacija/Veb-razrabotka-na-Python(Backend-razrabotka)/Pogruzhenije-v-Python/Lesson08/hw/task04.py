"""
Напишите скрипт, который считывает данные из CSV файла, содержащего
информацию о продажах (название продукта, количество, цена за единицу), и
подсчитывает общую выручку для каждого продукта. Итог должен быть сохранён в
новом CSV файле.
Пример: Из файла sales.csv нужно создать файл total_sales.csv, где для каждого
продукта будет указана общая выручка.
"""

import csv


def calculate_total_sales(input_file, output_file):
    """
    Функция для подсчета общей выручки для каждого продукта на основе данных из CSV.

    :param input_file: Путь к исходному CSV файлу с данными о продажах
    :param output_file: Путь к итоговому CSV файлу с выручкой
    """
    # Словарь для хранения выручки по каждому продукту
    total_sales = {}

    # Читаем данные из CSV файла
    with open(input_file, 'r', encoding='utf-8') as f:
        reader = csv.DictReader(f)

        # Обрабатываем каждую строку (продажу)
        for row in reader:
            product = row["name"]
            quantity = int(row["quantity"])
            price = float(row["price"])

            # Вычисляем выручку для текущей продажи
            revenue = quantity * price

            # Добавляем выручку к уже существующей (если продукт уже есть в словаре)
            if product in total_sales:
                total_sales[product] += revenue
            else:
                total_sales[product] = revenue

    # Сохраняем результат в новый CSV файл
    with open(output_file, 'w', newline='', encoding='utf-8') as f:
        fieldnames = ["name", "total_revenue"]
        writer = csv.DictWriter(f, fieldnames=fieldnames)

        # Записываем заголовок
        writer.writeheader()

        # Записываем итоговую выручку по каждому продукту
        for product, revenue in total_sales.items():
            writer.writerow({"name": product, "total_revenue": revenue})

    print(f"Общая выручка успешно сохранена в файл {output_file}")


# Пример использования
input_file = "sales.csv"  # Путь к исходному CSV файлу с данными о продажах
output_file = "total_sales.csv"  # Путь к итоговому CSV файлу с выручкой

calculate_total_sales(input_file, output_file)
