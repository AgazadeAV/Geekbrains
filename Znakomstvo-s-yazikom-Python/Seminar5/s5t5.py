'''
Напишите программу, которая на вход принимает
два числа A и B, и возводит число A в целую степень B с
помощью рекурсии.
'''

a = 3
b = 3

def f_1(a, b):
    res = a
    for _ in range(b-1):
        res *= a
    return res

print(f_1(a, b))

def f_2(a, b, res=1):
    if b == 0:
        return res
    return(f_2(a, b-1, res*a))