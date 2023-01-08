import sys
from collections import deque

input = sys.stdin


def bfs(y: int, x: int) -> None:
    global graph, visit, n, m
    que = deque()
    dy, dx = [0, -1, -1, -1, 0, 1, 1, 1], [-1, -1, 0, 1, 1, 1, 0, -1]
    visit[y][x] = True
    que.append([y, x])

    while que:
        cur_y, cur_x = que.popleft()
        for i in range(8):
            next_y, next_x = dy[i] + cur_y, dx[i] + cur_x
            if not(0 <= next_y < n) or not(0 <= next_x < m) \
                    or visit[next_y][next_x] or graph[next_y][next_x] == 0:
                continue
            visit[next_y][next_x] = True
            que.append([next_y, next_x])


while True:
    m, n = map(int, input.readline().split())
    if n == m and n == 0:
        break
    graph = []
    visit = [[False] * m for _ in range(n)]
    for _ in range(n):
        graph.append(list(map(int, input.readline().split())))

    answer = 0
    for i in range(n):
        for j in range(m):
            if not visit[i][j] and graph[i][j]:
                bfs(i, j)
                answer += 1
    print(answer)
