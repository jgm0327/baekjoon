from collections import deque

n = int(input())

graph = [list(input()) for _ in range(n)]


def bfs(graph, visit, _y, _x):
    global n
    que = deque()
    que.append((_y, _x))
    visit[_y][_x] = True
    dy, dx = [0, 0, 1, -1], [1, -1, 0, 0]

    ret = 0

    while que:
        cy, cx = que.popleft()
        ret += 1
        for i in range(4):
            ny, nx = cy + dy[i], cx + dx[i]
            if 0 > ny or ny >= n or 0 > nx or nx >= n or visit[ny][nx] or graph[ny][nx] == '0':
                continue
            visit[ny][nx] = True
            que.append((ny, nx))

    return str(ret)


answer = []
visit = [[False] * n for _ in range(n)]

for y in range(n):
    for x in range(n):
        if visit[y][x] or graph[y][x] == '0':
            continue
        answer.append(bfs(graph, visit, y, x))

print(len(answer))
print('\n'.join(sorted(answer, key=lambda x: int(x))))
