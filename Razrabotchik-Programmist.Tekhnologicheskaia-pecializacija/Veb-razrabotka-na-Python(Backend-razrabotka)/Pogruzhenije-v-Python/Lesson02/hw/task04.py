"""
Программа принимает две строки вида "a/b" - дробь с числителем и
знаменателем. Возвращает сумму и произведение дробей. Для проверки
используется модуль fractions.
"""

from fractions import Fraction


def parse_fraction(fraction_str):
    # Разбиваем строку на числитель и знаменатель
    numerator, denominator = map(int, fraction_str.split('/'))
    return Fraction(numerator, denominator)


def main():
    # Ввод дробей
    fraction1_str = input("Введите первую дробь (a/b): ")
    fraction2_str = input("Введите вторую дробь (c/d): ")

    # Парсим дроби
    fraction1 = parse_fraction(fraction1_str)
    fraction2 = parse_fraction(fraction2_str)

    # Вычисляем сумму и произведение
    sum_fraction = fraction1 + fraction2
    product_fraction = fraction1 * fraction2

    # Выводим результаты
    print(f"Сумма дробей: {sum_fraction} (проверка: {fraction1 + fraction2})")
    print(f"Произведение дробей: {product_fraction} (проверка: {fraction1 * fraction2})")


if __name__ == "__main__":
    main()
