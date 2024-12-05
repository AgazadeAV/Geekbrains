"""
Напишите функцию, которая получает на вход директорию и рекурсивно обходит
её и все вложенные директории. Результаты обхода сохраните в файлы json, csv и
pickle. Для дочерних объектов указывайте родительскую директорию. Для
каждого объекта укажите файл это или директория. Для файлов сохраните его
размер в байтах, а для директорий размер файлов в ней с учётом всех вложенных
файлов и директорий. Соберите из созданных на уроке и в рамках домашнего
задания функций пакет для работы с файлами разных форматов.
"""

import os
import json
import csv
import pickle


def get_directory_info(directory):
    """
    Функция для рекурсивного обхода директории и сохранения информации о файлах и папках.

    :param directory: Путь к директории
    :return: Список с информацией о файлах и папках
    """
    # Список для хранения информации о файлах и папках
    directory_info = []

    # Рекурсивно проходим по всем файлам и папкам в каталоге и подкаталогах
    for root, dirs, files in os.walk(directory):
        for name in dirs + files:
            path = os.path.join(root, name)
            is_dir = os.path.isdir(path)
            size = 0

            # Если это файл, получаем его размер
            if not is_dir:
                size = os.path.getsize(path)
            else:
                # Если это папка, считаем общий размер всех файлов внутри неё
                for dirpath, dirnames, filenames in os.walk(path):
                    for filename in filenames:
                        size += os.path.getsize(os.path.join(dirpath, filename))

            # Добавляем информацию о файле или папке в список
            directory_info.append({
                "name": name,
                "path": path,
                "is_directory": is_dir,
                "size": size,
                "parent": root
            })

    return directory_info


def save_to_json(data, file_path):
    """
    Функция для сохранения данных в формат JSON.

    :param data: Данные для сохранения
    :param file_path: Путь к файлу
    """
    with open(file_path, 'w', encoding='utf-8') as f:
        json.dump(data, f, ensure_ascii=False, indent=4)
    print(f"Данные сохранены в файл JSON: {file_path}")


def save_to_csv(data, file_path):
    """
    Функция для сохранения данных в формат CSV.

    :param data: Данные для сохранения
    :param file_path: Путь к файлу
    """
    with open(file_path, 'w', newline='', encoding='utf-8') as f:
        writer = csv.DictWriter(f, fieldnames=["name", "path", "is_directory", "size", "parent"])
        writer.writeheader()
        writer.writerows(data)
    print(f"Данные сохранены в файл CSV: {file_path}")


def save_to_pickle(data, file_path):
    """
    Функция для сохранения данных в формат Pickle.

    :param data: Данные для сохранения
    :param file_path: Путь к файлу
    """
    with open(file_path, 'wb') as f:
        pickle.dump(data, f)
    print(f"Данные сохранены в файл Pickle: {file_path}")


def save_directory_info(directory):
    """
    Функция для сбора и сохранения информации о директории в форматах JSON, CSV и Pickle.

    :param directory: Путь к директории
    """
    # Получаем информацию о директории
    directory_info = get_directory_info(directory)

    # Сохраняем данные в различные форматы
    save_to_json(directory_info, "directory_info.json")
    save_to_csv(directory_info, "directory_info.csv")
    save_to_pickle(directory_info, "directory_info.pkl")


# Пример использования
directory = "./files"  # Путь к каталогу
save_directory_info(directory)
