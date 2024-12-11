"""
Напишите скрипт, который получает текущее время и дату, а затем выводит их в
формате YYYY-MM-DD HH:MM:SS. Дополнительно, выведите день недели и номер
недели в году.
"""

import datetime

def get_current_datetime_info():
    # Получение текущего времени и даты
    now = datetime.datetime.now()

    # Форматирование даты и времени в формате YYYY-MM-DD HH:MM:SS
    formatted_datetime = now.strftime("%Y-%m-%d %H:%M:%S")

    # Определение дня недели (понедельник - 0, воскресенье - 6)
    day_of_week = now.strftime("%A")

    # Определение номера недели в году
    week_number = now.strftime("%U")

    # Вывод результата
    print(f"Текущая дата и время: {formatted_datetime}")
    print(f"День недели: {day_of_week}")
    print(f"Номер недели в году: {week_number}")

if __name__ == "__main__":
    get_current_datetime_info()