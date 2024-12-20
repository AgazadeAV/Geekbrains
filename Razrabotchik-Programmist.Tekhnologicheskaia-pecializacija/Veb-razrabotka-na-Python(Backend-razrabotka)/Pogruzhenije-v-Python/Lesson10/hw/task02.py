"""
Чтобы понять, стоит ли ему жить с кем-то или лучше остаться в гордом
одиночестве, Артём решил провести необычное исследование. Для этого он
реализовал модель человека и модель дома.
Человек может (должны быть такие методы):
● есть (+ сытость, − еда);
● работать (− сытость, + деньги);
● играть (− сытость);
● ходить в магазин за едой (+ еда, − деньги);
● прожить один день (выбирает одно действие согласно описанному ниже
приоритету и выполняет его).
У человека есть (должны быть такие атрибуты):
● имя,
● степень сытости (изначально 50),
● дом.
В доме есть:
● холодильник с едой (изначально 50 еды),
● тумбочка с деньгами (изначально 0 денег).
Если сытость человека становится меньше нуля, человек умирает.
Логика действий человека определяется следующим образом:
1. Генерируется число кубика от 1 до 6.
2. Если сытость < 20, то нужно поесть.
3. Иначе, если еды в доме < 10, то сходить в магазин.
4. Иначе, если денег в доме < 50, то работать.
5. Иначе, если кубик равен 1, то работать.
6. Иначе, если кубик равен 2, то поесть.
7. Иначе играть.
По такой логике эксперимента человеку надо прожить 365 дней.
Реализуйте такую программу и создайте двух людей, живущих в одном доме.
Проверьте работу программы несколько раз.
"""

import random


class House:
    def __init__(self):
        self.food = 50  # Холодильник с едой
        self.money = 0  # Тумбочка с деньгами


class Person:
    def __init__(self, name, house):
        self.name = name
        self.satiety = 50  # Степень сытости
        self.house = house

    def eat(self):
        """Человек ест. Увеличивает сытость и уменьшает еду в холодильнике."""
        if self.house.food > 0:
            self.satiety = min(100, self.satiety + 20)  # Максимум 100 сытости
            self.house.food -= 10
            print(f"{self.name} поел. Сытость: {self.satiety}, еды в холодильнике: {self.house.food}")
        else:
            print(f"{self.name} хочет поесть, но нет еды в холодильнике.")

    def work(self):
        """Человек работает. Уменьшается сытость, увеличиваются деньги."""
        if self.satiety > 0:
            self.satiety -= 10
            self.house.money += 50
            print(f"{self.name} работает. Сытость: {self.satiety}, деньги в тумбочке: {self.house.money}")
        else:
            print(f"{self.name} не может работать, ему нужно поесть!")

    def play(self):
        """Человек играет. Уменьшается сытость, но деньги и еда не изменяются."""
        if self.satiety > 0:
            self.satiety -= 5
            print(f"{self.name} играет. Сытость: {self.satiety}")
        else:
            print(f"{self.name} не может играть, он слишком голоден!")

    def go_to_store(self):
        """Человек идет в магазин за едой. Увеличивается еда, но уменьшаются деньги."""
        if self.house.money >= 50:
            self.house.food += 30
            self.house.money -= 50
            print(
                f"{self.name} пошел в магазин. Еды в холодильнике: {self.house.food}, деньги в тумбочке: {self.house.money}")
        else:
            print(f"{self.name} не может пойти в магазин, у него недостаточно денег.")

    def live_day(self):
        """Человек проживает один день, выбирая действия по приоритету."""
        if self.satiety < 20:
            self.eat()
        elif self.house.food < 10:
            self.go_to_store()
        elif self.house.money < 50:
            self.work()
        else:
            dice_roll = random.randint(1, 6)
            if dice_roll == 1:
                self.work()
            elif dice_roll == 2:
                self.eat()
            else:
                self.play()

        # Проверка на смерть, если сытость меньше 0
        if self.satiety < 0:
            print(f"{self.name} умер!")
            return False  # Человек умирает и день не продолжается
        return True


# Создание дома и двух людей
house = House()

person1 = Person("Артём", house)
person2 = Person("Вася", house)

# Проживание 365 дней
for day in range(365):
    print(f"\nДень {day + 1}:")
    if not person1.live_day():
        print(f"{person1.name} не пережил год.")
        break
    if not person2.live_day():
        print(f"{person2.name} не пережил год.")
        break
