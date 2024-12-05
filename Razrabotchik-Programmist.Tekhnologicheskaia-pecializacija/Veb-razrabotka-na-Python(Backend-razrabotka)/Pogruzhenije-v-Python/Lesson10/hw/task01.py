"""
Вася совсем заскучал на работе и решил побаловаться с кодом проекта. Он
Реализуйте два класса: «Родитель» и «Ребёнок». У родителя есть:
● имя,
● возраст,
● список детей.
И он может:
● сообщить информацию о себе,
● успокоить ребёнка,
● покормить ребёнка.
У ребёнка есть:
● имя,
● возраст (должен быть меньше возраста родителя хотя бы на 16 лет),
● состояние спокойствия,
● состояние голода.
Реализация состояний — на ваше усмотрение. Это может быть и простой «флаг»,
и словарь состояний, и что-то поинтереснее.
"""


class Child:
    def __init__(self, name, age):
        self.name = name
        self.age = age
        self.peaceful = False  # Статус спокойствия
        self.hungry = True  # Статус голода (по умолчанию ребёнок голоден)

    def calm_down(self):
        """Успокаивает ребёнка."""
        self.peaceful = True
        print(f"{self.name} успокоен.")

    def feed(self):
        """Кормит ребёнка."""
        self.hungry = False
        print(f"{self.name} накормлен.")

    def __str__(self):
        """Возвращает информацию о ребёнке."""
        return f"Ребёнок: {self.name}, возраст: {self.age}, спокойствие: {'спокоен' if self.peaceful else 'нервничает'}, голод: {'есть' if not self.hungry else 'голоден'}"


class Parent:
    def __init__(self, name, age):
        self.name = name
        self.age = age
        self.children = []  # Список детей

    def add_child(self, child):
        """Добавляет ребёнка в список детей."""
        if child.age < self.age - 16:
            self.children.append(child)
        else:
            print(f"Ребёнок {child.name} слишком стар для этого родителя!")

    def show_info(self):
        """Сообщает информацию о родителе."""
        print(f"Родитель: {self.name}, возраст: {self.age}")
        if self.children:
            print("Дети:")
            for child in self.children:
                print(f" - {child}")
        else:
            print("Нет детей.")

    def calm_child(self, child):
        """Успокаивает ребёнка."""
        if child in self.children:
            child.calm_down()
        else:
            print(f"{child.name} не является моим ребёнком.")

    def feed_child(self, child):
        """Кормит ребёнка."""
        if child in self.children:
            child.feed()
        else:
            print(f"{child.name} не является моим ребёнком.")


# Пример использования
parent = Parent("Иван", 40)

child1 = Child("Анна", 5)
child2 = Child("Сергей", 15)

parent.add_child(child1)
parent.add_child(child2)

parent.show_info()

parent.calm_child(child1)
parent.feed_child(child1)

parent.show_info()
