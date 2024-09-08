list_1 = [8, 3, 9, 6, 5, 3, 9, 4, 0, 5]
k = -10

# Список для вычисления количества операций для достижения числа k
operations_count = [0] * len(list_1)
# Список для изменения значений изначального списка для достижения числа k
modified_numbers = list_1[:]

# Если элементов списке больше чем k, то мы уменьшаем этот элемент в списке modified_numbers на единицу 
# до тех пор, пока он не станет равен k, а если меньше - увеличиваем, 
# а количество операций, которое необходимо длоя достижения k, вписываем в список operations_count
for i in range(len(modified_numbers)):
    if modified_numbers[i] > k:
        while modified_numbers[i] > k:
            modified_numbers[i] -= 1
            operations_count[i] += 1
    else:
        while modified_numbers[i] < k:
            modified_numbers[i] += 1
            operations_count[i] += 1

min_operations = operations_count[0]
min_index = 0

# Находим индекс элемента с наименьшим количеством изменений, который и будет самым близким по значению к k
for i in range(len(operations_count)):
    if operations_count[i] < min_operations:
        min_operations = operations_count[i]
        min_index = i

print(list_1[min_index])

