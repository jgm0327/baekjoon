import sys
from collections import deque

sour, des = map(int, sys.stdin.readline().split())


def bfs():
    global sour, des
    dx = [-1, 1]
    min_value = 100001

    que = deque()
    que.append([sour, 0])
    answer = 0
    visit = [False] * 100001
    visit[sour] = True
    while que:
        pos, cnt = que.popleft()
        visit[pos] = True

        if cnt > min_value:
            break

        if des == pos:
            min_value = cnt
            answer += 1
            continue

        for i in range(2):
            next_x = pos + dx[i]
            if 0 <= next_x <= 100000 and not visit[next_x]:
                que.append([next_x, cnt + 1])

        next_x = pos * 2
        if 0 <= next_x <= 100000 and not visit[next_x]:
            que.append([next_x, cnt + 1])

    print(min_value)
    print(answer)


if sour > des:
    print(sour - des)
    print(1)
    exit(0)
bfs()
