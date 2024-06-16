from time import time

def outer(param):
    def decorator(func):
        def wrapper(*args, **kwargs):
            total = 0
            for _ in range(param):
                start_time = time()
                res = func(args[0], args[1])
                end_time = time()
                total += end_time - start_time
            return res, total
        return wrapper
    return decorator

@outer(1)
def power_x(x, y):
    return x ** y

print(power_x(2, 3))