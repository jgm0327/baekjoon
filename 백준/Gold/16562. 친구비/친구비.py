from sys import stdin, setrecursionlimit

n, m, budget = map(int, stdin.readline().split())
money = [0] + list(map(int, stdin.readline().split()))
parent = {}
INF = int(1e8)
for i in range(1, n+1):
    parent[i] = i

setrecursionlimit(int(1e8))

def find_parent(x: int) -> int:
    global parent
    if x == parent[x]:
        return x
    parent[x] = find_parent(parent[x])
    return parent[x]


def union(x: int, y: int) -> None:
    global parent, money
    xp = find_parent(x)
    yp = find_parent(y)
    if xp == yp:
        return
    if xp != yp:
        if money[xp] > money[yp]:
            xp, yp = yp, xp
        parent[yp] = xp


for f1, f2 in [list(map(int, stdin.readline().split())) for _ in range(m)]:
    union(f1, f2)

answer = 0
for i in range(1, n + 1):
    p = find_parent(i)
    answer += money[p]
    money[p] = 0
print(answer if answer <= budget else 'Oh no')
