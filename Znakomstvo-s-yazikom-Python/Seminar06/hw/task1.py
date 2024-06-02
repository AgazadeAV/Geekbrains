"""
Задача 30: Заполните массив элементами арифметической
прогрессии. Её первый элемент, разность и количество
элементов нужно ввести с клавиатуры. Формула для
получения n-го члена прогрессии: a_n = a_1 + (n-1) * d.
Каждое число вводится с новой строки.
"""

a1 = 2
d = 3
n = 4

print('\n'.join([str(a1 + i * d) for i in range(n)]))

# args = list(map(int, input("Введите первый член, шаг и количество членов арифметической прогрессии: ").split()))

# def arithmetic_progression(args):
#     progression = list(range(args[2]))
#     for i in range(args[2]):
#         progression[i] = args[0] + i * args[1]
#     return progression

# print(*arithmetic_progression(args))

# //////////////////////////////////////////////////////////////////////////////////

# first = int(input("Введите первый член арифметической прогрессии: "))
# step = int(input("Введите шаг арифметической прогрессии: "))
# size = int(input("Введите количество членов арифметической прогрессии, которые хотите узнать: "))

# def arithmetic_progression(first, step, size):
#     progression = list(range(size))
#     for i in range(size):
#         progression[i] = first + i * step
#     return progression

# print(*arithmetic_progression(first, step, size))

# //////////////////////////////////////////////////////////////////////////////////

# args = list(map(int, input("Введите первый член, шаг и количество членов арифметической прогрессии: ").split()))

# def arithmetic_progression(args):
#     arr = [args[0]]
#     for _ in range(args[2]):
#         args[0] += args[1]
#         arr.append(args[0])
#     return arr

# print(*arithmetic_progression(args))

# //////////////////////////////////////////////////////////////////////////////////

# first = int(input("Введите первый член арифметической прогрессии: "))
# step = int(input("Введите шаг арифметической прогрессии: "))
# size = int(input("Введите количество членов арифметической прогрессии, которые хотите узнать: "))

# def arithmetic_progression(first, step, size):
#     arr = [first]
#     for _ in range(size):
#         first += step
#         arr.append(first)
#     return arr

# print(*arithmetic_progression(first, step, size))