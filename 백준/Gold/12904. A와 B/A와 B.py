from sys import stdin
from collections import deque

S = list(stdin.readline().rstrip())
T = list(stdin.readline().rstrip())
answer = 0
for _ in range(len(T)):
    if T[-1] == 'A':
        T.pop()
    else:
        T.pop()
        T.reverse()
    if T == S:
        answer = 1
        break
print(answer)
