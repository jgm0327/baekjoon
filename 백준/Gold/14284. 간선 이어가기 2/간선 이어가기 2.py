from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v, cost = map(int, input().split())
    graph[u].append((v, cost))
    graph[v].append((u, cost))

s, t = map(int, input().split())


def dijkstra(_s, _t):
    global graph, n

    heap = []
    
    INF = int(1e9)
    
    costs = [INF] * (n + 1)
    costs[_s] = 0

    heappush(heap, (0, _s))

    while heap:
        cur_cost, sour = heappop(heap)

        if cur_cost > costs[sour]:
            continue

        for des, cost in graph[sour]:
            next_cost = cur_cost + cost

            if next_cost >= costs[des]:
                continue

            costs[des] = next_cost
            
            if _t == des:
                continue
            
            heappush(heap, (next_cost, des))

    return costs[_t]

print(dijkstra(s, t))
