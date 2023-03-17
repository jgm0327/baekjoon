from collections import deque

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
zero = []
virus = []
cnt = answer = -3

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            cnt += 1
            zero.append([i, j])
        elif graph[i][j] == 2:
            virus.append([i, j])


def bfs():
    global graph, n, m, virus, cnt, answer
    que = deque()
    for pos in virus:
        que.append(pos)
    visit = [[False] * m for _ in range(n)]
    visit[que[0][0]][que[0][1]] = True
    dy, dx = [1, -1, 0, 0], [0, 0, 1, -1]
    tmp = cnt
    
    while que and tmp:
        y, x = que.popleft()
        for i in range(4):
            ny, nx = dy[i] + y, dx[i] + x
            if 0 <= ny < n and 0 <= nx < m and not visit[ny][nx] and graph[ny][nx] == 0:
                que.append([ny, nx])
                visit[ny][nx] = True
                tmp -= 1
                if tmp <= answer:
                    return
    answer = tmp
    
    

def recur(depth):
    global graph, zero
    if depth == 3:
        bfs()
        return
    for y, x in zero:
        if graph[y][x] == 0:
            graph[y][x] = 1
            recur(depth+1)
            graph[y][x] = 0


recur(0)
print(answer)
