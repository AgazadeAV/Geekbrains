"""Напишите функцию print_operation_table(operation, num_rows=6, num_columns=6),
которая принимает в качестве аргумента функцию, вычисляющую элемент по номеру строки и
столбца. Аргументы num_rows и num_columns указывают число строк и столбцов таблицы,
которые должны быть распечатаны. Нумерация строк и столбцов идет с единицы (подумайте,
почему не с нуля). Примечание: бинарной операцией называется любая операция, у которой
ровно два аргумента, как, например, у операции умножения.
"""

def print_operation_table(operation, num_rows=6, num_columns=6):
    list_list = []
    for i in range(num_columns):
        list_temp = []
        for y in range(num_rows):
            list_temp.append(operation(i+1, y+1))
        list_list.append(list_temp)
    return list_list

list_list = print_operation_table(lambda x, y: x * y) 

print("Введите номер строки: ")
a = int(input())
print("Введите номер столбца: ")
b = int(input())

print(list_list[b-1][a-1])