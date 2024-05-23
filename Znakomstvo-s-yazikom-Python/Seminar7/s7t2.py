def find_farthest_orbit(orbits):
#    res_1 = [(k, v) for (k, v) in orbits if k != v]
    orbits = list(filter(lambda x: x[0] != x[1], orbits))
    max = orbits[0]
    for (k, v) in orbits:
        if k*v > max[0] * max[1]:
            max = (k, v)
    return max
    

orbits = [(1, 3), (2.5, 10), (7, 2), (6, 6), (4, 3)]
print(*find_farthest_orbit(orbits))
