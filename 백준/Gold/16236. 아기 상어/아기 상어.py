import sys
from collections import deque
import heapq

n = int(sys.stdin.readline())
ocean = []
baby_shark = []

for i in range(n):
    fishes = list(map(int, sys.stdin.readline().split()))
    if 9 in fishes:
        baby_shark = [i, fishes.index(9)]
    ocean.append(fishes)

size = 2
eaten = 0


def is_in(y: int, x: int) -> bool:
    global n
    return 0 <= y < n and 0 <= x < n


def bfs(visit_: list) -> list:
    global ocean, baby_shark, size
    que = deque()
    que.append([baby_shark[0], baby_shark[1], 0])
    distances = []
    dy, dx = [-1, 0, 0, 1], [0, -1, 1, 0]

    visit_[baby_shark[0]][baby_shark[1]] = True
    while que:
        y, x, dis = que.popleft()

        for i in range(4):
            next_y, next_x, next_dis = y + dy[i], x + dx[i], dis + 1
            if is_in(next_y, next_x) and not visit_[next_y][next_x]:
                if 0 <= ocean[next_y][next_x] <= size:
                    visit_[next_y][next_x] = True
                    que.append([next_y, next_x, next_dis])
                if 0 < ocean[next_y][next_x] < size:
                    heapq.heappush(distances, [next_dis, next_y, next_x])
    if distances:
        return distances[0]
    return []


def solution():
    global ocean, baby_shark, eaten, size

    result = 0

    while True:
        visit = [[False] * n for _ in range(n)]
        temp = bfs(visit)
        if not temp:
            break
        result += temp[0]
        eaten += 1
        if eaten == size:
            eaten = 0
            size += 1
        ocean[temp[1]][temp[2]] = 9
        ocean[baby_shark[0]][baby_shark[1]] = 0
        baby_shark = [temp[1], temp[2]]

    print(result)


solution()
