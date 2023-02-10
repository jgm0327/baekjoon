from sys import stdin
import heapq


n, k, m = map(int, stdin.readline().split())
items = [0] + list(map(int, stdin.readline().split()))
graph = [[] for _ in range(n + 1)]
INF = int(1e9)
answer = 0

for _ in range(m):
    sour, des, dist = map(int, stdin.readline().split())
    graph[sour].append([des, dist])
    graph[des].append([sour, dist])


def shortest_path(start: int) -> list:
    global items, graph, k, n, INF
    ret = [INF] * (n + 1)
    ret[start] = 0
    heap = [[0, start]]

    while heap:
        cnt, cur = heapq.heappop(heap)
        if cnt > ret[cur]:
            continue
        for des, cost in graph[cur]:
            next_value = cnt + cost
            if next_value < ret[des]:
                ret[des] = next_value
                heapq.heappush(heap, [next_value, des])
    return ret

    
for s in range(1, n + 1):
    costs = shortest_path(s)
    total = 0
    for idx, cost in enumerate(costs):
        if cost <= k:
            total += items[idx]
    answer = answer if answer > total else total
print(answer)
