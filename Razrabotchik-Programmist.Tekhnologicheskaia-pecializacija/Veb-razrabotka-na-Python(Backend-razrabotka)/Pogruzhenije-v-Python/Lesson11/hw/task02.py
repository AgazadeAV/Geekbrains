"""
Для одной игры необходимо реализовать механику магии, где при соединении
двух элементов получается новый. У нас есть четыре базовых элемента:
«Вода», «Воздух», «Огонь», «Земля». Из них получаются новые: «Шторм»,
«Пар», «Грязь», «Молния», «Пыль», «Лава».
Таблица преобразований:
● Вода + Воздух = Шторм;
● Вода + Огонь = Пар;
● Вода + Земля = Грязь;
● Воздух + Огонь = Молния;
● Воздух + Земля = Пыль;
● Огонь + Земля = Лава.
Напишите программу, которая реализует все эти элементы. Каждый элемент
необходимо организовать как отдельный класс. Если результат не определён,
то возвращается None.
Примечание: сложение объектов можно реализовывать через магический
метод __add__, вот пример использования:
class ExampleOne:
def __add__(self, other):
return ExampleTwo()
class ExampleTwo:
answer = 'сложили два класса и вывели'
first_example = ExampleOne()
second_example = ExampleTwo()
result = first_example + second_example
print(result.answer)
Дополнительно: придумайте свой элемент (или элементы) и реализуйте его
взаимодействие с остальными.
"""

class Water:
    def __add__(self, other):
        if isinstance(other, Air):
            return Storm()
        elif isinstance(other, Fire):
            return Steam()
        elif isinstance(other, Earth):
            return Mud()
        return None

class Air:
    def __add__(self, other):
        if isinstance(other, Water):
            return Storm()
        elif isinstance(other, Fire):
            return Lightning()
        elif isinstance(other, Earth):
            return Dust()
        return None

class Fire:
    def __add__(self, other):
        if isinstance(other, Water):
            return Steam()
        elif isinstance(other, Air):
            return Lightning()
        elif isinstance(other, Earth):
            return Lava()
        return None

class Earth:
    def __add__(self, other):
        if isinstance(other, Water):
            return Mud()
        elif isinstance(other, Air):
            return Dust()
        elif isinstance(other, Fire):
            return Lava()
        return None

# Новые элементы
class Storm:
    def __str__(self):
        return "Шторм"

class Steam:
    def __str__(self):
        return "Пар"

class Mud:
    def __str__(self):
        return "Грязь"

class Lightning:
    def __str__(self):
        return "Молния"

class Dust:
    def __str__(self):
        return "Пыль"

class Lava:
    def __str__(self):
        return "Лава"

# Дополнительный элемент
class Energy:
    def __add__(self, other):
        if isinstance(other, Fire):
            return Lightning()
        elif isinstance(other, Water):
            return Steam()
        elif isinstance(other, Earth):
            return Lava()
        return None

    def __str__(self):
        return "Энергия"

# Тестирование программы
def test_magic():
    water = Water()
    air = Air()
    fire = Fire()
    earth = Earth()

    # Тестирование базовых комбинаций
    print(water + air)   # Шторм
    print(water + fire)  # Пар
    print(water + earth) # Грязь
    print(air + fire)    # Молния
    print(air + earth)   # Пыль
    print(fire + earth)  # Лава

    # Тестирование дополнительного элемента
    energy = Energy()
    print(energy + fire)  # Молния
    print(energy + water) # Пар
    print(energy + earth) # Лава

    # Тестирование несуществующих комбинаций
    print(water + water)  # None
    print(air + air)      # None

test_magic()
