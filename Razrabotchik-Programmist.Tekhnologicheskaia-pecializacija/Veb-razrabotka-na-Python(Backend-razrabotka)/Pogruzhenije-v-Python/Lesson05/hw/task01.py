"""
Пользователь вводит число N. Напишите программу, которая генерирует
последовательность из квадратов чисел от 1 до N (1 ** 2, 2 ** 2, 3 ** 2 и так
далее). Реализацию напишите двумя способами: функция-генератор и
генераторное выражение.
"""

def square_generator(n):
    """Генератор для последовательности квадратов чисел от 1 до n."""
    for i in range(1, n + 1):
        yield i ** 2

def main():
    # Запрашиваем у пользователя ввод числа N
    while True:
        try:
            n = int(input("Введите число N: "))
            if n < 1:
                print("Пожалуйста, введите число больше или равное 1.")
                continue
            break
        except ValueError:
            print("Некорректный ввод. Пожалуйста, введите целое число.")

    # Используем функцию-генератор
    print("Квадраты чисел от 1 до N (функция-генератор):")
    for square in square_generator(n):
        print(square, end=' ')
    print()  # Для перехода на новую строку

    # Используем генераторное выражение
    print("Квадраты чисел от 1 до N (генераторное выражение):")
    squares = (i ** 2 for i in range(1, n + 1))
    for square in squares:
        print(square, end=' ')
    print()  # Для перехода на новую строку

# Запуск основной программы
if __name__ == "__main__":
    main()
