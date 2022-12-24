import sys
from collections import deque

input = sys.stdin


def bfs(y: int, x: int) -> None:
    global colors, picture, visit, n
    que = deque()
    que.append([y, x])
    color = colors[picture[y][x]]
    visit[y][x] = True
    dy, dx = [0, 0, -1, 1], [1, -1, 0, 0]

    while que:
        cur_y, cur_x = que.popleft()
        for idx in range(4):
            next_y, next_x = cur_y + dy[idx], cur_x + dx[idx]
            if 0 <= next_y < n and 0 <= next_x < n:
                next_color = colors[picture[next_y][next_x]]
                if not visit[next_y][next_x] and next_color == color:
                    visit[next_y][next_x] = True
                    que.append([next_y, next_x])


n = int(input.readline())
colors = {'R': 1, 'G': 2, 'B': 3}
picture = []
for _ in range(n):
    picture.append(list(input.readline().rstrip()))

answer = [0, 0]
for i in range(2):
    colors['R'] += i
    visit = [[False] * n for _ in range(n)]
    for Y in range(n):
        for X in range(n):
            if visit[Y][X]:
                continue
            bfs(Y, X)
            answer[i] += 1

print(answer[0], answer[1])
