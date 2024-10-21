"""
Дан список повторяющихся элементов. Вернуть список с дублирующимися
элементами. В результирующем списке не должно быть дубликатов.
"""

def find_duplicates(input_list):
    # Создаем словарь для отслеживания количества вхождений каждого элемента
    element_count = {}

    # Подсчитываем вхождения элементов
    for element in input_list:
        if element in element_count:
            element_count[element] += 1
        else:
            element_count[element] = 1

    # Формируем список дубликатов
    duplicates = [element for element, count in element_count.items() if count > 1]

    return duplicates


# Пример использования
input_list = [1, 2, 3, 1, 2, 4, 5, 3, 6, 7, 8, 5, 5]
result = find_duplicates(input_list)

print(f"Список с дублирующимися элементами: {result}")
