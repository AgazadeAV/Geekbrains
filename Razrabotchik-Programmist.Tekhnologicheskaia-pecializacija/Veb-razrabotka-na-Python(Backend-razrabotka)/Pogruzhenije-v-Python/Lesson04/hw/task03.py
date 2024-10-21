"""
Пользователь вводит два числа: N и K. Напишите программу, которая заменяет
каждое число на число, которое получается из исходного записью его цифр в
обратном порядке, затем складывает их, снова переворачивает и выводит
ответ на экран.
Пример:
Введите первое число: 102
Введите второе число: 123
Первое число наоборот: 201
Второе число наоборот: 321
Сумма: 522
Сумма наоборот: 225
"""

def reverse_number(num):
    """Возвращает число с перевернутыми цифрами."""
    return int(str(num)[::-1])


def main():
    # Ввод чисел от пользователя
    first_number = int(input("Введите первое число: "))
    second_number = int(input("Введите второе число: "))

    # Переворачиваем числа
    reversed_first = reverse_number(first_number)
    reversed_second = reverse_number(second_number)

    print(f"Первое число наоборот: {reversed_first}")
    print(f"Второе число наоборот: {reversed_second}")

    # Суммируем перевернутые числа
    total = reversed_first + reversed_second
    print(f"Сумма: {total}")

    # Переворачиваем сумму
    reversed_total = reverse_number(total)
    print(f"Сумма наоборот: {reversed_total}")


# Запуск основной программы
if __name__ == "__main__":
    main()
