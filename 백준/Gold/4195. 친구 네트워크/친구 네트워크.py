from sys import stdin, setrecursionlimit

def find_parent(x: str) -> str:
    global parent
    if x == parent[x]:
        return x
    parent[x] = find_parent(parent[x])
    return parent[x]



def union(x: str, y: str) -> int:
    global parent, count
    xp, yp = find_parent(x), find_parent(y)
    if xp == yp:
        return count[xp]

    
    if count[xp] > count[yp]:
        xp, yp = yp, xp

    parent[xp] = yp
    count[yp] += count[xp]
    return count[yp]


T = int(stdin.readline())


setrecursionlimit(int(1e8))

for _ in range(T):
    n = int(stdin.readline())
    parent = {}
    count = {}

    for i in range(n):
        f1, f2 = stdin.readline().rstrip().split()
        if parent.get(f1) is None:
            parent[f1] = f1
            count[f1] = 1
        if parent.get(f2)is None:
            parent[f2] = f2
            count[f2] = 1
        ret = union(f1, f2)
        print(ret)



        
