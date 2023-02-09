from sys import stdin

n = int(stdin.readline())
drinks = sorted(list(map(int, stdin.readline().split())))
answer = drinks[-1]
for drink in drinks[:n - 1]:
    answer += drink / 2
print(answer)

