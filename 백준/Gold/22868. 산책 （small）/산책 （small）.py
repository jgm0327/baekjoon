import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for sour, des in [map(int, input().split()) for _ in range(m)]:
    graph[sour].append(des)
    graph[des].append(sour)

for i in range(1, n + 1):
    graph[i].sort()

s, e = map(int, input().split())


def bfs(start, end, cnt, v):
    global graph, n

    visit = [False] * (n + 1)
    visit[start] = True

    for i in range(1, n + 1):
        if v & (1 << i) == 0:
            continue
        visit[i] = True
    
    que = deque()
    que.append((start, cnt, v))

    while que:
        sour, cur_cnt, path = que.popleft()

        for des in graph[sour]:
            if des == end:
                return (cur_cnt + 1, path)
            
            if visit[des]:
                continue
            
            visit[des] = True
            que.append((des, cur_cnt + 1, path | (1 << des)))


cnt, v = bfs(s, e, 0, 0)
answer, v = bfs(e, s, cnt, v)

print(answer)
