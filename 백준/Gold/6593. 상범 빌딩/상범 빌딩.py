import sys
from queue import Queue


def is_wall(point, z, y, x):
    if point[z][y][x] == '#':
        return True
    return False


def is_in(z, y, x):
    global L, R, C
    if 0 <= z < L and 0 <= y < R and 0 <= x < C:
        return True
    return False


def append_point(point, z, y, x):   # 상하 확인해서 큐에 추가할 것인지 확인
    global visit
    if is_in(z, y, x) and not is_wall(point, z, y, x) and not visit[z][y][x]:
        return True
    return False


def bfs(point, start):
    global visit
    escape = False
    que = Queue()
    start.append(0)
    que.put(start)
    visit[start[0]][start[1]][start[2]] = True
    dy, dx = [0, 0, 1, -1], [1, -1, 0, 0]

    while not que.empty() and not escape:   # 큐가 비거나 탈출하기 전까지 반복
        cur_p = que.get()
        if point[cur_p[0]][cur_p[1]][cur_p[2]] == 'E':
            print('Escaped in %d minute(s).' % cur_p[3])
            escape = True
            break

        if append_point(point, cur_p[0] - 1, cur_p[1], cur_p[2]):  # 상 확인
            que.put([cur_p[0] - 1, cur_p[1], cur_p[2], cur_p[3] + 1])
            visit[cur_p[0] - 1][cur_p[1]][cur_p[2]] = True
        if append_point(point, cur_p[0] + 1, cur_p[1], cur_p[2]):  # 하 확인
            que.put([cur_p[0] + 1, cur_p[1], cur_p[2], cur_p[3] + 1])
            visit[cur_p[0] + 1][cur_p[1]][cur_p[2]] = True

        for idx in range(len(dy)):   # 동서남북 확인
            next_y, next_x = cur_p[1] + dy[idx], cur_p[2] + dx[idx]
            if is_in(cur_p[0], next_y, next_x) and not is_wall(point, cur_p[0], next_y, next_x):   # 범위 안에 있고 벽이 아니면
                if not visit[cur_p[0]][next_y][next_x]:   # 방문하지 않았다면
                    que.put([cur_p[0], next_y, next_x, cur_p[3] + 1])
                    visit[cur_p[0]][next_y][next_x] = True

    if not escape:
        print('Trapped!')


while True:
    L, R, C = map(int, sys.stdin.readline().split())
    if L == 0 and R == 0 and C == 0:
        break

    building = []   # 건물 층수
    start_point = []   # 시작 지점
    visit = [[[False for a in range(C)]for b in range(R)]for c in range(L)]   # 방문했는지

    for i in range(L):
        build_row = []
        for j in range(R):
            info = list(sys.stdin.readline().rstrip())
            if 'S' in info:
                start_point = [i, j, info.index('S')]   # 시작 지점 확인
            build_row.append(info)
        sys.stdin.readline()
        building.append(build_row)
    bfs(building, start_point)
