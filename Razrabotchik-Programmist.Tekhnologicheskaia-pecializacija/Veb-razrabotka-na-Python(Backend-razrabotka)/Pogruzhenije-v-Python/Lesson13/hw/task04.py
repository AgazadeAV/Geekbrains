"""
Создайте класс GameScore для отслеживания очков игрока. В этом классе
должны быть методы для добавления и уменьшения очков. Однако:
● Очки не могут быть отрицательными.
● Если игрок пытается добавить больше очков, чем 1000, должно быть
выброшено исключение ScoreLimitExceededError.
Создайте пользовательское исключение ScoreLimitExceededError.
"""


# Создаем пользовательское исключение
class ScoreLimitExceededError(Exception):
    """Исключение, выбрасываемое при превышении лимита очков."""
    pass


class GameScore:
    def __init__(self):
        self.score = 0  # Изначально очки равны 0

    def add_score(self, points):
        """Добавить очки."""
        if self.score + points > 1000:
            raise ScoreLimitExceededError("Попытка добавить очки, превышающие лимит 1000!")
        if points < 0:
            raise ValueError("Нельзя добавить отрицательное количество очков.")
        self.score += points

    def subtract_score(self, points):
        """Уменьшить очки."""
        if self.score - points < 0:
            self.score = 0  # Очки не могут быть отрицательными
        else:
            self.score -= points

    def get_score(self):
        """Получить текущее количество очков."""
        return self.score

    def __str__(self):
        return f"Текущие очки: {self.score}"


# Пример использования
try:
    game = GameScore()

    # Добавляем очки
    game.add_score(500)
    print(game)  # Ожидаем: Текущие очки: 500

    # Добавляем ещё 600 очков, что приведет к ошибке
    game.add_score(600)  # Здесь выбросится исключение ScoreLimitExceededError
except ScoreLimitExceededError as e:
    print(f"Ошибка: {e}")

# Уменьшаем очки
game.subtract_score(200)
print(game)  # Ожидаем: Текущие очки: 300

# Попытка добавить отрицательные очки
try:
    game.add_score(-100)  # Это вызовет ошибку ValueError
except ValueError as e:
    print(f"Ошибка: {e}")
