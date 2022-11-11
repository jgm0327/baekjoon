import heapq
import sys

input = sys.stdin
n, m = map(int, input.readline().split())
graph = [[] for _ in range(m)]

for i in range(m):
    input_list = input.readline().rstrip()
    for data in input_list:
        graph[i].append(int(data))


def bfs():
    global n, m, graph
    costs = [[int(1e3)] * n for _ in range(m)]
    costs[0][0] = 0
    dy, dx = [0, 0, 1, -1], [1, -1, 0, 0]
    heap = []
    heapq.heappush(heap, [0, 0, 0])

    while heap:
        cnt, y, x = heapq.heappop(heap)
        if cnt > costs[y][x] or (y == m - 1 and x == n - 1):
            continue
        for i in range(4):
            next_y, next_x = y + dy[i], x + dx[i]
            if (0 > next_y or next_y >= m) or (0 > next_x or next_x >= n) or \
                    (graph[y][x] + costs[y][x]) >= costs[next_y][next_x]:
                continue
            costs[next_y][next_x] = costs[y][x] + graph[next_y][next_x]
            heapq.heappush(heap, [costs[next_y][next_x], next_y, next_x])

    return costs[m - 1][n - 1]


print(bfs())
