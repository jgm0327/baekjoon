from sys import stdin

n = int(stdin.readline())
start, end = 0, n + 1
answer = 0
while start <= end:
    mid = (start + end) // 2
    total = (mid * (mid + 1)) / 2
    if total > n:
        end = mid - 1
    else:
        start = mid + 1
        answer = mid

print(answer)
