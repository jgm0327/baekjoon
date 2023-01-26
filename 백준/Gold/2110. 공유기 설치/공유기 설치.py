import sys

input = sys.stdin

n, m = map(int, input.readline().split())
distances = sorted([int(input.readline()) for _ in range(n)])

start, end = 1, distances[-1] - distances[0]

answer = 0
while start <= end:
    mid = (start + end) // 2
    temp = distances[0]
    cnt = 1
    for i in range(1, n):
        if distances[i] >= temp + mid:
            temp = distances[i]
            cnt += 1

    if cnt >= m:
        start = mid + 1
        answer = mid
    else:
        end = mid - 1
print(answer)
