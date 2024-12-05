"""
Напишите функцию, которая находит и перечисляет все файлы с заданным
расширением в указанном каталоге и всех его подкаталогах. Функция должна
принимать путь к каталогу и расширение файла.
"""

import os

def find_files_with_extension(directory, extension):
    """
    Функция для поиска и перечисления всех файлов с заданным расширением в каталоге и его подкаталогах.

    :param directory: Путь к каталогу
    :param extension: Расширение файла (например, '.txt')
    """
    # Проверяем, что каталог существует
    if not os.path.exists(directory):
        print(f"Каталог {directory} не найден.")
        return

    # Список для хранения найденных файлов
    found_files = []

    # Проходим по всем файлам и папкам в каталоге и подкаталогах
    for root, dirs, files in os.walk(directory):
        for file in files:
            # Проверяем, что файл имеет нужное расширение
            if file.endswith(extension):
                # Полный путь к файлу
                file_path = os.path.join(root, file)
                found_files.append(file_path)

    # Выводим найденные файлы
    if found_files:
        print(f"Найдено файлов с расширением {extension}:")
        for file in found_files:
            print(file)
    else:
        print(f"Не найдено файлов с расширением {extension} в каталоге {directory}.")

# Пример использования
directory = "./files"  # Путь к каталогу
extension = ".txt"  # Расширение файла

find_files_with_extension(directory, extension)
