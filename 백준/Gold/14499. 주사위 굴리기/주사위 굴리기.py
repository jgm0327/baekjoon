import sys


def go_east():
    global dice, n, m
    right, bottom = dice[1][2], dice[-1][1]
    for j in range(2, 0, -1):
        dice[1][j], dice[1][j - 1] = dice[1][j - 1], dice[1][j]
    dice[1][0], dice[-1][1] = bottom, right


def go_west():
    global dice, n, m
    left, bottom = dice[1][0], dice[-1][1]
    for j in range(2):
        dice[1][j], dice[1][j + 1] = dice[1][j + 1], dice[1][j]
    dice[1][2], dice[-1][1] = bottom, left


def go_north():
    global dice, n, m
    first = dice[0][1]
    for idx in range(3):
        dice[idx + 1][1], dice[idx][1] = dice[idx][1], dice[idx + 1][1]
    dice[-1][1] = first


def go_south():
    global dice, n, m
    last = dice[-1][1]
    for idx in range(3, 0, -1):
        dice[idx - 1][1], dice[idx][1] = dice[idx][1], dice[idx - 1][1]
    dice[0][1] = last


n, m, y, x, k = map(int, sys.stdin.readline().split())
graph = []
dy, dx = [0, 0, -1, 1], [1, -1, 0, 0]
dice = [[-1, 0, -1], [0, 0, 0], [-1, 0, -1], [-1, 0, -1]]

for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

commands = list(map(int, sys.stdin.readline().split()))
for command in commands:
    if ((dy[command - 1] + y) < 0 or (dy[command - 1] + y) >= n) or \
            ((dx[command - 1] + x) < 0 or (dx[command - 1] + x) >= m):
        continue

    if graph[y][x]:
        dice[-1][1] = graph[y][x]
        graph[y][x] = 0
    else:
        graph[y][x] = dice[-1][1]

    y, x = dy[command - 1] + y, dx[command - 1] + x

    if command == 1:
        go_east()
    elif command == 2:
        go_west()
    elif command == 3:
        go_north()
    else:
        go_south()
    print(dice[1][1])
