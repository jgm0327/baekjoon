from sys import stdin
import heapq

n, m = map(int, stdin.readline().split())
start = int(stdin.readline())
graph = [[] for _ in range(n + 1)]
INF = int(1e9)

for _ in range(m):
    sour, des, dist = map(int, stdin.readline().split())
    graph[sour].append([des, dist])


def shortest_path():
    global start, n, graph, INF
    costs = [INF] * (n + 1)
    costs[start] = 0
    heap = [[0, start]]

    while heap:
        cnt, cur = heapq.heappop(heap)
        if cnt > costs[cur]:
            continue

        for des, cost in graph[cur]:
            next_value = cost + cnt
            if costs[des] > next_value:
                costs[des] = next_value
                heapq.heappush(heap, [next_value, des])
    return costs

for cost in shortest_path()[1:]:
    print(cost if INF != cost else 'INF')
