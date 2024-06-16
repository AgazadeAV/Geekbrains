'''
Дана последовательность из N целых чисел и число
K. Необходимо сдвинуть всю последовательность
(сдвиг - циклический) на K элементов вправо, K –
положительное число.
'''
num_list = [5, 4, 6, 7, -10]
k = 3

k %= len(num_list)

for i in range(k):
    num_list.insert(0, num_list.pop())

print(num_list)


# a_res = []

# for i in range(k):
#     a_res.append(a[len(a) - 1 - i])
# print(a_res)

# for i in range(len(a) - k):
#     a_res.append(a[i])
# print(a_res)