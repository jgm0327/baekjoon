import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

buildings = [[] for _ in range(n + 1)]
in_degree = [0] * (n + 1)
costs = [0] * (n + 1)

for idx, input_data in enumerate([list(map(int, input().split())) for _ in range(n)]):
    des = idx + 1
    costs[des] = input_data[0]
    
    for sour in input_data[1:len(input_data)-1]:
        buildings[sour].append(des)
        in_degree[des] += 1
        
    
def topology_sort():
    global costs, buildings, in_degree, n

    que = deque()

    ret = [0] * (n + 1)
    
    for sour in range(1, n + 1):
        if in_degree[sour] == 0:
            que.append(sour)
            ret[sour] = costs[sour]

    while que:
        sour = que.popleft()

            
        for des in buildings[sour]:
            in_degree[des] -= 1

            if in_degree[des] == 0:
                que.append(des)

            if in_degree[des] >= 0:
                ret[des] = max(ret[des], ret[sour] + costs[des])
    
    for data in ret[1:]:
        print(data)


topology_sort()
