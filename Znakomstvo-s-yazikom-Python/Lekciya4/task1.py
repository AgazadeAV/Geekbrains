# lst = [1, 2, 3, 5, 8, 15, 38]

# print([(el, el**2,) for el in lst if el % 2 == 0])

def select(f, col):
    return[f(x) for x in col]

def where(f, col):
    return [x for x in col if f(x)]

lst = [1, 2, 3, 5, 8, 15, 38]
res = select(int, lst)
print(res)
res = where(lambda x: x % 2 == 0, res)
print(res)
res = list(select(lambda x: (x, x**2), res))
print(res)
