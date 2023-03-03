n, m = map(int, input().split())
graph = [list(input().rstrip()) for _ in range(n)]
answer = 0
dy, dx = [0,0,-1,1], [1,-1,0,0]
def dfs(y: int, x: int, path: str):
    global n, m, graph, answer, dy, dx
    answer = max(answer, len(path))
    if not(0 <= y < n and 0 <= x < m):
        return
    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]
        if 0 <= ny < n and 0 <= nx < m and graph[ny][nx] not in path:
            dfs(ny, nx, path + graph[ny][nx])
            
    
dfs(0,0,graph[0][0])
print(answer)
