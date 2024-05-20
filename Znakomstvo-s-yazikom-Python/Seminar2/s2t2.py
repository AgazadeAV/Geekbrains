n = int(input())

n0 = 0
n1 = 0
n2 = 1
i = 2

while n0 < n:
    n0 = n1 + n2
    n1 = n2
    n2 = n0
    i += 1
    if n0 > n:
        i = -1
print(i)

def func(a, fibo_p=0, fibo_n=1, position=2):
    if fibo_n == a: 
        return position
    elif fibo_n < a:
        return func(a, fibo_n, fibo_p+fibo_n, position+1)
    else:
        return "-1"
    
print(func(5))