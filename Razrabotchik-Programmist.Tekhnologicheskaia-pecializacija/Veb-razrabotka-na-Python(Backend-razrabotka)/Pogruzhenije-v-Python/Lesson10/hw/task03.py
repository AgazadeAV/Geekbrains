"""
Создайте программу, которая реализует игру «Крестики-нолики».
Для этого напишите:
1. Класс, который будет описывать поле игры.
class Board:
# Класс поля, который создаёт у себя экземпляры клетки.
# Пусть класс хранит информацию о состоянии поля (это может быть список из
девяти элементов).
# Помимо этого, класс должен содержать методы:
# «Изменить состояние клетки». Метод получает номер клетки и, если клетка не
занята, меняет её состояние. Если состояние удалось изменить, метод возвращает
True, иначе возвращается False.
# «Проверить окончание игры». Метод не получает входящих данных, но
возвращает True/False. True — если один из игроков победил, False — если
победителя нет.
2. Класс, который будет описывать одну клетку поля:
class Cell:
# Клетка, у которой есть значения:
# занята она или нет;
# номер клетки;
# символ, который клетка хранит (пустая, крестик, нолик).
3. Класс, который описывает поведение игрока:
class Player:
# У игрока может быть:
# имя,
# количество побед.
# Класс должен содержать метод:
# «Сделать ход». Метод ничего не принимает и возвращает ход игрока (номер
клетки). Введённый номер нужно обязательно проверить.
4. Класс, который управляет ходом игры:
class Game:
# класс «Игры» содержит атрибуты:
# состояние игры,
# игроки,
# поле.
# А также методы:
# Метод запуска одного хода игры. Получает одного из игроков, запрашивает у
игрока номер клетки, изменяет поле, проверяет, выиграл ли игрок. Если игрок победил,
возвращает True, иначе False.
# Метод запуска одной игры. Очищает поле, запускает цикл с игрой, который
завершается победой одного из игроков или ничьей. Если игра завершена, метод
возвращает True, иначе False.
# Основной метод запуска игр. В цикле запускает игры, запрашивая после каждой
игры, хотят ли игроки продолжать играть. После каждой игры выводится текущий счёт
игроков.
"""


class Cell:
    def __init__(self, number):
        self.number = number
        self.occupied = False  # Клетка по умолчанию не занята
        self.symbol = None  # Нет символа (пустая клетка)

    def set_symbol(self, symbol):
        if not self.occupied:
            self.symbol = symbol
            self.occupied = True
            return True
        return False

    def __str__(self):
        return self.symbol if self.symbol else str(self.number)


class Board:
    def __init__(self):
        # Создаем 9 клеток, номера клеток от 1 до 9
        self.cells = [Cell(i) for i in range(1, 10)]

    def display(self):
        """Отображает текущее состояние поля"""
        for i in range(3):
            print(" | ".join(str(self.cells[i * 3 + j]) for j in range(3)))
            if i < 2:
                print("---------")

    def change_cell(self, number, symbol):
        """Изменяет состояние клетки, если она не занята"""
        if 1 <= number <= 9:
            return self.cells[number - 1].set_symbol(symbol)
        return False

    def check_winner(self):
        """Проверяет, есть ли победитель"""
        # Проверка строк, столбцов и диагоналей на наличие одинаковых символов
        win_combinations = [
            [0, 1, 2], [3, 4, 5], [6, 7, 8],  # строки
            [0, 3, 6], [1, 4, 7], [2, 5, 8],  # столбцы
            [0, 4, 8], [2, 4, 6]  # диагонали
        ]
        for combination in win_combinations:
            symbols = [self.cells[i].symbol for i in combination]
            if symbols[0] == symbols[1] == symbols[2] and symbols[0] is not None:
                return True
        return False


class Player:
    def __init__(self, name, symbol):
        self.name = name
        self.symbol = symbol
        self.wins = 0

    def make_move(self):
        """Запрашивает у игрока номер клетки"""
        while True:
            try:
                move = int(input(f"{self.name}, выбери клетку (1-9): "))
                if 1 <= move <= 9:
                    return move
                else:
                    print("Неверный номер клетки! Попробуй снова.")
            except ValueError:
                print("Введите число от 1 до 9!")


class Game:
    def __init__(self, player1, player2):
        self.board = Board()
        self.player1 = player1
        self.player2 = player2
        self.current_player = player1

    def play_turn(self):
        """Запускает один ход игры"""
        print("\nТекущее состояние поля:")
        self.board.display()
        move = self.current_player.make_move()
        if self.board.change_cell(move, self.current_player.symbol):
            if self.board.check_winner():
                print(f"\n{self.current_player.name} победил!")
                self.current_player.wins += 1
                return True
            self.switch_player()
        else:
            print("Эта клетка уже занята. Попробуй снова.")
        return False

    def switch_player(self):
        """Меняет текущего игрока"""
        self.current_player = self.player2 if self.current_player == self.player1 else self.player1

    def start_game(self):
        """Запуск одной игры"""
        while True:
            game_over = self.play_turn()
            if game_over:
                break
            if all(cell.occupied for cell in self.board.cells):
                print("\nНичья!")
                break

        print(f"\nТекущий счёт: {self.player1.name} - {self.player1.wins}, {self.player2.name} - {self.player2.wins}")
        return input("Хотите сыграть ещё раз? (да/нет): ").lower() == "да"


def main():
    print("Добро пожаловать в игру Крестики-Нолики!")
    player1_name = input("Имя первого игрока: ")
    player2_name = input("Имя второго игрока: ")

    player1 = Player(player1_name, "X")
    player2 = Player(player2_name, "O")

    while True:
        game = Game(player1, player2)
        if not game.start_game():
            print("Спасибо за игру!")
            break


if __name__ == "__main__":
    main()
