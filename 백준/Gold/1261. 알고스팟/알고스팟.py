import sys
from collections import deque

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
    que = deque()
    que.append([0, 0, 0])

    while que:
        y, x, cnt = que.popleft()
        if cnt > costs[y][x] or (y == m - 1 and x == n - 1):
            continue
        for i in range(4):
            next_y, next_x = y + dy[i], x + dx[i]
            if (0 > next_y or next_y >= m) or (0 > next_x or next_x >= n):
                continue
            if graph[next_y][next_x] and costs[next_y][next_x] > 1 + costs[y][x]:
                costs[next_y][next_x] = costs[y][x] + 1
                que.append([next_y, next_x, costs[next_y][next_x]])
            elif not graph[next_y][next_x] and costs[next_y][next_x] >= 1 + costs[y][x]:
                costs[next_y][next_x] = costs[y][x]
                que.append([next_y, next_x, costs[next_y][next_x]])

    return costs[m - 1][n - 1]


print(bfs())
