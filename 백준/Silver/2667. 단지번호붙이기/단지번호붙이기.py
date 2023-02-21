from sys import stdin
from collections import deque

n = int(stdin.readline())
building = [list(stdin.readline().rstrip()) for _ in range(n)]


def bfs(y: int, x: int) -> int:
    global building, visit, n
    dy, dx = [0, 0, -1, 1], [1, -1, 0, 0]
    que = deque([[y, x]])

    cnt = 1
    while que:
        cy, cx = que.popleft()
        for i in range(4):
            ny, nx = cy + dy[i], cx + dx[i]
            if 0 <= ny < n and 0 <= nx < n and not visit[ny][nx] and building[ny][nx] == '1':
                visit[ny][nx] = True
                que.append([ny, nx])
                cnt += 1
    return cnt
    


visit = [[False] * n for _ in range(n)]
answer = []
for i in range(n):
    for j in range(n):
        if not visit[i][j] and building[i][j] == '1':
            visit[i][j] = True
            answer.append(str(bfs(i, j)))

answer.sort(key=lambda x: int(x))
print(len(answer))
print('\n'.join(answer))
