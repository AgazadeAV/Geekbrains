"""
Напишите класс Library, который управляет книгами. Класс должен поддерживать
следующие методы:
● add_book(title): добавляет книгу в библиотеку.
● remove_book(title): удаляет книгу из библиотеки.
● list_books(): возвращает список всех книг в библиотеке.
При попытке удалить книгу, которая не существует, должно выбрасываться исключение
BookNotFoundError. Для тестирования используйте unitest.
"""


class BookNotFoundError(Exception):
    """Исключение, выбрасываемое при попытке удалить несуществующую книгу."""
    pass


class Library:
    def __init__(self):
        self.books = []  # Список для хранения книг

    def add_book(self, title):
        """Добавляет книгу в библиотеку."""
        self.books.append(title)

    def remove_book(self, title):
        """Удаляет книгу из библиотеки. Если книга не найдена, выбрасывает исключение."""
        if title not in self.books:
            raise BookNotFoundError(f"Книга '{title}' не найдена в библиотеке.")
        self.books.remove(title)

    def list_books(self):
        """Возвращает список всех книг в библиотеке."""
        return self.books


# Тестирование с использованием unittest
import unittest


class TestLibrary(unittest.TestCase):

    def setUp(self):
        """Создаем объект библиотеки для каждого теста."""
        self.library = Library()

    def test_add_book(self):
        """Тестируем добавление книги в библиотеку."""
        self.library.add_book("1984")
        self.assertIn("1984", self.library.list_books())

    def test_remove_book(self):
        """Тестируем удаление книги из библиотеки."""
        self.library.add_book("Brave New World")
        self.library.remove_book("Brave New World")
        self.assertNotIn("Brave New World", self.library.list_books())

    def test_remove_book_not_found(self):
        """Тестируем попытку удалить несуществующую книгу."""
        with self.assertRaises(BookNotFoundError):
            self.library.remove_book("Nonexistent Book")

    def test_list_books(self):
        """Тестируем правильность вывода списка книг."""
        self.library.add_book("The Great Gatsby")
        self.library.add_book("Moby Dick")
        self.assertEqual(self.library.list_books(), ["The Great Gatsby", "Moby Dick"])


if __name__ == "__main__":
    unittest.main()
