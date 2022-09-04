import sys
from queue import Queue


def isIn(cur_y, cur_x):
    global n, m
    return 1 <= cur_y <= n and 1 <= cur_x <= m


def bfs(start_y, start_x):
    global graph, n, m, visit
    dy, dx = [0, 0, 1, -1], [-1, 1, 0, 0]
    que = Queue()
    que.put([start_y, start_x])
    cnt = 0

    while not que.empty():
        cur = que.get()
        cnt += 1
        visit[start_y][start_x] = True
        for i in range(4):
            nextY, nextX = cur[0] + dy[i], cur[1] + dx[i]
            if isIn(nextY, nextX) and not visit[nextY][nextX]:
                if graph[nextY][nextX]:
                    que.put([nextY, nextX])
                    graph[nextY][nextX] = 0
    return cnt


n, m, e = map(int, sys.stdin.readline().split())
graph = [[0 for i in range(m + 1)] for j in range(n + 1)]
visit = [[False for i in range(m + 1)] for j in range(n + 1)]
Max = 0

for _ in range(e):
    a, b = map(int, sys.stdin.readline().split())
    graph[a][b] = 1

for i in range(1, n+1):
    for j in range(1, m+1):
        if graph[i][j]:
            visit = [[False for i in range(m + 1)] for j in range(n + 1)]
            count = bfs(i, j)
            Max = count if count > Max else Max
print(Max)
