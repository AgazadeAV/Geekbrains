"""
Создайте класс User, который содержит атрибуты name, email, и age.
Необходимо убедиться, что:
● Имя состоит из хотя бы двух слов, каждое из которых начинается с
заглавной буквы.
● Электронная почта содержит символ @ и точку . после @.
● Возраст — это положительное целое число, не меньше 0 и не больше
120.
Создайте пользовательские исключения для каждой из этих проверок:
● NameError: Если имя не соответствует формату.
● EmailError: Если электронная почта не соответствует формату.
● AgeError: Если возраст вне допустимого диапазона.
"""

import re


# Создание пользовательских исключений
class NameError(Exception):
    pass


class EmailError(Exception):
    pass


class AgeError(Exception):
    pass


class User:
    def __init__(self, name, email, age):
        self.name = name
        self.email = email
        self.age = age

    def __setattr__(self, name, value):
        if name == "name":
            # Проверка, что имя состоит хотя бы из двух слов с заглавной буквы
            if len(value.split()) < 2 or not all(word[0].isupper() for word in value.split()):
                raise NameError(
                    "Имя должно состоять из хотя бы двух слов, каждое из которых начинается с заглавной буквы.")
        elif name == "email":
            # Проверка формата электронной почты
            if not re.match(r"[^@]+@[^@]+\.[^@]+", value):
                raise EmailError("Электронная почта должна содержать символ '@' и точку после '@'.")
        elif name == "age":
            # Проверка, что возраст - это целое число в допустимом диапазоне
            if not isinstance(value, int) or not (0 <= value <= 120):
                raise AgeError("Возраст должен быть целым числом от 0 до 120.")

        super().__setattr__(name, value)

    def __str__(self):
        return f"User(name={self.name}, email={self.email}, age={self.age})"


# Пример использования
try:
    user1 = User("Иван Иванов", "ivan.ivanov@example.com", 25)
    print(user1)  # Ожидаем успешную инициализацию

    user2 = User("анна", "anna@example", 25)  # Ошибка: имя должно начинаться с заглавной буквы
except NameError as e:
    print(f"Ошибка: {e}")

try:
    user3 = User("Мария Петрова", "maria@com", 25)  # Ошибка: некорректный email
except EmailError as e:
    print(f"Ошибка: {e}")

try:
    user4 = User("Алексей", "alexey@example.com", 130)  # Ошибка: возраст вне диапазона
except AgeError as e:
    print(f"Ошибка: {e}")
