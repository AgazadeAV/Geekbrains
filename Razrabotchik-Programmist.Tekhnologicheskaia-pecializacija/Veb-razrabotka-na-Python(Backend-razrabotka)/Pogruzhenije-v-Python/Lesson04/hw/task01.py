"""
Степан использует калькулятор для расчёта суммы и разности чисел, но на
работе ему требуются не только обычные арифметические действия. Он ничего
не хочет делать вручную, поэтому решил немного расширить функционал
калькулятора.
Напишите программу, запрашивающую у пользователя число и действие,
которое нужно сделать с числом: вывести сумму его цифр, максимальную или
минимальную цифру. Каждое действие оформите в виде отдельной функции, а
основную программу зациклите.
Запрошенные числа должны передаваться в функции суммы, максимума и
минимума при помощи аргументов.
"""

def sum_of_digits(number):
    """Возвращает сумму цифр числа."""
    return sum(int(digit) for digit in str(abs(number)))


def max_digit(number):
    """Возвращает максимальную цифру в числе."""
    return max(int(digit) for digit in str(abs(number)))


def min_digit(number):
    """Возвращает минимальную цифру в числе."""
    return min(int(digit) for digit in str(abs(number)))


def main():
    while True:
        user_input = input("Введите число (или 'выход' для завершения): ")
        if user_input.lower() == 'выход':
            print("Завершение работы программы.")
            break

        try:
            number = int(user_input)
        except ValueError:
            print("Пожалуйста, введите корректное целое число.")
            continue

        print("Выберите действие:")
        print("1. Сумма цифр")
        print("2. Максимальная цифра")
        print("3. Минимальная цифра")

        action = input("Введите номер действия (1/2/3): ")

        if action == '1':
            result = sum_of_digits(number)
            print(f"Сумма цифр числа {number} равна: {result}")
        elif action == '2':
            result = max_digit(number)
            print(f"Максимальная цифра числа {number} равна: {result}")
        elif action == '3':
            result = min_digit(number)
            print(f"Минимальная цифра числа {number} равна: {result}")
        else:
            print("Некорректный выбор действия. Пожалуйста, выберите 1, 2 или 3.")


# Запуск основной программы
if __name__ == "__main__":
    main()
