from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())
board = [list(stdin.readline().rstrip()) for _ in range(n)]


def bfs() -> int:
    global board, n, m
    dy, dx = [0,0,-1,1], [1,-1,0,0]
    visit = [[False] * m for _ in range(n)]
    que = deque([[0, 0, 1]])

    while que:
        y, x, cnt = que.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and not visit[ny][nx] and board[ny][nx] == '1':
                visit[ny][nx] = True
                if ny == n - 1 and nx == m - 1:
                    return cnt + 1
                que.append([ny, nx, cnt + 1])

print(bfs())
