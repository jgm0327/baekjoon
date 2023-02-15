from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())
board = [list(map(int, stdin.readline().split())) for _ in range(n)]
moves = [list(map(int, stdin.readline().split())) for _ in range(m)]

# 구름 이동하는 기능
def is_in(y, x) -> bool:
    global n
    return 0 <= y < n and 0 <= x < n

def move_cloud(dy, dx) -> None:
    global clouds, visit
    N = len(clouds)
    for _ in range(N):
        y, x = clouds.popleft()
        ny = (y + dy) % n if (y + dy) >= 0 else (n + (y + dy)) % n
        nx = (x + dx) % n if (x + dx) >= 0 else (n + (x + dx)) % n
        visit[ny][nx] = True
        clouds.append([ny, nx])

# 물복사 기능
def water_copy():
    global board, dy, dx, clouds
    for y, x in clouds:
        for i in range(2, 9, 2):
            ny, nx = dy[i] + y, dx[i] + x
            if is_in(ny, nx) and board[ny][nx]:
                board[y][x] += 1
    

# 구름 생성 및 물의 양 2 감소
def generate_cloud():
    global visit, clouds
    for i in range(n):
        for j in range(n):
            if board[i][j] >= 2 and not visit[i][j]:
                board[i][j] -= 2
                clouds.append([i, j])


dy, dx = [0] + [0, -1, -1, -1, 0, 1, 1, 1], [0] + [-1, -1, 0, 1, 1, 1, 0, -1]
clouds = deque([[n-1, 0], [n-1, 1], [n-2, 0], [n-2, 1]])
for move, amount in moves:
    visit = [[False] * n for _ in range(n)]
    tmp = [[0] * n for _ in range(n)]
    move_cloud(amount * dy[move], amount * dx[move])
    for y, x in clouds:
        board[y][x] += 1
    water_copy()
    clouds = deque()
    generate_cloud()

answer = 0
for data in board:
    answer += sum(data)
print(answer)



    
    
    
