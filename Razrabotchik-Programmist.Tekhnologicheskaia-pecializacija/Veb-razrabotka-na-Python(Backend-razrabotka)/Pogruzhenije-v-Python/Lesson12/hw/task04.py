"""
Создайте класс Product с атрибутами name, price, и quantity. price должен
быть положительным числом, а quantity неотрицательным целым числом. При
попытке установить price или quantity, должен производиться контроль
значений.
"""


class Product:
    def __init__(self, name, price, quantity):
        self.name = name
        self.price = price  # Будет проверено при установке
        self.quantity = quantity  # Будет проверено при установке

    def __setattr__(self, name, value):
        if name == "price":
            # Проверка, что цена - положительное число
            if not isinstance(value, (int, float)) or value <= 0:
                raise ValueError("Цена должна быть положительным числом")
        elif name == "quantity":
            # Проверка, что количество - неотрицательное целое число
            if not isinstance(value, int) or value < 0:
                raise ValueError("Количество должно быть неотрицательным целым числом")
        super().__setattr__(name, value)

    def __str__(self):
        return f"Product(name={self.name}, price={self.price}, quantity={self.quantity})"


# Пример использования
try:
    product1 = Product("Laptop", 1000, 10)
    print(product1)

    product2 = Product("Phone", -500, 5)  # Ошибка: цена не может быть отрицательной
except ValueError as e:
    print(f"Ошибка: {e}")

try:
    product3 = Product("Tablet", 300, -5)  # Ошибка: количество не может быть отрицательным
except ValueError as e:
    print(f"Ошибка: {e}")
