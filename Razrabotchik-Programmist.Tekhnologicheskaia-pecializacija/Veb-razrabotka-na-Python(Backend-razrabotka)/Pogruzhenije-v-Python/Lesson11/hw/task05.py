"""
Вы работаете в компании, занимающейся разработкой программного обеспечения
для архитектурных проектов. Вам необходимо разработать программу для расчёта
площади различных геометрических фигур, таких как круги, прямоугольники и
треугольники.
Задача
Создайте:
● класс Shape, который будет базовым классом для всех фигур и будет
хранить пустой метод area, который наследники должны переопределить;
● класс Circle;
● класс Rectangle;
● класс Triangle.
Классы Circle, Rectangle и Triangle наследуют от класса Shape и реализуют метод
для вычисления площади фигуры.
Дополнительно: изучите информацию о работе с абстрактными классами.
На основе этой информации сделайте так, чтобы:
1. Нельзя было создавать объекты класса Shape.
2. Наследники класса Shape переопределяли его метод area, чтобы объекты
этих классов можно было использовать.
"""

from abc import ABC, abstractmethod
import math

class Shape(ABC):
    """
    Базовый абстрактный класс для всех фигур.
    Невозможно создать объект этого класса напрямую.
    """

    @abstractmethod
    def area(self):
        """Абстрактный метод для вычисления площади фигуры."""
        pass


class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius

    def area(self):
        """Площадь круга: π * r^2"""
        return math.pi * self.radius ** 2


class Rectangle(Shape):
    def __init__(self, width, height):
        self.width = width
        self.height = height

    def area(self):
        """Площадь прямоугольника: ширина * высота"""
        return self.width * self.height


class Triangle(Shape):
    def __init__(self, base, height):
        self.base = base
        self.height = height

    def area(self):
        """Площадь треугольника: 1/2 * основание * высота"""
        return 0.5 * self.base * self.height


# Пример использования

# Создание объектов-наследников
circle = Circle(5)
rectangle = Rectangle(4, 6)
triangle = Triangle(3, 4)

# Вывод площадей
print(f"Площадь круга: {circle.area():.2f}")
print(f"Площадь прямоугольника: {rectangle.area()}")
print(f"Площадь треугольника: {triangle.area()}")

# Попытка создать объект Shape вызовет ошибку
try:
    shape = Shape()  # Ошибка: нельзя создать экземпляр абстрактного класса
except TypeError as e:
    print(f"Ошибка: {e}")
