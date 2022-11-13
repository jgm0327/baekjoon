import sys

input = sys.stdin

n = int(input.readline())
m = int(input.readline())
graph = []
parents = [i for i in range(n)]

for _ in range(n):
    graph.append(list(map(int, input.readline().split())))

cities = list(map(int, input.readline().split()))


def find(x: int) -> int:
    global parents
    if parents[x] == x:
        return x
    parents[x] = find(parents[x])
    return parents[x]


def union(u: int, v: int) -> None:
    global parents
    u = find(u)
    v = find(v)
    if u == v:
        return
    parents[u] = v

for i in range(n):
    for j in range(n):
        if graph[i][j]:
            union(j, i)

start = cities[0]
for city in cities[1:]:
    if find(parents[start - 1]) != find(parents[city - 1]):
        print('NO')
        exit(0)
    start = city
print('YES')
