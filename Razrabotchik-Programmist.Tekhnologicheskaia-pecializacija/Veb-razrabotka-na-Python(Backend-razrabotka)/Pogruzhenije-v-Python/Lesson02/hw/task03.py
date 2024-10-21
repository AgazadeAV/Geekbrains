"""
Программа принимает целое число и возвращает его римское представление в
виде строки.
"""

def int_to_roman(num):
    # Определяем пары чисел и римских символов
    val = [
        1000, 900, 500, 400,
        100, 90, 50, 40,
        10, 9, 5, 4,
        1
    ]
    syms = [
        "M", "CM", "D", "CD",
        "C", "XC", "L", "XL",
        "X", "IX", "V", "IV",
        "I"
    ]

    roman_numeral = ""
    i = 0

    # Обрабатываем число и строим римское представление
    while num > 0:
        for _ in range(num // val[i]):
            roman_numeral += syms[i]
            num -= val[i]
        i += 1

    return roman_numeral

# Примеры использования
numbers = [1, 4, 9, 40, 99, 400, 900, 1000, 2023]

for number in numbers:
    roman_numeral = int_to_roman(number)
    print(f"{number} -> {roman_numeral}")
