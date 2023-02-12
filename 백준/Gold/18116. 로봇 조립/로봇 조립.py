from sys import stdin, setrecursionlimit

n = int(stdin.readline())
parent = {}
count = {}

setrecursionlimit(int(1e8))

def find_parent(x: int) -> int:
    global parent
    if x == parent[x]:
        return x
    parent[x] = find_parent(parent[x])
    return parent[x]


def union(x:int, y: int) -> None:
    global parent

    xp, yp = find_parent(x), find_parent(y)
    if xp == yp:
        return
    if count[xp] > count[yp]:
        xp, yp = yp, xp
    parent[xp]=yp
    count[yp] += count[xp]

for _ in range(n):
    input_data = list(stdin.readline().rstrip().split())
    if input_data[0] == 'I':
        x, y = input_data[1:]
        if parent.get(x) is None:
            parent[x] = x
            count[x] = 1
        if parent.get(y) is None:
            parent[y] = y
            count[y] = 1
        union(y, x)
    else:
        x = input_data[1]
        if parent.get(x) is None:
            parent[x] = x
            count[x] = 1
        p = find_parent(x)
        print(count[p])
        
