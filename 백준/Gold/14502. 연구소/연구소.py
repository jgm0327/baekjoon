import sys
from collections import deque


def bfs():
    global lab, n, m, virus_zone, safe_zone_cnt, answer
    que = deque()
    dy, dx = [0, 0, 1, -1], [1, -1, 0, 0]
    visit = [[False] * m for _ in range(n)]
    temp = safe_zone_cnt - 3

    for virus in virus_zone:
        que.append(virus)

    while que:
        cur_y, cur_x = que.popleft()
        for idx in range(4):
            next_y, next_x = cur_y + dy[idx], cur_x + dx[idx]
            if 0 <= next_y < n and 0 <= next_x < m \
                    and lab[next_y][next_x] == 0 and not visit[next_y][next_x]:
                visit[next_y][next_x] = True
                temp -= 1
                if answer >= temp:
                    return
                que.append([next_y, next_x])
    answer = answer if answer > temp else temp


def recur(depth, end):
    global safe_zone, lab, n
    if depth == 3:
        bfs()
        return
    for idx in range(end):
        y, x = safe_zone[idx]
        if lab[y][x] != 0:
            continue
        lab[y][x] = 1
        recur(depth + 1, end)
        lab[y][x] = 0


n, m = map(int, sys.stdin.readline().split())
answer = 0
lab = []
safe_zone = []
safe_zone_cnt = 0
virus_zone = []
for i in range(n):
    input_list = list(map(int, sys.stdin.readline().split()))
    for j in range(m):
        if input_list[j] == 0:
            safe_zone.append([i, j])
            safe_zone_cnt += 1
        elif input_list[j] == 2:
            virus_zone.append([i, j])
    lab.append(input_list)

recur(0, safe_zone_cnt)
print(answer)
