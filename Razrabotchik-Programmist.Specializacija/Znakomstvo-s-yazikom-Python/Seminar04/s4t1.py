"""
Задача №25. Решение в группах
Напишите программу, которая принимает на вход
строку, и отслеживает, сколько раз каждый символ
уже встречался. Количество повторов добавляется к
символам с помощью постфикса формата _n.
Input: a a a b c a a d c d d
Output: a a_1 a_2 b c a_3 a_4 d c_1 d_1 d_2
Для решения данной задачи используйте функцию
.split()
"""

data = "a a a b c a a d c d d".split()
res = {}
for item in data:
    if item not in res:
        print(item, end=" ")
    else:
        print(f"{item}_{res[item]}", end=" ")
    res[item] = res.get(item, 0) + 1
