"""
Напишите скрипт, который удаляет файлы в указанном каталоге, которые не
изменялись более заданного количества дней. Скрипт должен принимать путь к
каталогу и количество дней.
"""

import os
import time


def delete_old_files(directory, days):
    """
    Функция для удаления файлов, которые не изменялись более заданного количества дней.

    :param directory: Путь к каталогу
    :param days: Количество дней
    """
    # Проверяем, что каталог существует
    if not os.path.exists(directory):
        print(f"Каталог {directory} не найден.")
        return

    # Получаем текущее время
    current_time = time.time()

    # Преобразуем количество дней в секунды
    cutoff_time = current_time - (days * 86400)

    # Проходим по всем файлам в каталоге
    for root, dirs, files in os.walk(directory):
        for file in files:
            # Полный путь к файлу
            file_path = os.path.join(root, file)

            # Получаем время последнего изменения файла
            file_mod_time = os.path.getmtime(file_path)

            # Если файл не изменялся более заданного количества дней, удаляем его
            if file_mod_time < cutoff_time:
                os.remove(file_path)
                print(f"Удален файл: {file_path}")


# Пример использования
directory = "./files"  # Путь к каталогу
days = 30  # Количество дней

delete_old_files(directory, days)
