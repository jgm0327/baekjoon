from collections import deque
from sys import stdin

n, m = map(int, stdin.readline().split())
ladders = {}
snakes = {}
for _ in range(n):
    s, d = map(int, stdin.readline().split())
    ladders[s] = d

max_v = 0
for _ in range(m):
    s, d = map(int, stdin.readline().split())
    snakes[s] = d


def bfs():
    global ladders, snakes
    dx = [1, 2, 3, 4, 5, 6]
    que = deque([[1, 0]])
    visit = {}
    while que:
        x, cnt = que.popleft()
        for i in range(6):
            nx = x + dx[i]
            if nx == 100:
                return cnt + 1
            if ladders.get(nx) is not None:
                visit[nx] = True
                nx = ladders[nx]
            if snakes.get(nx) is not None:
                visit[nx] = True
                nx = snakes[nx]
            if nx == 100:
                return cnt + 1
            if visit.get(nx) is None:
                visit[nx] = True
                que.append([nx, cnt + 1])


print(bfs())