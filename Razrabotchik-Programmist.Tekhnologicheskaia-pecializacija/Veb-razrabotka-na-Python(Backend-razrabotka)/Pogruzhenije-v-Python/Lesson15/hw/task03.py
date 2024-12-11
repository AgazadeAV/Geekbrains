"""
Напишите функцию, которая принимает количество дней от текущей даты и
возвращает дату, которая наступит через указанное количество дней. Дополнительно,
выведите эту дату в формате YYYY-MM-DD.
"""

from datetime import datetime, timedelta

def get_future_date(days):
    future_date = datetime.now() + timedelta(days=days)
    return future_date.strftime("%Y-%m-%d")

# Пример использования
if __name__ == "__main__":
    days_to_add = 10  # Замените на нужное количество дней
    future_date = get_future_date(days_to_add)
    print(f"Дата через {days_to_add} дней: {future_date}")
