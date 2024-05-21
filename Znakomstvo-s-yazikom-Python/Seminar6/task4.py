"""
Задание 2

values = [True, False, True, None, True]
result = []
for v in values:
    if v is True:
        result.append('yes')
    else:
        if v is False:
            result.append('no')
        else:
            result.append('unknown')

print(result)

Перепишите приведенный код на lc
"""
# values = [True, False, True, None, True]
#
# print(["yes" if v is True else "no" if v is False else "unknown" for v in values])
"""
Задание 32.
✔ Напишите функцию, которая принимает строку текста.
✔ Сформируйте список с уникальными кодами Unicode каждого
символа введённой строки отсортированный по убыванию.

Решите через lc
"""

# def func(data):
#     return sorted(set([ord(el) for el in data]))
#
# print(func("abrakadabra"))

"""
Задание 2
Для чисел в пределах от 20 до 240 найти числа, кратные 20 или 21.
Необходимо решить задание в одну строку.
Подсказка: использовать функцию range() и lc.
"""

# print([elem for elem in range(20, 241) if elem % 20 == 0 or elem % 21 == 0])

"""
Задание 1
Представлен список чисел. Необходимо вывести элементы исходного списка,
значения которых больше предыдущего элемента.
Подсказка: элементы, удовлетворяющие условию, оформить в виде списка.
Для формирования списка использовать генератор.
Пример исходного списка: [300, 2, 12, 44, 1, 1, 4, 10, 7, 1, 78, 123, 55].
Результат: [12, 44, 4, 10, 78, 123].

Реализуйте вариант без lc и с lc
"""

# primary_list = [300, 2, 12, 44, 1, 1, 4, 10, 7, 1, 78, 123, 55]
#
# print([primary_list[i] for i in range(1, len(primary_list)) if primary_list[i] > primary_list[i - 1]])


"""
Задание 34
✔ Функция принимает на вход три списка одинаковой длины:
✔ имена str,
✔ ставка int,
✔ премия str с указанием процентов вида «10.25%».
✔ Вернуть словарь с именем в качестве ключа и суммой
премии в качестве значения.
✔ Сумма рассчитывается как ставка умноженная на процент премии.

Решите через dc.
"""
def func(names, salaries, awards):
    print(list(zip(names, salaries, awards)))
    return {name: salary * float(award.rstrip("%")) / 100 for name, salary, award in zip(names, salaries, awards)}



names = ['Борис', 'Семен', 'Петр', "Сергей", "Азер"]
salaries = [10000, 12000, 16000, 14000, 50000]
awards = ['12.35%', '10.25%', '7.75%', '8.85%']

print(func(names, salaries, awards))














