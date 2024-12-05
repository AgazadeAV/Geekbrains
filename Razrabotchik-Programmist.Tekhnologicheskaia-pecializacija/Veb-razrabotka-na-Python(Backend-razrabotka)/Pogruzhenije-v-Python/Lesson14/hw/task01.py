"""
Напишите класс BankAccount, который управляет балансом счета. Он должен
поддерживать следующие методы:
● deposit(amount): добавляет указанную сумму к балансу.
● withdraw(amount): снимает указанную сумму с баланса, если достаточно
средств.
● get_balance(): возвращает текущий баланс счета.
При попытке снять больше средств, чем доступно на счете, должно
выбрасываться исключение InsufficientFundsError. Напишите как минимум
5 тестов для проверки работы классов и его методов.
"""


# Создание пользовательского исключения
class InsufficientFundsError(Exception):
    """Исключение для случая, когда на счете недостаточно средств."""
    pass


class BankAccount:
    def __init__(self, initial_balance=0):
        self.balance = initial_balance

    def deposit(self, amount):
        """Метод для пополнения счета."""
        if amount <= 0:
            raise ValueError("Сумма депозита должна быть положительным числом.")
        self.balance += amount

    def withdraw(self, amount):
        """Метод для снятия средств с баланса."""
        if amount > self.balance:
            raise InsufficientFundsError("На счете недостаточно средств для снятия.")
        if amount <= 0:
            raise ValueError("Сумма снятия должна быть положительным числом.")
        self.balance -= amount

    def get_balance(self):
        """Метод для получения текущего баланса счета."""
        return self.balance

    def __str__(self):
        return f"Текущий баланс: {self.balance}"


# Тесты
def test_bank_account():
    try:
        # Тест 1: Создание счета с начальным балансом
        account = BankAccount(100)
        assert account.get_balance() == 100, "Ошибка: начальный баланс должен быть 100"
        print("Тест 1 пройден.")

        # Тест 2: Пополнение счета
        account.deposit(50)
        assert account.get_balance() == 150, "Ошибка: баланс должен быть 150"
        print("Тест 2 пройден.")

        # Тест 3: Снятие средств
        account.withdraw(30)
        assert account.get_balance() == 120, "Ошибка: баланс должен быть 120"
        print("Тест 3 пройден.")

        # Тест 4: Попытка снять больше средств, чем на счете
        try:
            account.withdraw(200)
        except InsufficientFundsError:
            print("Тест 4 пройден: выброшено исключение InsufficientFundsError.")
        else:
            print("Ошибка: должно быть выброшено исключение InsufficientFundsError.")

        # Тест 5: Пополнение счета с отрицательной суммой
        try:
            account.deposit(-10)
        except ValueError:
            print("Тест 5 пройден: выброшено исключение ValueError.")
        else:
            print("Ошибка: сумма депозита должна быть положительным числом.")

    except AssertionError as e:
        print(f"Ошибка: {e}")


# Запуск тестов
test_bank_account()
