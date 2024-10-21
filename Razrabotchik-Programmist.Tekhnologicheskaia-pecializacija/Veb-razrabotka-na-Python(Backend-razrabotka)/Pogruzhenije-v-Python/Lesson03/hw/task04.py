"""
Напишите программу, которая генерирует случайный пароль заданной длины,
состоящий из букв, цифр и специальных символов.
"""

import random
import string

def generate_password(length):
    # Определяем возможные символы для пароля
    letters = string.ascii_letters  # Буквы (верхний и нижний регистр)
    digits = string.digits            # Цифры
    special_characters = string.punctuation  # Специальные символы

    # Объединяем все символы в один набор
    all_characters = letters + digits + special_characters

    # Генерируем пароль, выбирая случайные символы
    password = ''.join(random.choice(all_characters) for _ in range(length))

    return password

# Пример использования
try:
    password_length = int(input("Введите длину пароля: "))
    if password_length <= 0:
        print("Длина пароля должна быть положительным числом.")
    else:
        password = generate_password(password_length)
        print(f"Сгенерированный пароль: {password}")
except ValueError:
    print("Пожалуйста, введите корректное целое число.")
