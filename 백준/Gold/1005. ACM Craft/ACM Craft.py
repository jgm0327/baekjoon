import sys
from collections import deque

input = sys.stdin.readline

T = int(input())


def topology_sort(target):
    global costs, in_degree, order, n

    que = deque()
    ret = [0] * (n + 1)

    for task in range(1, n + 1):
        if in_degree[task] == 0:
            que.append(task)
            ret[task] = costs[task]

    while que:
        sour = que.popleft()
        
        for des in order[sour]:
            in_degree[des] -= 1
            
            if in_degree[des] == 0:
                que.append(des)
                
            if in_degree[des] >= 0:
                ret[des] = max(ret[des], ret[sour] + costs[des])
                
    print(ret[target])
        

for _ in range(T):
    n, m = map(int, input().split())

    costs = [0] + list(map(int, input().split()))

    in_degree = [0] * (n + 1)
    order = [[] for _ in range(n + 1)]

    for sour, des in [list(map(int, input().split())) for i in range(m)]:
        order[sour].append(des)
        in_degree[des] += 1

    topology_sort(int(input()))
