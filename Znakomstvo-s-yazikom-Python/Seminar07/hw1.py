"""Винни-Пух попросил Вас посмотреть, есть ли в его стихах ритм. Поскольку
разобраться в его кричалках не настолько просто, насколько легко он их придумывает, Вам
стоит написать программу. Винни-Пух считает, что ритм есть, если число слогов (т.е. число
гласных букв) в каждой фразе стихотворения одинаковое. Фраза может состоять из одного
слова, если во фразе несколько слов, то они разделяются дефисами. Фразы отделяются друг
от друга пробелами. Стихотворение Винни-Пух вбивает в программу с клавиатуры. В ответе
напишите “Парам пам-пам”, если с ритмом все в порядке и “Пам парам”, если с ритмом все не
в порядке

Ввод: 
пара-ра-рам рам-пам-папам па-ра-па-дам 

Вывод:
Парам пам-пам
"""


list_1 = input().split()
glasniye = "аеёиоуыэюя"
count_1 = 0
is_true = True
for i in list_1[0]:
  if i in glasniye:
      count_1 += 1
for i in list_1[1:]:
    count_2 = 0
    for y in i:
        if y in glasniye:
            count_2 += 1
    if count_2 != count_1:
        is_true = False
        break

if is_true:
    print('Парам пам-пам')
else:
    print('Пам парам')