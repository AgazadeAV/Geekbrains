"""
Реализуйте декоратор counter, считающий и выводящий количество вызовов
декорируемой функции.
Для решения задачи нельзя использовать операторы global и nonlocal.
Пример: Из файла products.json нужно создать products.csv.
"""

def counter(func):
    """
    Декоратор, который считает количество вызовов декорируемой функции.
    """
    def wrapper(*args, **kwargs):
        # Создаем атрибут функции для хранения счетчика вызовов
        if not hasattr(wrapper, 'call_count'):
            wrapper.call_count = 0
        # Увеличиваем счетчик
        wrapper.call_count += 1
        print(f"Функция {func.__name__} вызвана {wrapper.call_count} раз(а)")
        return func(*args, **kwargs)  # Вызов оригинальной функции
    return wrapper

# Пример использования декоратора
@counter
def test():
    print("Функция выполнена!")

# Вызовы функции
test()
test()
test()
