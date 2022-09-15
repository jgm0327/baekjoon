import sys

n, m = map(int, sys.stdin.readline().split())
tree = [[] for i in range(n + 1)]

for _ in range(n - 1):
    sour, des, cost = map(int, sys.stdin.readline().split())
    tree[sour].append([des, cost])
    tree[des].append([sour, cost])

visit = [False for _ in range(n + 1)]


def dfs(s: int, e: int, dist: int) -> None:
    global visit, tree
    if s == e:
        print(dist)
        return
    visit[s] = True

    for data in tree[s]:
        if not visit[data[0]]:
            dfs(data[0], e, dist+data[1])


for _ in range(m):
    visit = [False for _ in range(n + 1)]
    start, end = map(int, sys.stdin.readline().split())
    dfs(start, end, 0)
