from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())
graph = [list(map(int, stdin.readline().rstrip())) for _ in range(n)]


def bfs():
    global graph, n, m
    INF = int(1e9)
    dy, dx = [0,0,-1,1], [1,-1,0,0]
    visit = [[[False, False] for j in range(m)] for i in range(n)]
    que = deque([[0, 0, 1, 0]])

    while que:
        y, x, cnt, broken = que.popleft()
        if y == n - 1 and x == m - 1:
            return cnt
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and not visit[ny][nx][broken]:
                if ny == n - 1 and nx == m - 1:
                    return cnt + 1
                tmp = broken
                if broken and graph[ny][nx]:
                    continue
                if not broken and graph[ny][nx]:
                    tmp = 1
                que.append([ny, nx, cnt + 1, tmp])
                visit[ny][nx][tmp] = True
    return -1
                
    
answer = bfs()
print(answer if answer != int(1e9) else -1)
