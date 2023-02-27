from collections import deque
from sys import stdin

n, m, s = map(int, stdin.readline().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    sour, des = map(int, stdin.readline().split())
    graph[sour].append(des)
    graph[des].append(sour)


def bfs(start: int) -> list:
    global graph
    que = deque([start])
    order = ['0'] * (n + 1)
    order[start] = '1'
    cnt = 2
    while que:
        cur = que.popleft()
        for next_ in sorted(graph[cur], reverse=True):
            if order[next_] == '0':
                order[next_] = str(cnt)
                cnt += 1
                que.append(next_)
    return order


print('\n'.join(bfs(s)[1:]))
