from sys import stdin
from collections import defaultdict

n, d, k, c = map(int, stdin.readline().split())
sushi = [int(stdin.readline()) for _ in range(n)]

start, end = 0, k
eaten = defaultdict(int)
for i in range(k):
    eaten[sushi[i]] += 1

temp = len(eaten.keys())
answer = temp if eaten[c] >= 1 else temp + 1
while start < n:
    eaten[sushi[start]] -= 1
    if eaten[sushi[start]] <= 0:
        eaten.pop(sushi[start])
    start += 1

    eaten[sushi[end]] += 1
    end = (end + 1) % n
    temp = len(eaten.keys())
    temp = temp if eaten.get(c) is not None else temp + 1
    answer = answer if answer > temp else temp
    
print(answer)
