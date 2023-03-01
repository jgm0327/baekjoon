from sys import stdin
n, m = map(int, stdin.readline().split())
total = [0]
for number in list(map(int, stdin.readline().split())):
    total.append(total[-1] + number)

for _ in range(m):
    l, r = map(int, stdin.readline().split())
    print(total[r] - total[l - 1])
