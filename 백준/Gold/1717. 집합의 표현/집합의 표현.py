import sys

n, m = map(int, sys.stdin.readline().split())
parents = [i for i in range(n+1)]

sys.setrecursionlimit(int(1e8))


def find_parent(x: int) -> int:
    global parents
    if x == parents[x]:
        return x
    parents[x] = find_parent(parents[x])
    return parents[x]


def union(x:int, y: int) -> None:
    global parents
    p1, p2 = find_parent(x), find_parent(y)
    if p1 == p2:
        return

    parents[p1] = p2
    

for _ in range(m):
    opt, x, y = map(int, sys.stdin.readline().split())
    if opt:
        p1, p2 = find_parent(x), find_parent(y)
        print('YES' if p1 == p2 else 'NO')
    else:
        union(x, y)
        
