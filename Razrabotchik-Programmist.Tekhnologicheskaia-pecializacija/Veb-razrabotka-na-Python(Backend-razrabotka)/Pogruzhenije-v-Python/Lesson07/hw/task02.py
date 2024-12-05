"""
Напишите скрипт, который создает архив каталога в формате .zip. Скрипт
должен принимать путь к исходному каталогу и путь к целевому архиву. Архив
должен включать все файлы и подпапки исходного каталога.
"""

import zipfile
import os

def create_zip_archive(source_directory, target_zip):
    """
    Функция для создания архива .zip из каталога.

    :param source_directory: Путь к исходному каталогу
    :param target_zip: Путь к целевому архиву
    """
    # Проверяем, что исходный каталог существует
    if not os.path.exists(source_directory):
        print(f"Исходный каталог {source_directory} не найден.")
        return

    # Создаем архив
    with zipfile.ZipFile(target_zip, 'w', zipfile.ZIP_DEFLATED) as zipf:
        # Проходим по всем файлам и папкам в исходном каталоге
        for root, dirs, files in os.walk(source_directory):
            for file in files:
                # Полный путь к файлу
                file_path = os.path.join(root, file)
                # Путь для архивации файла (относительный путь)
                arcname = os.path.relpath(file_path, source_directory)
                # Добавляем файл в архив
                zipf.write(file_path, arcname)
                print(f"Добавлен в архив: {arcname}")

# Пример использования
source_directory = "./source_folder"  # Путь к исходному каталогу
target_zip = "./archive.zip"  # Путь к целевому архиву

create_zip_archive(source_directory, target_zip)
