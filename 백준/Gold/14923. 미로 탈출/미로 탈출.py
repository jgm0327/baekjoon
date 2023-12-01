from sys import stdin
from collections import deque

input = stdin.readline

n, m = map(int, input().split())

hy, hx = map(int, input().split())

ey, ex = map(int, input().split())

maze = [[]] + [[0] + list(map(int, input().split())) for _ in range(n)]

def bfs(hy, hx, ey, ex):
    global maze, n, m
    visit = [[[False] * 2 for i in range(m + 1)] for j in range(n + 1)]
    visit[hy][hx][0] = True

    dy, dx = (0,0,1,-1), (1,-1,0,0)

    que = deque()
    que.append((hy, hx, 0, 0))
    
    while que:
        y, x, cnt, use_magic = que.popleft()
        
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]

            if ny == ey and nx == ex:
                return cnt + 1

            
            temp_magic = use_magic

            if ny < 1 or ny > n or nx < 1 or nx > m:
                continue

            data = maze[ny][nx]
            if data == 0 and visit[ny][nx][use_magic]:
                continue

            if data and (visit[ny][nx][1] or use_magic):
                continue

            if data:
                temp_magic = 1

            visit[ny][nx][temp_magic] = True
            que.append((ny, nx, cnt + 1, temp_magic))

    return -1


print(bfs(hy, hx, ey, ex))
