from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())
num_list = [data for data in range(1, n+1)]

idx = 0
answer = []
for _ in range(n):
    idx = (idx + m - 1) % n
    answer.append(str(num_list.pop(idx)))
    n -= 1
print('<%s>' % ', '.join(answer))
