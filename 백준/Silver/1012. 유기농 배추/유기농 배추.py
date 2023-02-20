from sys import stdin
from collections import deque

T = int(stdin.readline())


def bfs(y: int, x: int) -> None:
    global board, visit, n, m
    que = deque([[y, x]])
    dy, dx = [0,0,1,-1], [1,-1,0,0]
    
    while que:
        cy, cx = que.popleft()
        for idx in range(4):
            ny, nx = cy + dy[idx], cx + dx[idx]
            if 0 <= ny < n and 0 <= nx < m and not visit[ny][nx] and board[ny][nx]:
                visit[ny][nx] = True
                que.append([ny, nx])

for _ in range(T):
    n, m, k = map(int, stdin.readline().split())
    board = [[0] * m for i in range(n)]
    visit = [[False] * m for i in range(n)]
    
    for i in range(k):
        y, x = map(int, stdin.readline().split())
        board[y][x] = 1

    answer = 0
    for y in range(n):
        for x in range(m):
            if not visit[y][x] and board[y][x]:
                visit[y][x] = True
                bfs(y, x)
                answer += 1
    print(answer)
    