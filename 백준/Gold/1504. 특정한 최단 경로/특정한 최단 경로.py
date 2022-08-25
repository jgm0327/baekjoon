import heapq
import sys

n = 0
INF = 2020202020


def dijkstra(graph, start, end):
    global n, INF
    heap = []
    heapq.heappush(heap, [0, start])
    cost = [INF] * (n + 1)
    cost[start] = 0

    while heap:
        cur = heapq.heappop(heap)

        if cost[cur[1]] < cur[0]:
            continue
        for data in graph[cur[1]]:
            des, weight = data[1], data[0]
            if cost[des] > cost[cur[1]] + weight:
                cost[des] = cost[cur[1]] + weight
                heapq.heappush(heap, [weight+cost[cur[1]], des])
    return cost[end]


def solution():
    global n

    n, m = map(int, sys.stdin.readline().split())
    graph = [[] for i in range(n + 1)]
    cost = [0] * 2
    for _ in range(m):
        sour, des, weight = map(int, sys.stdin.readline().split())
        graph[sour].append([weight, des])
        graph[des].append([weight, sour])
    v1, v2 = map(int, sys.stdin.readline().split())

    cost[0] += dijkstra(graph, 1, v1)
    cost[0] += dijkstra(graph, v1, v2)
    cost[0] += dijkstra(graph, v2, n)

    cost[1] += dijkstra(graph, 1, v2)
    cost[1] += dijkstra(graph, v2, v1)
    cost[1] += dijkstra(graph, v1, n)

    Min = min(cost)
    if Min >= INF:
        print(-1)
    else:
        print(Min)


solution()
