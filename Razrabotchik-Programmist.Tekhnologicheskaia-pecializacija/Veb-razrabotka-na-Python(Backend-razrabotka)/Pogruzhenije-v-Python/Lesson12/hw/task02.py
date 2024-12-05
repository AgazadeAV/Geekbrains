"""
Создайте класс Person, который имеет атрибуты name, age, и email. При
установке значения атрибута name, оно должно начинаться с заглавной буквы.
При установке значения атрибута age, оно должно быть целым числом в
диапазоне от 0 до 120. При установке значения атрибута email, оно должно
содержать символ @.
"""


class Person:
    def __init__(self, name, age, email):
        self.name = name
        self.age = age
        self.email = email

    def __setattr__(self, name, value):
        if name == "name":
            # Проверяем, что имя начинается с заглавной буквы
            if not value[0].isupper():
                raise ValueError("Имя должно начинаться с заглавной буквы")
        elif name == "age":
            # Проверяем, что возраст — целое число от 0 до 120
            if not isinstance(value, int) or not (0 <= value <= 120):
                raise ValueError("Возраст должен быть целым числом от 0 до 120")
        elif name == "email":
            # Проверяем, что email содержит символ '@'
            if "@" not in value:
                raise ValueError("Email должен содержать символ '@'")

        super().__setattr__(name, value)

    def __str__(self):
        return f"Person(name={self.name}, age={self.age}, email={self.email})"


# Пример использования
try:
    person1 = Person("Иван Иванов", 30, "ivan@mail.com")
    print(person1)

    person2 = Person("anna", 25, "anna@example.com")  # Ошибка: имя должно начинаться с заглавной буквы
except ValueError as e:
    print(f"Ошибка: {e}")

try:
    person3 = Person("Мария", 130, "maria@mail.com")  # Ошибка: возраст должен быть от 0 до 120
except ValueError as e:
    print(f"Ошибка: {e}")

try:
    person4 = Person("Алексей", 40, "alexeymail.com")  # Ошибка: email должен содержать '@'
except ValueError as e:
    print(f"Ошибка: {e}")
