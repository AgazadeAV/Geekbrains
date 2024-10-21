"""
Напишите генераторную функцию substrings(s), которая принимает строку
s и возвращает генератор всех возможных подстрок этой строки.
На вход подается строка abc
На выходе будут выведены обозначения:
a
ab
abc
b
bc
c
"""

def substrings(s):
    length = len(s)
    for start in range(length):
        for end in range(start + 1, length + 1):
            yield s[start:end]  # Возвращает подстроку от start до end

# Пример использования
input_string = "abc"
for substring in substrings(input_string):
    print(substring)
