k = 'ноутбук'
points = {
    1 : 'aeioulnstравеинорст',
    2 : 'dgдклмпу',
    3 : 'bcmpбгёья',
    4 : 'fhvwйы',
    5 : 'kжзхцч',
    8 : 'jxшэю',
    10 : 'qzфщъ'
}

point = 0
for key, value in points.items():
    for i in range(len(k)):
        if k[i].lower() in value:
            point += key
            
print(point)