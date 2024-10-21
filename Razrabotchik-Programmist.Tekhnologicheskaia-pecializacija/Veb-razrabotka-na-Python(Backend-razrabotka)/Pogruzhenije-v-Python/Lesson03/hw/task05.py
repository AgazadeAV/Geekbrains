"""
Напишите программу, которая принимает два слова и определяет, являются ли
они анаграммами.
"""

def are_anagrams(word1, word2):
    # Убираем пробелы и приводим слова к нижнему регистру
    cleaned_word1 = word1.replace(" ", "").lower()
    cleaned_word2 = word2.replace(" ", "").lower()

    # Сравниваем отсортированные символы двух слов
    return sorted(cleaned_word1) == sorted(cleaned_word2)

# Пример использования
word1 = input("Введите первое слово: ")
word2 = input("Введите второе слово: ")

if are_anagrams(word1, word2):
    print("Слова являются анаграммами.")
else:
    print("Слова не являются анаграммами.")
