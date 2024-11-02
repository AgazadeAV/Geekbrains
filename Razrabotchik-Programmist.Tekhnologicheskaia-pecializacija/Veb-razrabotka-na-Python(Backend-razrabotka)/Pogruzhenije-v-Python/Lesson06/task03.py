"""
Создайте модуль с функцией, которая принимает два списка и возвращает
список, содержащий только элементы, которые уникальны для обоих списков.
"""

def unique_elements(list1, list2):
    """
    Функция принимает два списка и возвращает список, содержащий только элементы,
    которые уникальны для обоих списков.

    :param list1: Первый список
    :param list2: Второй список
    :return: Список с уникальными элементами
    """
    # Преобразуем списки в множества для удобства работы
    set1 = set(list1)
    set2 = set(list2)

    # Находим уникальные элементы для каждого списка
    unique_to_list1 = set1 - set2
    unique_to_list2 = set2 - set1

    # Объединяем уникальные элементы
    unique_elements_list = list(unique_to_list1.union(unique_to_list2))

    return unique_elements_list

# Пример использования
if __name__ == "__main__":
    example_list1 = [1, 2, 3, 4, 5]
    example_list2 = [4, 5, 6, 7, 8]
    result = unique_elements(example_list1, example_list2)
    print(result)  # Вывод: [1, 2, 3, 6, 7, 8]
