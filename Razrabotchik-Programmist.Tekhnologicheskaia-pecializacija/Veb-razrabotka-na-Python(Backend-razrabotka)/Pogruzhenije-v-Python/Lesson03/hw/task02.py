"""
Напишите программу, которая принимает список чисел через строку и
возвращает наибольшее число в этом списке.
"""

def find_max_number(numbers_str):
    # Преобразуем строку в список чисел
    numbers = list(map(int, numbers_str.split()))

    # Находим и возвращаем наибольшее число
    max_number = max(numbers)
    return max_number


# Пример использования
input_str = input("Введите список чисел, разделенных пробелами: ")
max_number = find_max_number(input_str)

print(f"Наибольшее число в списке: {max_number}")
