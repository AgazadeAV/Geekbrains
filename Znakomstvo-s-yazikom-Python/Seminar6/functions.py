def create_list(n):
    arr = []
    for i in range(n):
        arr.append(int(input(f"Введите элемент {i + 1}: ")))
    return arr


def sum_of_divisors(n):
    divisors_sum = 1
    for i in range(2, n):
        if n % i == 0:
            divisors_sum += i
    return divisors_sum
