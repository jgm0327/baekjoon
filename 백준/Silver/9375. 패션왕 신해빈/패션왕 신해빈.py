from sys import stdin
from collections import defaultdict

n = int(stdin.readline())
for _ in range(n):
    a = int(stdin.readline())
    clothes = defaultdict(int)
    for i in range(a):
        name, type_ = stdin.readline().rstrip().split()
        clothes[type_] += 1
    answer = 1
    for key in clothes.keys():
        answer *= (clothes[key] + 1)
    print(answer - 1)
    
    
