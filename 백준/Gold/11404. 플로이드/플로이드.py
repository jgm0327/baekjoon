from sys import stdin

n = int(stdin.readline())
m = int(stdin.readline())
costs = [[int(1e9)] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    sour, des, cost = map(int, stdin.readline().split())
    costs[sour][des] = min(costs[sour][des], cost)
for i in range(1, n + 1):
    costs[i][i] = 0
    

for k in range(1, n + 1):
    for i in range(1, n + 1):
            for j in range(n + 1):
                cost = costs[i][k] + costs[k][j]
                costs[i][j] = cost if cost < costs[i][j] else costs[i][j]

for i in range(1, n + 1):
    print(*[data if int(1e9) != data else 0 for data in costs[i][1:]])
