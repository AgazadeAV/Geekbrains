"""
Напишите функцию same_by(characteristic, objects), которая
проверяет, все ли объекты имеют одинаковое значение
некоторой характеристики, и возвращают True, если это так.

Если значение характеристики для разных объектов
отличается - то False. Для пустого набора объектов, функция
должна возвращать True. Аргумент characteristic - это
функция, которая принимает объект и вычисляет его
характеристику.
"""


def same_by(func, list_1):
    return len(set(map(func, list_1))) < 2


values = []
if same_by(lambda x: x % 2, values):
    print('same')
else:
    print('different')














# def same_by(func, list_1):
#     return list_1 == list(filter(func, list_1))
#
# values = [0, 2, 4, 6]
# if same_by(lambda x: x % 2 == 0, values):
#     print('same')
# else:
#     print('different')