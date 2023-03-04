from sys import stdin

n, m = map(int, stdin.readline().split())
enterances = sorted(list(int(stdin.readline()) for _ in range(n)))

start, end = 0, enterances[0] * m
while start <= end:
    mid = (start + end) // 2
    total = 0
    for enterance in enterances:
        total += mid // enterance
    if m > total:
        start = mid + 1
    else:
        answer = mid
        end = mid - 1
print(answer)

