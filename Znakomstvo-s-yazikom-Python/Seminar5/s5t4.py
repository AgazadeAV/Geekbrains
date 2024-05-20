# Дано натуральное число N и
# последовательность из N элементов.
# Требуется вывести эту последовательность в
# обратном порядке.
# Примечание. В программе запрещается
# объявлять массивы и использовать циклы
# (даже для ввода и вывода).
# Input: 2 -> 3 4
# Output: 4 3

data = "3 4"

def func1(data):
    new_str = ""
    for elem in reversed(data):
        new_str += elem
    return new_str

print(func1(data))

def func2(data, new_str=""):
    if len(data) == 0:
        return new_str
    return func2(data[:-1], new_str + data[-1])





def revers(n):
    if n > 0:
      num = int(input())
      revers(n-1)
      print(num, end=' ')
      
revers(int(input()))
