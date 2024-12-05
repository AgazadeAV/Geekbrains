"""
Создайте класс Book, который создает экземпляры с помощью __new__. Убедитесь,
что каждый экземпляр имеет уникальный идентификатор.
"""


class Book:
    def __new__(cls, *args, **kwargs):
        # Создаем новый экземпляр класса
        instance = super().__new__(cls)

        # Присваиваем уникальный идентификатор экземпляру
        instance.id = id(instance)

        return instance

    def __init__(self, title, author):
        self.title = title
        self.author = author

    def __str__(self):
        return f"Book ID: {self.id}, Title: {self.title}, Author: {self.author}"


# Пример использования
book1 = Book("1984", "George Orwell")
book2 = Book("To Kill a Mockingbird", "Harper Lee")

print(book1)  # Выводит уникальный ID, название и автора книги
print(book2)  # Выводит уникальный ID, название и автора книги
