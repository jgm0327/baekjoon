from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())
computers = [[] for _ in range(n + 1)]
for _ in range(m):
    sour, des = map(int, stdin.readline().split())
    computers[des].append(sour)


def bfs(start: int) -> int:
    global n, computers
    visit = [False] * (n + 1)
    visit[start] = True
    que = deque([start])

    ret = 0
    while que:
        sour = que.popleft()
        ret += 1
        for des in computers[sour]:
            if not visit[des]:
                visit[des] = True
                que.append(des)
    return ret

max_value, counts = 0, [0] * (n + 1)
for s in range(1, n + 1):
    count = bfs(s)
    max_value = max_value if count < max_value else count
    counts[s] = count

for i in range(1, n + 1):
    if max_value == counts[i]:
        print(i, end=' ')
