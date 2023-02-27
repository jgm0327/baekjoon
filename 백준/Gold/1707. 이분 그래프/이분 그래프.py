from sys import stdin
from collections import deque

T = int(stdin.readline())

def bfs(start: int) -> None:
    global graph, n, colors
    que = deque([start])
    colors[start] = 1
    while que:
        sour = que.popleft()
        for des in graph[sour]:
            if colors[des] == 0:
                que.append(des)
                colors[des] = colors[sour] * -1
            elif colors[des] == colors[sour]:
                return False
    return True



for _ in range(T):
    n, m = map(int, stdin.readline().split())
    graph = [[] for _ in range(n + 1)]
    
    for i in range(m):
        s, d = map(int, stdin.readline().split())
        graph[s].append(d)
        graph[d].append(s)
        
    colors = [0] * (n + 1)
    for i in range(1, n + 1):
        if not colors[i]:
            flag = bfs(i)
        if not flag:
            break
    print('YES' if flag else 'NO')
    
