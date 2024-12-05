"""
Напишите класс Rectangle, который управляет прямоугольником. Класс должен
поддерживать следующие методы:
● set_dimensions(width, height): устанавливает ширину и высоту
прямоугольника.
● get_area(): возвращает площадь прямоугольника.
● get_perimeter(): возвращает периметр прямоугольника.
Напишите 3 теста с помощью doctest.
"""


class Rectangle:
    def __init__(self, width=0, height=0):
        """
        Инициализирует прямоугольник с заданной шириной и высотой.
        :param width: Ширина прямоугольника
        :param height: Высота прямоугольника
        """
        self.width = width
        self.height = height

    def set_dimensions(self, width, height):
        """
        Устанавливает размеры прямоугольника.

        :param width: Ширина прямоугольника
        :param height: Высота прямоугольника
        """
        self.width = width
        self.height = height

    def get_area(self):
        """
        Возвращает площадь прямоугольника.

        Пример:
        >>> rect = Rectangle(4, 5)
        >>> rect.get_area()
        20
        """
        return self.width * self.height

    def get_perimeter(self):
        """
        Возвращает периметр прямоугольника.

        Пример:
        >>> rect = Rectangle(4, 5)
        >>> rect.get_perimeter()
        18
        """
        return 2 * (self.width + self.height)


# Тестирование с помощью doctest
if __name__ == "__main__":
    import doctest

    doctest.testmod()
