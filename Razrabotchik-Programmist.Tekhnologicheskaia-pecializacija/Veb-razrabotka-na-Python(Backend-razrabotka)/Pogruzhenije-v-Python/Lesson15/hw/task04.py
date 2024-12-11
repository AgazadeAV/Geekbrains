"""
Напишите скрипт, который принимает два аргумента командной строки: число и
строку. Добавьте следующие опции:
● --verbose, если этот флаг установлен, скрипт должен выводить
дополнительную информацию о процессе.
● --repeat, если этот параметр установлен, он должен указывать,
сколько раз повторить строку в выводе.
"""

import argparse
import sys

def main():
    # Создание парсера аргументов командной строки
    parser = argparse.ArgumentParser(description="Скрипт с опциями verbose и repeat.")

    # Основные аргументы
    parser.add_argument("number", type=int, help="Число.")
    parser.add_argument("string", type=str, help="Строка для вывода.")

    # Дополнительные опции
    parser.add_argument("--verbose", action="store_true", help="Выводить дополнительную информацию о процессе.")
    parser.add_argument("--repeat", type=int, default=1, help="Сколько раз повторить строку в выводе (по умолчанию 1).")

    # Для тестирования в изолированной среде задаем значения аргументов по умолчанию
    if len(sys.argv) == 1:
        sys.argv.extend(["42", "Hello", "--verbose", "--repeat", "3"])

    # Разбор аргументов
    args = parser.parse_args()

    if args.verbose:
        print("[INFO] Начинается выполнение скрипта.")
        print(f"[INFO] Полученное число: {args.number}")
        print(f"[INFO] Полученная строка: {args.string}")
        print(f"[INFO] Количество повторений: {args.repeat}")

    # Повторение строки
    for i in range(args.repeat):
        print(args.string)

    if args.verbose:
        print("[INFO] Скрипт завершил выполнение.")

if __name__ == "__main__":
    main()
