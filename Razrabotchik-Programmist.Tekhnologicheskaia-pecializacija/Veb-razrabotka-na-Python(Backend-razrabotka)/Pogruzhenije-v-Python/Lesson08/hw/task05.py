"""
Напишите скрипт, который считывает данные из CSV файла и сохраняет их в
JSON файл с другой структурой. CSV файл содержит данные о книгах (название,
автор, год издания). В JSON файле данные должны быть сгруппированы по
авторам, а книги каждого автора должны быть записаны как список.
Пример: Из файла books.csv нужно создать файл books_by_author.json, где
книги сгруппированы по авторам.
"""

import csv
import json
from collections import defaultdict


def group_books_by_author(input_file, output_file):
    """
    Функция для группировки книг по авторам и сохранения результата в JSON файл.

    :param input_file: Путь к исходному CSV файлу с данными о книгах
    :param output_file: Путь к итоговому JSON файлу
    """
    # Словарь для группировки книг по авторам
    books_by_author = defaultdict(list)

    # Читаем данные из CSV файла
    with open(input_file, 'r', encoding='utf-8') as f:
        reader = csv.DictReader(f)

        # Обрабатываем каждую строку (книгу)
        for row in reader:
            author = row["author"]
            title = row["title"]
            year = row["year"]

            # Добавляем книгу в список авторов
            books_by_author[author].append({
                "title": title,
                "year": year
            })

    # Сохраняем результат в JSON файл
    with open(output_file, 'w', encoding='utf-8') as f:
        json.dump(books_by_author, f, ensure_ascii=False, indent=4)

    print(f"Данные успешно сохранены в файл {output_file}")


# Пример использования
input_file = "books.csv"  # Путь к исходному CSV файлу с данными о книгах
output_file = "books_by_author.json"  # Путь к итоговому JSON файлу

group_books_by_author(input_file, output_file)
