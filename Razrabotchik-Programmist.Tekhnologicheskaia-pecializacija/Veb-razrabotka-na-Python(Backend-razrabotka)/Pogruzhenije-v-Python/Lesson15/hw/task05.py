"""
Напишите код, который запускается из командной строки и получает на вход путь
до директории на ПК. Соберите информацию о содержимом в виде объектов
namedtuple. Каждый объект хранит: имя файла без расширения или название
каталога, расширение, если это файл, флаг каталога, название родительского
каталога. В процессе сбора сохраните данные в текстовый файл используя
логирование.
"""

import os
import logging
from collections import namedtuple
import argparse
import sys

# Настройка логирования
logging.basicConfig(
    filename='directory_info.log',
    level=logging.INFO,
    format='%(asctime)s - %(message)s'
)

# Описание структуры объекта
FileInfo = namedtuple('FileInfo', ['name', 'extension', 'is_directory', 'parent'])


def collect_directory_info(directory):
    """Собирает информацию о содержимом директории."""
    if not os.path.isdir(directory):
        raise ValueError(f"Путь {directory} не является директорией.")

    result = []

    for root, dirs, files in os.walk(directory):
        parent = os.path.basename(root)

        # Информация о каталогах
        for dir_name in dirs:
            info = FileInfo(name=dir_name, extension='', is_directory=True, parent=parent)
            result.append(info)
            logging.info(f"Обработан каталог: {info}")

        # Информация о файлах
        for file_name in files:
            name, extension = os.path.splitext(file_name)
            info = FileInfo(name=name, extension=extension.lstrip('.'), is_directory=False, parent=parent)
            result.append(info)
            logging.info(f"Обработан файл: {info}")

    return result


def main():
    # Парсер аргументов командной строки
    parser = argparse.ArgumentParser(description='Собрать информацию о содержимом директории.')
    parser.add_argument('directory', type=str, help='Путь до директории')
    args = None

    try:
        args = parser.parse_args()
    except SystemExit as e:
        logging.error("Ошибка: Не указан путь до директории.")
        print("Ошибка: Не указан путь до директории. Пожалуйста, укажите путь и повторите запуск.")
        sys.exit(1)

    try:
        directory_info = collect_directory_info(args.directory)

        for item in directory_info:
            print(item)
    except Exception as e:
        logging.error(f"Ошибка: {e}")
        print(f"Ошибка: {e}")


if __name__ == '__main__':
    main()
