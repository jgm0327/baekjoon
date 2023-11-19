from sys import stdin
from collections import deque

n, m, v = map(int, stdin.readline().split())
graph = [[0] * (n + 1) for _ in range(n + 1)]
for _ in range(m):
    sour, des = map(int, stdin.readline().split())
    graph[sour][des] = graph[des][sour] = 1

def bfs(start: int) -> None:
    global graph, n
    visit = [False] * (n + 1)
    visit[start] = True
    que = deque([start])

    print()
    while que:
        sour = que.popleft()
        print(sour, end=' ')
        for des in range(1, n + 1):
            if not visit[des] and graph[sour][des]:
                visit[des] = True
                que.append(des)

def dfs(sour: int) -> None:
    global graph,  n, visit
    if visit[sour]:
        return
    print(sour, end=' ')
    visit[sour] = True
    for des in range(1, n + 1):
        if not visit[des] and graph[sour][des]:
            dfs(des)



visit = [False] * (n + 1)
dfs(v)
bfs(v)
