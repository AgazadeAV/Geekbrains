"""
Напишите скрипт, который объединяет данные из нескольких JSON файлов в
один. Каждый файл содержит список словарей, описывающих сотрудников
компании (имя, фамилия, возраст, должность). Итоговый JSON файл должен
содержать объединённые списки сотрудников из всех файлов.
Пример: У вас есть три файла employees1.json, employees2.json,
employees3.json. Нужно объединить их в один файл all_employees.json.
"""

import json
import os


def merge_json_files(file_paths, output_file):
    """
    Функция для объединения данных из нескольких JSON файлов в один.

    :param file_paths: Список путей к исходным JSON файлам
    :param output_file: Путь к итоговому файлу
    """
    all_employees = []

    # Читаем данные из каждого файла и добавляем их в общий список
    for file_path in file_paths:
        if os.path.exists(file_path):
            with open(file_path, 'r', encoding='utf-8') as f:
                employees = json.load(f)
                all_employees.extend(employees)  # Добавляем сотрудников в общий список
        else:
            print(f"Файл {file_path} не найден.")

    # Записываем объединённый список в итоговый файл
    with open(output_file, 'w', encoding='utf-8') as f:
        json.dump(all_employees, f, ensure_ascii=False, indent=4)

    print(f"Данные успешно объединены в файл: {output_file}")


# Пример использования
file_paths = ["employees1.json", "employees2.json", "employees3.json"]  # Список исходных файлов
output_file = "all_employees.json"  # Путь к итоговому файлу

merge_json_files(file_paths, output_file)
