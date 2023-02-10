from sys import stdin
import heapq

n, m, k, X = map(int, stdin.readline().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    sour, des = map(int, stdin.readline().split())
    graph[sour].append(des)


def dikjstra(x):
    global n, m, k, graph
    costs = [int(1e9)] * (n + 1)
    costs[x] = 0
    heap = [[0, x]]
    ret = []
    while heap:
        cnt, cur = heapq.heappop(heap)
        if cnt > costs[cur]:
            continue
        for des in graph[cur]:
            value = cnt + 1
            if costs[des] > value:
                costs[des] = value
                if value == k:
                    heapq.heappush(ret, des)
                heapq.heappush(heap, [value, des])
    return ret

answer = dikjstra(X)
print(-1 if not answer else '', end='')
while answer:
    print(answer[0])
    heapq.heappop(answer)
