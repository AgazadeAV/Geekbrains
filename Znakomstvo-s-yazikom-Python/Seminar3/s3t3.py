"""
Задача №21. Решение в группах
Напишите программу для печати всех уникальных
значений в словаре.
Input: [{"V": "S001"}, {"V": "S002"}, {"VI": "S001"},
{"VI": "S005"}, {"VII": " S005 "}, {" V ":" S009 "}, {" VIII
":" S007 "}]
Output: {'S005', 'S002', 'S007', 'S001', 'S009'}
"""
diсt_1 = [{"V" : "S001"}, {"V" : "S002"}, {"VI" : "S001"}, {"VI" : "S005"}, {"VII" : "S005"}, {"V" : "S009"}, {"VIII" : "S007"}]
set_1 = set()

for i in diсt_1:
    for j in i:
        set_1.add(i[j])
    
print(set_1)

list_dict_1 = [{"V" : "S001"}, {"V" : "S002"}, {"VI" : "S001"}, {"VI" : "S005"}, {"VII" : "S005"}, {"V" : "S009"}, {"VIII" : "S007"}] # список словарей

set_1 = set()
for dict_1 in list_dict_1:
    for value in dict_1.values():
        set_1.add(value)

print(set_1)