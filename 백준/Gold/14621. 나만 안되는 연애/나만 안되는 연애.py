from heapq import heappush, heappop

n, m = map(int, input().split())

gender = [0] + list(input().split())

graph = []
path = [[] for _ in range(n + 1)]
parents = [i for i in range(n + 1)]

for sour, des, cost in [list(map(int, input().split())) for _ in range(m)]:
    heappush(graph, (cost, sour, des))


def find_parent(x):
    global parents

    if parents[x] == x:
        return x

    parents[x] = find_parent(parents[x])

    return parents[x]


def union(px, py):
    global parents

    if px == py:
        return

    parents[py] = px


def dfs(sour):
    global visit, count, path

    visit[sour] = True
    count += 1
    
    for des in path[sour]:
        if visit[des]:
            continue
        dfs(des)


answer = 0
while graph:
    cost, sour, des = heappop(graph)

    if gender[sour] == gender[des]:
        continue

    sour_parent, des_parent = find_parent(sour), find_parent(des)

    if sour_parent == des_parent:
        continue
    path[sour].append(des)
    path[des].append(sour)
    
    answer += cost
    union(sour_parent, des_parent)


count = 0
visit = [False] * (n + 1)
dfs(1)
print(answer if count == n else -1)
