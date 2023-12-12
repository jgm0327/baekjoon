import sys
from heapq import heappush, heappop

input = sys.stdin.readline

n = int(input())
m = int(input())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    sour, des, cost = map(int, input().split())

    graph[sour].append((des, cost))

s, e = map(int, input().split())


def dijkstra(start, end):
    global graph, n

    path = [0] * (n + 1)

    heap = []
    heappush(heap, (0, start))

    INF = int(1e8)
    costs = [INF] * (n + 1)
    costs[start] = 0

    while heap:
        cur_cost, sour = heappop(heap)

        if cur_cost > costs[sour]:
            continue

        for des, cost in graph[sour]:
            next_cost = cost + cur_cost

            if next_cost >= costs[des]:
                continue

            costs[des] = next_cost
            path[des] = sour

            if des == end:
                continue
            
            heappush(heap, (next_cost, des))

    return (costs[end], path)


dist, answer_path = dijkstra(s, e)

sour = e
path = [str(e)]
while sour != s:
    des = answer_path[sour]
    sour = des
    path.append(str(sour))

print(dist)
print(len(path))
print(' '.join(path[::-1]))
        
 