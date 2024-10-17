"""
Мальчик загадывает число между 1 и 100 (включительно). Компьютер может
спросить у мальчика: «Твоё число равно, меньше или больше, чем число N?»,
где N — число, которое хочет проверить компьютер. Мальчик отвечает одним из
трёх чисел: 1 — равно, 2 — больше, 3 — меньше.
Напишите программу, которая с помощью цепочки таких вопросов и ответов
мальчика угадывает число.
Дополнительно: сделайте так, чтобы можно было гарантированно угадать
число за семь попыток.
"""

def guess_number():
    low = 1  # нижняя граница
    high = 100  # верхняя граница
    attempts = 0

    print("Загадайте число от 1 до 100. Я попробую его угадать.")

    while low <= high:
        attempts += 1
        mid = (low + high) // 2  # предполагаемое число

        # Компьютер задает вопрос
        print(f"Твоё число равно, меньше или больше, чем {mid}?")
        print("Ответьте: 1 — равно, 2 — больше, 3 — меньше")

        response = int(input("Ваш ответ: "))

        # Обработка ответа
        if response == 1:
            print(f"Я угадал число! Это {mid}. Попыток: {attempts}.")
            break
        elif response == 2:
            low = mid + 1  # число больше, двигаем нижнюю границу
        elif response == 3:
            high = mid - 1  # число меньше, двигаем верхнюю границу
        else:
            print("Некорректный ответ, введите 1, 2 или 3.")

    if low > high:
        print("Ошибка: не удалось угадать число.")


# Запуск программы
guess_number()