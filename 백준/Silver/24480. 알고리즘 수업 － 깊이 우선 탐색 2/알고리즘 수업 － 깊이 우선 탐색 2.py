import sys
import heapq

sys.setrecursionlimit(int(1e8))

n, m, s = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    y, x = map(int, sys.stdin.readline().split())
    heapq.heappush(graph[y], -x)
    heapq.heappush(graph[x], -y)

cnt = 0
order = ['0'] * (n + 1)

def dfs(sour: int):
    global graph, cnt, order
    if order[sour] != '0':
        return
    cnt += 1
    order[sour] = str(cnt)
    while graph[sour]:
        des = -heapq.heappop(graph[sour])
        if order[des] == '0':
            dfs(des)

dfs(s)
print('\n'.join(order[1:]))
