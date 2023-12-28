import sys

input = sys.stdin.readline
sys.setrecursionlimit(int(1e6))

n, m = map(int, input().split())

parents = [i for i in range(n + 1)]

graph = [map(int, input().split()) for _ in range(m)]


def find_parent(x):
    global parents
    
    if x == parents[x]:
        return x

    parents[x] = find_parent(parents[x])
    
    return parents[x]


def union(x, y):
    px, py = find_parent(x), find_parent(y)

    if px == py:
        return

    parents[py] = px


answer = 0
exist_cycle = False
for sour, des in graph:
    answer += 1
    
    if find_parent(sour) == find_parent(des):
        exist_cycle = True
        break

    union(sour, des)

print(answer if exist_cycle else 0)
