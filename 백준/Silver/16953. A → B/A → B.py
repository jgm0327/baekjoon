from sys import stdin
from collections import deque

sour, des = map(int, stdin.readline().split())

def bfs():
    global sour, des
    numbers = deque()
    numbers.append([sour, 1])

    while numbers:
        cur, cnt = numbers.popleft()
        t1, t2 = cur * 2, cur * 10 + 1
        if t1 == des or t2 == des:
            return cnt + 1
        if t1 < des:
            numbers.append([t1, cnt + 1])
        if t2 < des:
            numbers.append([t2, cnt + 1])
    return -1

print(bfs())
