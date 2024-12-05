"""
Создайте класс студента.
○ Используя дескрипторы проверяйте ФИО на первую заглавную букву и наличие только
букв. Если ФИО не соответствует условию, выведите:
ФИО должно состоять только из букв и начинаться с заглавной буквы
○ Названия предметов должны загружаться из файла CSV при создании экземпляра.
Другие предметы в экземпляре недопустимы. Если такого предмета нет, выведите:
Предмет {Название предмета} не найден
○ Для каждого предмета можно хранить оценки (от 2 до 5) и результаты тестов (от 0 до
100). В противном случае выведите:
Оценка должна быть целым числом от 2 до 5
Результат теста должен быть целым числом от 0 до 100
○ Также экземпляр должен сообщать средний балл по тестам для каждого предмета и по
оценкам всех предметов вместе взятых.
Вам предоставлен файл subjects.csv, содержащий предметы. Сейчас в файл записана
следующая информация.
Математика,Физика,История,Литература
Создайте класс Student, который будет представлять студента и его успехи по
предметам. Класс должен иметь следующие методы:
Атрибуты класса:
name (str): ФИО студента. subjects (dict): Словарь, который хранит предметы в
качестве ключей и информацию об оценках и результатах тестов для каждого предмета в
виде словаря.
Магические методы (Dunder-методы):
__init__(self, name, subjects_file): Конструктор класса. Принимает имя студента
и файл с предметами и их результатами. Инициализирует атрибуты name и subjects и
вызывает метод load_subjects для загрузки предметов из файла.
__setattr__(self, name, value): Дескриптор, который проверяет установку атрибута
name. Убеждается, что name начинается с заглавной буквы и состоит только из букв.
__getattr__(self, name): Позволяет получать значения атрибутов предметов (оценок
и результатов тестов) по их именам.
__str__(self): Возвращает строковое представление студента, включая имя и список
предметов.
Студент: Иван Иванов
Предметы: Математика, История
Методы класса:
load_subjects(self, subjects_file): Загружает предметы из файла CSV.
Использует модуль csv для чтения данных из файла и добавляет предметы в атрибут
subjects.
add_grade(self, subject, grade): Добавляет оценку по заданному предмету.
Убеждается, что оценка является целым числом от 2 до 5.
add_test_score(self, subject, test_score): Добавляет результат теста по
заданному предмету. Убеждается, что результат теста является целым числом от 0 до 100.
get_average_test_score(self, subject): Возвращает средний балл по тестам для
заданного предмета.
get_average_grade(self): Возвращает средний балл по всем предметам.
Пример
На входе:
student = Student("Иван Иванов", "subjects.csv")
student.add_grade("Математика", 4)
student.add_test_score("Математика", 85)
student.add_grade("История", 5)
student.add_test_score("История", 92)
average_grade = student.get_average_grade()
print(f"Средний балл: {average_grade}")
average_test_score = student.get_average_test_score("Математика")
print(f"Средний результат по тестам по математике:
{average_test_score}")
print(student)
На выходе:
Средний балл: 4.5
Средний результат по тестам по математике: 85.0
Студент: Иван Иванов
Предметы: Математика, История
"""

import csv

class NameDescriptor:
    """Дескриптор для проверки ФИО на заглавную букву и наличие только букв."""
    def __set__(self, instance, value):
        if not value.isalpha() or value[0].islower():
            raise ValueError("ФИО должно состоять только из букв и начинаться с заглавной буквы")
        instance.__dict__['name'] = value

class Student:
    name = NameDescriptor()  # Атрибут name с дескриптором

    def __init__(self, name, subjects_file):
        self.name = name  # Используется дескриптор
        self.subjects = {}  # Словарь для хранения предметов и их оценок/результатов
        self.load_subjects(subjects_file)

    def load_subjects(self, subjects_file):
        """Загружает предметы из CSV файла."""
        try:
            with open(subjects_file, newline='', encoding='utf-8') as file:
                reader = csv.reader(file)
                for row in reader:
                    for subject in row:
                        self.subjects[subject] = {'grade': [], 'test_score': []}
        except FileNotFoundError:
            print(f"Файл {subjects_file} не найден.")
        except Exception as e:
            print(f"Ошибка при загрузке предметов: {e}")

    def add_grade(self, subject, grade):
        """Добавляет оценку по заданному предмету."""
        if subject not in self.subjects:
            raise ValueError(f"Предмет {subject} не найден")
        if not (2 <= grade <= 5):
            raise ValueError("Оценка должна быть целым числом от 2 до 5")
        self.subjects[subject]['grade'].append(grade)

    def add_test_score(self, subject, test_score):
        """Добавляет результат теста по заданному предмету."""
        if subject not in self.subjects:
            raise ValueError(f"Предмет {subject} не найден")
        if not (0 <= test_score <= 100):
            raise ValueError("Результат теста должен быть целым числом от 0 до 100")
        self.subjects[subject]['test_score'].append(test_score)

    def get_average_test_score(self, subject):
        """Возвращает средний балл по тестам для заданного предмета."""
        if subject not in self.subjects:
            raise ValueError(f"Предмет {subject} не найден")
        test_scores = self.subjects[subject]['test_score']
        return sum(test_scores) / len(test_scores) if test_scores else 0

    def get_average_grade(self):
        """Возвращает средний балл по всем предметам."""
        total_grade = 0
        total_subjects = 0
        for subject in self.subjects:
            grades = self.subjects[subject]['grade']
            if grades:
                total_grade += sum(grades)
                total_subjects += len(grades)
        return total_grade / total_subjects if total_subjects else 0

    def __str__(self):
        """Возвращает строковое представление студента с его предметами."""
        subjects = ", ".join(self.subjects.keys())
        return f"Студент: {self.name}\nПредметы: {subjects}"

    def __repr__(self):
        """Возвращает строку для создания нового объекта класса с теми же аттрибутами."""
        return f"Student(name='{self.name}', subjects_file='subjects.csv')"

# Пример использования
student = Student("Иван Иванов", "subjects.csv")
student.add_grade("Математика", 4)
student.add_test_score("Математика", 85)
student.add_grade("История", 5)
student.add_test_score("История", 92)

average_grade = student.get_average_grade()
print(f"Средний балл: {average_grade}")

average_test_score = student.get_average_test_score("Математика")
print(f"Средний результат по тестам по математике: {average_test_score}")

print(student)
