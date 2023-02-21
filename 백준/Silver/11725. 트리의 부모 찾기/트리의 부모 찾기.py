from sys import stdin
from collections import deque

n = int(stdin.readline())
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    sour, des = map(int, stdin.readline().split())
    graph[sour].append(des)
    graph[des].append(sour)


def bfs() -> list:
    global graph, n
    que = deque([1])
    parents = [''] * (n + 1)

    while que:
        sour = que.popleft()
        for des in graph[sour]:
            if parents[des] == '':
                parents[des] = str(sour)
                que.append(des)
    return parents[2:]

print('\n'.join(bfs()), end='')
