# Напишите функцию, которая принимает одно число и
# проверяет, является ли оно простым
# Напоминание: Простое число - это число, которое
# имеет 2 делителя: 1 и n(само число)
# Input: 5
# Output: yes

def simple_number(n):
    if n <= 1: 
        return 'no'
    for item in range(2,n):
        if (n % item == 0 and item != 1 and item != n):
            return 'no'
    return 'yes'

print(simple_number(int(input())))