"""
Реализуйте программу - чат, в котором могут участвовать сразу несколько человек, то
есть программа может работать одновременно для нескольких пользователей. При
запуске запрашивается имя пользователя. После этого он выбирает одно из действий:
1. Посмотреть текущий текст чата
2. Отправить сообщение (затем вводит сообщение) Действия запрашиваются
бесконечно.
"""

import threading

# Глобальная переменная для хранения сообщений чата
chat_history = []

# Блокировка для обеспечения синхронного доступа к chat_history
lock = threading.Lock()

def view_chat():
    """Функция для отображения текущего чата."""
    with lock:
        if chat_history:
            print("\nТекущий чат:")
            for message in chat_history:
                print(message)
        else:
            print("\nЧат пуст.")

def send_message(username):
    """Функция для отправки сообщения."""
    message = input(f"Введите сообщение от {username}: ")
    with lock:
        chat_history.append(f"{username}: {message}")
    print(f"Сообщение от {username} отправлено.")

def user_actions(username):
    """Функция для обработки действий пользователя."""
    while True:
        print("\nВыберите действие:")
        print("1. Посмотреть текущий текст чата")
        print("2. Отправить сообщение")
        action = input("Ваш выбор: ")

        if action == "1":
            view_chat()
        elif action == "2":
            send_message(username)
        else:
            print("Некорректный выбор, попробуйте снова.")

def main():
    """Основная функция программы."""
    username = input("Введите ваше имя пользователя: ")
    print(f"Добро пожаловать в чат, {username}!")

    # Запускаем новый поток для каждого пользователя
    user_thread = threading.Thread(target=user_actions, args=(username,))
    user_thread.daemon = True
    user_thread.start()

    # Бесконечный цикл для поддержания работы программы
    while True:
        pass  # Здесь можем поставить условие для выхода из программы (например, обработку Ctrl+C)

if __name__ == "__main__":
    main()
