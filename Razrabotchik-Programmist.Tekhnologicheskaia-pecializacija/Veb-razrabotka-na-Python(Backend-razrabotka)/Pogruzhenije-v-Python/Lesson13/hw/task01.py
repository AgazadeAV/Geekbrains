"""
Один буддист-программист решил создать свой симулятор жизни, в котором
нужно набрать 500 очков кармы (это константа), чтобы достичь просветления.
Каждый день вызывается специальная функция one_day(), которая возвращает
количество кармы от 1 до 7 и может с вероятностью 1 к 10 выкинуть одно из
исключений:
● KillError,
● DrunkError,
● CarCrashError,
● GluttonyError,
● DepressionError.
(Исключения нужно создать самостоятельно, при помощи наследования от
Exception.)
Напишите такую программу. Функцию оберните в бесконечный цикл, выход из
которого возможен только при накоплении кармы до уровня константы.
Исключения обработайте и запишите в отдельный лог karma.log.
По итогу у вас может быть примерно такая структура программы:
открываем файл
цикл по набору кармы
try
карма += one_day()
except(ы) с указанием классов исключений, которые нужно поймать
добавляем запись в файл
закрываем файл
"""

import random
import logging


# Создаем собственные исключения
class KillError(Exception):
    pass


class DrunkError(Exception):
    pass


class CarCrashError(Exception):
    pass


class GluttonyError(Exception):
    pass


class DepressionError(Exception):
    pass


# Функция для получения случайной кармы и возможного выброса исключения
def one_day():
    karma = random.randint(1, 7)

    # Вероятность 1 к 10 для возникновения ошибки
    if random.randint(1, 10) == 1:
        error_choice = random.choice([KillError, DrunkError, CarCrashError, GluttonyError, DepressionError])
        raise error_choice("Произошла ошибка в жизни!")

    return karma


# Настройка логгирования
logging.basicConfig(filename='karma.log', level=logging.ERROR, format='%(asctime)s - %(levelname)s - %(message)s')


# Главная функция симулятора
def simulate_life():
    karma = 0
    target_karma = 500  # Цель по карме

    while karma < target_karma:
        try:
            # Набор кармы за день
            karma += one_day()
            print(f"Карма за день: {karma}")

        except (KillError, DrunkError, CarCrashError, GluttonyError, DepressionError) as e:
            # Логируем ошибку в файл
            logging.error(f"Исключение: {e}")
            print(f"Возникла ошибка: {e}")

    print("Вы достигли просветления!")


# Запуск симуляции
simulate_life()
