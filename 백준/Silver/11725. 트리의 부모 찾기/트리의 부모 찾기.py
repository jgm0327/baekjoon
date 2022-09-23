import sys
from collections import deque

n = int(sys.stdin.readline())

graph = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    sour, des = map(int, sys.stdin.readline().split())
    graph[sour].append(des)
    graph[des].append(sour)


def bfs() -> list:
    global graph, n
    que = deque()
    que.append(1)
    parent_list = [-1] * (n + 1)

    while que:
        parent = que.popleft()

        for child in graph[parent]:
            if parent_list[child] == -1:
                que.append(child)
                parent_list[child] = parent

    return parent_list


answer = bfs()
for data in answer[2:]:
    print(data)