# data = "15 156 96 3 5 8 52 5"
# print(data)

# data = data.split()
# print(data)

# data = list(map(int, data))
# print(data)

data = [15, 65, 9, 36, 175]

res = list(filter(lambda x: x % 10 == 5, data))
print(res)