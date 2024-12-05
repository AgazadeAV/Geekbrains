"""
Напишите функцию группового переименования файлов. Она должна:
1. принимать параметр желаемое конечное имя файлов. При
переименовании в конце имени добавляется порядковый номер.
2. принимать параметр количество цифр в порядковом номере.
3. принимать параметр расширение исходного файла. Переименование
должно работать только для этих файлов внутри каталога.
4. принимать параметр расширение конечного файла.
5. принимать диапазон сохраняемого оригинального имени.
Например для диапазона [3, 6] берутся буквы с 3 по 6 из исходного имени файла.
К ним прибавляется желаемое конечное имя, если оно передано. Далее счётчик
файлов и расширение. 3.Соберите из созданных на уроке и в рамках домашнего
задания функций пакет для работы с файлами.
"""

import os

def batch_rename_files(directory, base_name, num_digits, original_extension, final_extension, name_range):
    """
    Функция для группового переименования файлов в каталоге.

    :param directory: Путь к директории с файлами
    :param base_name: Желательное конечное имя файлов
    :param num_digits: Количество цифр в порядковом номере
    :param original_extension: Расширение исходного файла
    :param final_extension: Расширение конечного файла
    :param name_range: Диапазон символов, которые нужно сохранить из оригинального имени файла
    """
    # Проверяем, что директория существует
    if not os.path.exists(directory):
        print(f"Директория {directory} не найдена.")
        return

    # Получаем список всех файлов в директории с нужным расширением
    files = [f for f in os.listdir(directory) if f.endswith(original_extension)]

    # Если нет файлов для переименования
    if not files:
        print(f"Нет файлов с расширением {original_extension} в директории {directory}.")
        return

    # Начинаем переименование файлов
    for index, file_name in enumerate(files):
        # Извлекаем часть оригинального имени из диапазона
        original_name_part = file_name[name_range[0]:name_range[1]]

        # Формируем новое имя
        new_file_name = f"{original_name_part}{base_name}{str(index + 1).zfill(num_digits)}.{final_extension}"

        # Полные пути к файлам
        old_file_path = os.path.join(directory, file_name)
        new_file_path = os.path.join(directory, new_file_name)

        # Переименовываем файл
        os.rename(old_file_path, new_file_path)
        print(f"Переименован файл: {file_name} -> {new_file_name}")


# Пример использования
directory = "./files"
base_name = "newfile"
num_digits = 3
original_extension = ".txt"
final_extension = "txt"
name_range = [3, 6]

batch_rename_files(directory, base_name, num_digits, original_extension, final_extension, name_range)
