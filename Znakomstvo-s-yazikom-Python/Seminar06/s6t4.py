"""
Два различных натуральных числа n и m называются
дружественными, если сумма делителей числа n
(включая 1, но исключая само n) равна числу m и
наоборот. Например, 220 и 284 – дружественные числа.
По данному числу k выведите все пары дружественных
чисел, каждое из которых не превосходит k. Программа
получает на вход одно натуральное число k, не
превосходящее 10^5. Программа должна вывести все
пары дружественных чисел, каждое из которых не
превосходит k. Пары необходимо выводить по одной в
строке, разделяя пробелами. Каждая пара должна быть
выведена только один раз (перестановка чисел новую
пару не дает).
"""

from functions import sum_of_divisors

# def sum_of_divisors(n):
#     divisors_sum = 1
#     for i in range(2, n):
#         if n % i == 0:
#             divisors_sum += i
#     return divisors_sum

def sum_of_divisors(n):
    divisors_sum = 1
    for i in range(2, n // 2 + 1): # Если число больше половины, то оно по дефолту не делитель
        if n % i == 0:
            divisors_sum += i
    return divisors_sum

k = 2000

# Начинаем с 220, т.к. минимальная пара дружественных чисел начинается с 220
for i in range(220, k + 1):
    j = sum_of_divisors(i)
    # Условие i != j для того, чтобы исключить равные между собой значения
    # Условие i < j для того, чтобы исключить одинаковые пары
    # Условие j <= k для того, чтобы не противоречить условиям задачи
    if sum_of_divisors(j) == i and i != j and i < j and j <= k:
        print(f"{i} {j}")

# //////////////////////////////////////////////////////////////////////////////////////////

# k = int(input("Введите значение, до которого хотите проверить дружественные числа: "))
#
# for i in range(220, k + 1):
#     for j in range(220, k + 1):
#         if sum_of_divisors(i) == j and sum_of_divisors(j) == i:
#             if i < j:
#                 print(f"{i} {j}")

# //////////////////////////////////////////////////////////////////////////////////////////

# k = int(input("Введите значение, до которого хотите проверить дружественные числа: "))
# friendly_numbers = []
#
# for i in range(220, k + 1):
#     for j in range(220, k + 1):
#         if sum_of_divisors(i) == j and sum_of_divisors(j) == i:
#             if i < j:
#                 friendly_numbers_pair = i, j
#                 friendly_numbers.append(friendly_numbers_pair)
#
# for item in friendly_numbers:
#     print(*item)

"""
def get_sum(n):
    my_sum = 1
    for el in range(2, n // 2 + 1):
        if n % el == 0:
            my_sum += el
    return my_sum

def get_friendlies(k):
    lst = []
    for n in range (1, k + 1):
        if n not in lst:
            m = get_sum(n)
            if n == get_sum(m) and n != m:
                lst.append(n)
                lst.append(m)
    return lst

print(get_friendlies(2000))"""