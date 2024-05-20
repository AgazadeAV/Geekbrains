# Хакер Василий получил доступ к классному журналу и
# хочет заменить все свои минимальные оценки на
# максимальные. Напишите программу, которая
# заменяет оценки Василия, но наоборот: все
# максимальные – на минимальные.
# Input: 5 -> 1 3 3 3 4
# Output: 1 3 3 3 1

# def max_to_min(otsenki):
#     temp_max_ind = 0
#     list_max_ind = [0]
#     min = otsenki[0]
#     for i in range(1,len(otsenki)):
#         if otsenki[i] > otsenki[temp_max_ind]:
#             temp_max_ind = i
#             list_max_ind.clear()
#             list_max_ind.append(temp_max_ind)
#         elif otsenki[i] == otsenki[temp_max_ind]:
#             list_max_ind.append(i)
#         elif otsenki[i] < min:
#             min = otsenki[i]
#     for i in list_max_ind:
#         otsenki[i] = min
#     return otsenki

# otsenki = [int(i) for i in input().split()]
# print(*max_to_min(otsenki))

# def change_grades(grades):
#     max_grade = max(grades)
#     min_grade = min(grades)
#     return [min_grade if grade == max_grade else grade for grade in grades]

# grades = list(map(int, input().split()))
# print(*change_grades(grades))

# def change_scores(scores, index=0):
#     if index < len(scores):
#         if scores[index] == max_score:
#             scores[index] = min_score
#         change_scores(scores, index + 1)

# scores = list(map(int, input().split()))
# max_score = max(scores)
# min_score = min(scores)
# change_scores(scores)
# print(*scores)

# Хакер Василий получил доступ к классному журналу и
# хочет заменить все свои минимальные оценки на
# максимальные. Напишите программу, которая
# заменяет оценки Василия, но наоборот: все
# максимальные – на минимальные.
# Input: 5 -> 1 3 3 3 4
# Output: 1 3 3 3 1

scores = [1, 3, 3, 3, 4]

def change_scores(scores, index=0, max_score=max(scores), min_score=min(scores)):
    if index < len(scores):
        if scores[index] == max_score:
            scores[index] = min_score
        change_scores(scores, index + 1)
    return scores

print(*change_scores(scores))
