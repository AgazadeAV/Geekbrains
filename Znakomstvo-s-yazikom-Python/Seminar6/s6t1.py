"""
Задача №39. Решение в группах
Даны два массива чисел. Требуется вывести те элементы
первого массива (в том порядке, в каком они идут в первом
массиве), которых нет во втором массиве. Пользователь вводит
число N - количество элементов в первом массиве, затем N
чисел - элементы массива. Затем число M - количество
элементов во втором массиве. Затем элементы второго массива.
"""
import functions

list_1 = functions.create_list(int(input("Введите длину первого списка: ")))
list_2 = functions.create_list(int(input("Введите длину второго списка: ")))
list_3 = []

# Традиционный итератор с функцией append
for el in list_1:
    if el not in list_2:
        list_3.append(el)
print(*list_3)

# List comprehension
print(*[el for el in list_1 if el not in list_2])

print(*list(filter(lambda x: x not in list_2, list_1)))
