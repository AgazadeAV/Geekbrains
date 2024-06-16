n = int(input())
max = None
min = None

for i in range(n):
    m = int(input())
    if max is None or m > max:
        max = m
    if min is None or m < min:
        min = m

print(min, max)

data  = input("Введите числа через пробел")

data = [5, 1, 6, 5, 9]
# list(map(int, input("Введите числа через пробел: ").split()))
max_num = data[0]
min_num = data[0]


for el in data:
    if el > max_num:
        max_num = el
    if el < min_num:
        min_num = el

print(min_num, max_num)

def func(data=[5, 1, 6, 5, 9], max_num=data[0], min_num=data[0]):
    if len(data) == 0:
        return max_num, min_num
    if data[0] > max_num:
        max_num = data[0]
    if data[0] < min_num:
        min_num = data[0]
    return func(data[1:], max_num, min_num)

print(func(data))