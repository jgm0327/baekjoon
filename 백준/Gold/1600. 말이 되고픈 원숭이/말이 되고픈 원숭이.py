from collections import deque

k = int(input())

m, n = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(n)]


def is_in(y, x):
    global n, m
    return 0 <= y < n and 0 <= x < m


def bfs(_board, _k):
    global n, m

    if 0 == n - 1 and 0 == m - 1:
        return 0
    
    que = deque()
    que.append((0, 0, 0, 0)) # (y, x, cnt, horse)
    
    visit = [[[False] * (_k + 1) for j in range(m)] for i in range(n)]
    visit[0][0][0] = True
    
    dy, dx = [0, 0, 1, -1], [1, -1, 0, 0]
    horse_dy, horse_dx = [-1,-2,-2,-1,1,2,2,1], [-2,-1,1,2,2,1,-1,-2]
    
    while que:
        y, x, cnt, horse = que.popleft()

        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            
            if not is_in(ny, nx) or _board[ny][nx] or visit[ny][nx][horse]:
                continue

            if ny == n - 1 and nx == m - 1:
                return cnt + 1
            
            visit[ny][nx][horse] = True
            que.append((ny, nx, cnt + 1, horse))

        if horse == _k:
            continue

        for i in range(8):
            ny, nx = y + horse_dy[i], x + horse_dx[i]

            if not is_in(ny, nx) or visit[ny][nx][horse + 1] or _board[ny][nx]:
                continue

            if ny == n - 1 and nx == m - 1:
                return cnt + 1
            
            visit[ny][nx][horse + 1] = True
            que.append((ny, nx, cnt + 1, horse + 1))
            
    return -1
        

print(bfs(board, k))
    
