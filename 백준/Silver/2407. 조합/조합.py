import sys

n, m = map(int, sys.stdin.readline().split())
answer = 1

for num in range(n, n - m, -1):
    answer *= num
for num in range(2, m+1):
    answer //= num

print(answer)