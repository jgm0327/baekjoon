from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())
num_list = deque([data for data in range(1, n + 1)])
answer = []
for _ in range(n):
    for i in range(m - 1):
        data = num_list.popleft()
        num_list.append(data)
    answer.append(str(num_list.popleft()))
    
print('<%s>' % ', '.join(answer))
