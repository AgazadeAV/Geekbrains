"""
Создайте базовый класс Animal, который имеет атрибут name, представляющий имя
животного.
Создайте классы Bird, Fish и Mammal, которые наследуются от базового класса Animal и
добавляют дополнительные атрибуты и методы:
Bird имеет атрибут wingspan (размах крыльев) и метод wing_length, который
возвращает длину крыла птицы.
Fish имеет атрибут max_depth (максимальная глубина обитания) и метод depth, который
возвращает категорию глубины рыбы (мелководная, средневодная, глубоководная) в
зависимости от значения max_depth.
Если максимальная глубина обитания рыбы (max_depth) меньше 10, то она относится к
категории "Мелководная рыба".
Если максимальная глубина обитания рыбы больше 100, то она относится к категории
"Глубоководная рыба".
В противном случае, рыба относится к категории "Средневодная рыба".
Mammal имеет атрибут weight (вес) и метод category, который возвращает категорию
млекопитающего (Малявка, Обычный, Гигант) в зависимости от веса. Если вес объекта
меньше 1, то он относится к категории "Малявка".
Если вес объекта больше 200, то он относится к категории "Гигант".
В противном случае, объект относится к категории "Обычный".
Создайте класс-фабрику AnimalFactory, который будет создавать экземпляры животных
разных типов на основе переданного типа и параметров. Класс-фабрика должен иметь
метод create_animal, который принимает следующие аргументы:
animal_type (строка) - тип животного (один из: 'Bird', 'Fish', 'Mammal').
*args - переменное количество аргументов, представляющих параметры для конкретного
типа животного. Количество и типы аргументов могут различаться в зависимости от типа
животного.
Метод create_animal должен создавать и возвращать экземпляр животного заданного
типа с переданными параметрами.
Если animal_type не соответствует 'Bird', 'Fish' или 'Mammal', функция вызовет ValueError с
сообщением 'Недопустимый тип животного'.
"""

class Animal:
    def __init__(self, name):
        self.name = name

    def __str__(self):
        return f"Животное: {self.name}"

class Bird(Animal):
    def __init__(self, name, wingspan):
        super().__init__(name)
        self.wingspan = wingspan

    def wing_length(self):
        return self.wingspan / 2

    def __str__(self):
        return f"Птица: {self.name}, Размах крыльев: {self.wingspan} м, Длина крыла: {self.wing_length()} м"

class Fish(Animal):
    def __init__(self, name, max_depth):
        super().__init__(name)
        self.max_depth = max_depth

    def depth(self):
        if self.max_depth < 10:
            return "Мелководная рыба"
        elif self.max_depth > 100:
            return "Глубоководная рыба"
        else:
            return "Средневодная рыба"

    def __str__(self):
        return f"Рыба: {self.name}, Максимальная глубина: {self.max_depth} м, Категория: {self.depth()}"

class Mammal(Animal):
    def __init__(self, name, weight):
        super().__init__(name)
        self.weight = weight

    def category(self):
        if self.weight < 1:
            return "Малявка"
        elif self.weight > 200:
            return "Гигант"
        else:
            return "Обычный"

    def __str__(self):
        return f"Млекопитающее: {self.name}, Вес: {self.weight} кг, Категория: {self.category()}"

class AnimalFactory:
    @staticmethod
    def create_animal(animal_type, *args):
        if animal_type == 'Bird':
            if len(args) != 2:
                raise ValueError("Для птицы нужны два аргумента: имя и размах крыльев.")
            return Bird(*args)
        elif animal_type == 'Fish':
            if len(args) != 2:
                raise ValueError("Для рыбы нужны два аргумента: имя и максимальная глубина.")
            return Fish(*args)
        elif animal_type == 'Mammal':
            if len(args) != 2:
                raise ValueError("Для млекопитающего нужны два аргумента: имя и вес.")
            return Mammal(*args)
        else:
            raise ValueError("Недопустимый тип животного")

# Пример использования:
try:
    # Создаём животных через фабрику
    bird = AnimalFactory.create_animal('Bird', 'Орёл', 2.5)
    fish = AnimalFactory.create_animal('Fish', 'Акула', 150)
    mammal = AnimalFactory.create_animal('Mammal', 'Слон', 6000)

    # Выводим информацию о животных
    print(bird)
    print(fish)
    print(mammal)

except ValueError as e:
    print(e)
