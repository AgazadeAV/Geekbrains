"""
Вы пришли на работу в компанию по разработке игр, целевая аудитория —
дети и их родители. У предыдущего программиста было задание сделать две
игры в одном приложении, чтобы пользователь мог выбирать одну из них.
Однако программист, на место которого вы пришли, перед увольнением не
успел выполнить эту задачу и оставил только небольшой шаблон проекта.
Используя этот шаблон, реализуйте игры «Камень, ножницы, бумага» и «Угадай
число».
Правила игры «Камень, ножницы, бумага»: программа запрашивает у
пользователя строку и выводит, победил он или проиграл. Камень бьёт
ножницы, ножницы режут бумагу, бумага кроет камень.
Правила игры «Угадай число»: программа запрашивает у пользователя число
до тех пор, пока он не отгадает загаданное.
def rock_paper_scissors():
# Здесь будет игра «Камень, ножницы, бумага»
def guess_the_number():
# Здесь будет игра «Угадай число»
def mainMenu():
# Здесь главное меню игры
mainMenu():
pass
"""

import random


def rock_paper_scissors():
    choices = ['камень', 'ножницы', 'бумага']

    while True:
        user_choice = input("Введите 'камень', 'ножницы' или 'бумага' (или 'выход' для завершения): ").lower()
        if user_choice == 'выход':
            print("Завершение игры 'Камень, ножницы, бумага'.")
            break
        if user_choice not in choices:
            print("Некорректный ввод. Попробуйте снова.")
            continue

        computer_choice = random.choice(choices)
        print(f"Компьютер выбрал: {computer_choice}")

        if user_choice == computer_choice:
            print("Ничья!")
        elif (user_choice == 'камень' and computer_choice == 'ножницы') or \
                (user_choice == 'ножницы' and computer_choice == 'бумага') or \
                (user_choice == 'бумага' and computer_choice == 'камень'):
            print("Вы выиграли!")
        else:
            print("Вы проиграли!")


def guess_the_number():
    number_to_guess = random.randint(1, 100)
    attempts = 0

    print("Угадайте число от 1 до 100!")

    while True:
        try:
            user_guess = int(input("Введите ваше число (или 'выход' для завершения): "))
            attempts += 1

            if user_guess < number_to_guess:
                print("Слишком мало! Попробуйте снова.")
            elif user_guess > number_to_guess:
                print("Слишком много! Попробуйте снова.")
            else:
                print(f"Поздравляю! Вы угадали число {number_to_guess} за {attempts} попыток.")
                break
        except ValueError:
            print("Пожалуйста, введите корректное число или 'выход' для завершения.")

        if user_guess == 'выход':
            print("Завершение игры 'Угадай число'.")
            break


def mainMenu():
    while True:
        print("\nГлавное меню:")
        print("1. Камень, ножницы, бумага")
        print("2. Угадай число")
        print("3. Выход")

        choice = input("Выберите игру (1, 2 или 3): ")

        if choice == '1':
            rock_paper_scissors()
        elif choice == '2':
            guess_the_number()
        elif choice == '3':
            print("Спасибо за игру! До свидания!")
            break
        else:
            print("Некорректный выбор. Пожалуйста, выберите 1, 2 или 3.")


# Запуск главного меню
if __name__ == "__main__":
    mainMenu()
