"""
Создайте модуль и напишите в нём функцию, которая получает на вход дату в
формате DD.MM.YYYY Функция возвращает истину, если дата может существовать
или ложь, если такая дата невозможна. Для простоты договоримся, что год
может быть в диапазоне [1, 9999]. Весь период (1 января 1 года - 31 декабря 9999
года) действует Григорианский календарь. Проверку года на високосность
вынести в отдельную защищённую функцию.
"""


def is_leap_year(year):
    """
    Защищенная функция для проверки, является ли год високосным.

    :param year: Год
    :return: True, если год високосный, иначе False
    """
    return year % 4 == 0 and (year % 100 != 0 or year % 400 == 0)


def is_valid_date(date_str):
    """
    Функция получает дату в формате DD.MM.YYYY и возвращает True, если
    дата может существовать, иначе возвращает False.

    :param date_str: Строка с датой в формате DD.MM.YYYY
    :return: True, если дата существует, иначе False
    """
    try:
        day, month, year = map(int, date_str.split('.'))
    except ValueError:
        return False  # Если не удается распарсить строку, дата недействительна

    # Проверяем диапазоны значений
    if year < 1 or year > 9999 or month < 1 or month > 12 or day < 1:
        return False

    # Определяем количество дней в месяце
    days_in_month = [31, 29 if is_leap_year(year) else 28, 31, 30, 31, 30,
                     31, 31, 30, 31, 30, 31]

    return day <= days_in_month[month - 1]


# Пример использования
if __name__ == "__main__":
    date_example = "29.02.2024"  # Високосный год
    print(is_valid_date(date_example))  # Вывод: True

    date_example_invalid = "31.04.2023"  # Неверная дата
    print(is_valid_date(date_example_invalid))  # Вывод: False
