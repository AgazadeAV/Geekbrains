"""
Напишите программу, которая получает целое число и возвращает его
шестнадцатеричное строковое представление. Функцию hex используйте для
проверки своего результата.
"""

# Примеры чисел
numbers = [255, 16, 0, -42]

# Определяем символы для цифр в шестнадцатеричной системе
hex_digits = '0123456789ABCDEF'

# Функция для преобразования целого числа в шестнадцатеричное представление
def int_to_hex(number):
    # Если число равно 0, то возвращаем '0'
    if number == 0:
        return '0'
    
    # Обрабатываем отрицательные числа
    is_negative = number < 0
    if is_negative:
        number = -number
    
    hex_string = ''
    while number > 0:
        remainder = number % 16
        hex_string = hex_digits[remainder] + hex_string
        number //= 16
    
    # Добавляем префикс '-' для отрицательных чисел
    if is_negative:
        hex_string = '-' + hex_string
    
    return hex_string

# Обработка и вывод результатов
for number in numbers:
    hex_string = int_to_hex(number)
    print(f"{number} -> {hex_string} (проверка: {hex(number)})")
