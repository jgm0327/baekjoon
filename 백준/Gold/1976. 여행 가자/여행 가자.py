from sys import stdin, setrecursionlimit

n = int(stdin.readline())
m = int(stdin.readline())

cities =[[0]] + [[0]+list(map(int, stdin.readline().split())) for _ in range(n)]
plan = list(map(int, stdin.readline().split()))
parents = {}
rank = {}
for i in range(1, n+1):
    parents[i] = i
    rank[i] = 1


def find_parent(x: int) -> int:
    global parents
    if x == parents[x]:
        return x
    parents[x] = find_parent(parents[x])
    return parents[x]


def union(x: int, y: int) -> None:
    global ranks, parents
    xp = find_parent(x)
    yp = find_parent(y)

    if rank[xp] < rank[yp]:
        xp, yp = yp, xp
    if rank[xp] == rank[yp]:
        rank[xp] += 1
    parents[yp] = xp


for i in range(1, n + 1):
    for j in range(1, n + 1):
        if cities[i][j] and find_parent(i) != find_parent(j):
            union(i, j)

answer = 'YES'
for i in range(m - 1):
    if find_parent(plan[i]) != find_parent(plan[i+1]):
        answer = 'NO'
        break
print(answer)
