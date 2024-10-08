"""
Напишите программу, которая считает количество простых чисел в заданной
последовательности и выводит ответ на экран.
Простое число делится только на себя и на единицу. Последовательность
задаётся при помощи вызова ввода (input) на каждой итерации цикла. Одна
итерация — одно число.
Пример:
Введите количество чисел: 6.
Введите число: 4.
Введите число: 7.
Введите число: 20.
Введите число: 3.
Введите число: 11.
Введите число: 37.
Количество простых чисел в последовательности: 4.
"""

def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True


def count_primes():
    count = 0
    total_numbers = int(input("Введите количество чисел: "))

    for _ in range(total_numbers):
        num = int(input("Введите число: "))
        if is_prime(num):
            count += 1

    print(f"Количество простых чисел в последовательности: {count}")


# Запуск программы
count_primes()
