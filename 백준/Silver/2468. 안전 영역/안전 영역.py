import sys
from collections import deque


def bfs(y, x, height):
    global n, buildings, visit
    que = deque()
    que.append([y, x])
    dy, dx = [0, 0, -1, 1], [1, -1, 0, 0]
    visit[y][x] = True
    while que:
        cur_y, cur_x = que.popleft()
        for i in range(4):
            next_y, next_x = dy[i] + cur_y, dx[i] + cur_x
            if 0 <= next_y < n and 0 <= next_x < n \
                    and not visit[next_y][next_x] and height < buildings[next_y][next_x]:
                visit[next_y][next_x] = True
                que.append([next_y, next_x])


def counting_area(height):
    global buildings, n, visit, answer
    cnt = 0
    for i in range(n):
        for j in range(n):
            if not visit[i][j] and buildings[i][j] > height:
                bfs(i, j, height)
                cnt += 1
    answer = answer if answer > cnt else cnt


n = int(sys.stdin.readline())
buildings = []
max_height = 0
answer = 0

for _ in range(n):
    input_list = list(map(int, sys.stdin.readline().split()))
    comp_height = max(input_list)
    max_height = max_height if max_height > comp_height else comp_height
    buildings.append(input_list)

for h in range(max_height):
    visit = [[False] * n for _ in range(n)]
    counting_area(h)

print(answer)
