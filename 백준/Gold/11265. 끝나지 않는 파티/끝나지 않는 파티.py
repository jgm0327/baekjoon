from sys import stdin
import heapq

n, m = map(int, stdin.readline().split())
parties = [[]] + [[0]+list(map(int, stdin.readline().split())) for _ in range(n)]
INF = int(1e9)
costs = [[INF] * (n + 1) for _ in range(n + 1)]

def shortest_path(sour: int) -> None:
    global costs, parties, n
    heap = [[0, sour]]
    costs[sour][sour] = 0

    while heap:
        cnt, cur = heapq.heappop(heap)
        if cnt > costs[sour][cur]:
            continue
        for des in range(1, n + 1):
            dist = parties[cur][des]
            next_value = dist + cnt
            if dist and costs[sour][des] > next_value:
                costs[sour][des] = next_value
                heapq.heappush(heap, [next_value, des])

for i in range(1, n + 1):
    shortest_path(i)

for _ in range(m):
    sour, des, interval = map(int, stdin.readline().split())
    print('Enjoy other party' \
          if costs[sour][des] <= interval and interval != INF else 'Stay here')
