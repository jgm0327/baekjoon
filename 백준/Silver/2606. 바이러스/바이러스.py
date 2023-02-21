from sys import stdin
from collections import deque

n = int(stdin.readline())
graph = [[] for _ in range(n + 1)]
for _ in range(int(stdin.readline())):
    sour, des = map(int, stdin.readline().split())
    graph[sour].append(des)
    graph[des].append(sour)


def bfs() -> int:
    global graph, n
    que = deque([1])
    visit = [False] * (n + 1)
    visit[1] = True
    ret = 0
    while que:
        sour = que.popleft()
        for des in graph[sour]:
           if not visit[des]:
               visit[des] = True
               que.append(des)
               ret += 1
    return ret

print(bfs())
