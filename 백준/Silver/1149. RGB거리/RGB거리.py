import sys

n = int(sys.stdin.readline())
sys.setrecursionlimit(int(1e6))

house = []
for _ in range(n):
    house.append(list(map(int, sys.stdin.readline().split())))

for i in range(1, n):
    house[i][0] += min(house[i - 1][1], house[i - 1][2])
    house[i][1] += min(house[i - 1][0], house[i - 1][2])
    house[i][2] += min(house[i - 1][1], house[i - 1][0])

print(min(house[n-1]))