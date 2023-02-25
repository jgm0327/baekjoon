from collections import deque

n, m, k = map(int, input().split())
graph = [[1] * m for _ in range(n)]


for _ in range(k):
    sx, sy, ex, ey = map(int, input().split())
    for y in range(sy, ey):
        for x in range(sx, ex):
            graph[y][x] = 0


visit = [[False] * m for _ in range(n)]
def bfs(y: int, x: int) -> int:
    global graph, n, m, visit
    que = deque([[y,x]])
    visit[y][x] = True
    dy, dx = [0,0,-1,1], [1,-1,0,0]
    ret = 0
    while que:
        cy, cx = que.popleft()
        ret += 1
        for i in range(4):
            ny, nx = cy + dy[i], cx + dx[i]
            if 0 <= ny < n and 0 <= nx < m and not visit[ny][nx] and graph[ny][nx]:
                que.append([ny, nx])
                visit[ny][nx] = True
    return ret


cnt = 0
answer = []
for i in range(n):
    for j in range(m):
        if not visit[i][j] and graph[i][j]:
            answer.append(bfs(i, j))
            cnt += 1

print(cnt)
print(*sorted(answer))
    
