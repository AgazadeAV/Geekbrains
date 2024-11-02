"""
Создайте модуль с функцией, которая получает список слов и возвращает
словарь, в котором ключи — это слова, а значения — количество их повторений
в списке.
"""

def count_word_occurrences(words):
    """
    Функция принимает список слов и возвращает словарь,
    где ключи - это слова, а значения - количество их повторений в списке.

    :param words: Список слов
    :return: Словарь с количеством повторений слов
    """
    word_count = {}
    for word in words:
        # Увеличиваем счетчик слова на 1 или добавляем слово в словарь
        if word in word_count:
            word_count[word] += 1
        else:
            word_count[word] = 1
    return word_count

# Пример использования
if __name__ == "__main__":
    example_words = ["apple", "banana", "apple", "orange", "banana", "apple"]
    result = count_word_occurrences(example_words)
    print(result)  # Вывод: {'apple': 3, 'banana': 2, 'orange': 1}
