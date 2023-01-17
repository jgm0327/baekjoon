import sys

input = sys.stdin

n, m = map(int, input.readline().split())
houses = sorted([int(input.readline()) for _ in range(n)])
start, end = 1, houses[-1] - houses[0]
answer = 0

while start <= end:
    mid = (start + end) // 2
    tmp = houses[0]
    cnt = 1
    for i in range(1, n):
        if houses[i] >= tmp + mid:
            cnt += 1
            tmp = houses[i]
    if cnt >= m:
        answer = mid
        start = mid + 1
    else:
        end = mid - 1

print(answer)
