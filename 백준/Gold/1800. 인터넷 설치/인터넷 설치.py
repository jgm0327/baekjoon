from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

n, m, k = map(int, input().split())

cables = [{} for _ in range(n + 1)]

for sour, des, cost in [list(map(int, input().split())) for _ in range(m)]:
    cables[sour][des] = cables[des][sour] = cost


def dijkstra(target_cost):
    global cables, n

    heap = []
    heappush(heap, (0, 1))

    INF = int(1e7)
    costs = [INF] * (n + 1)
    costs[1] = 0

    while heap:
        cost, sour = heappop(heap)

        if cost > costs[sour]:
            continue

        for des in cables[sour].keys():
            next_cost = cost + (cables[sour][des] > target_cost)

            if next_cost >= costs[des]:
                continue

            costs[des] = next_cost
            heappush(heap, (next_cost, des))

    return costs[-1]


left, right = 0, int(1e6)
answer = -1

while left <= right:
    mid = (left + right) // 2

    if dijkstra(mid) <= k:
        right = mid - 1
        answer = mid
    else:
        left = mid + 1
    

print(answer)
    
