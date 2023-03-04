from sys import stdin

n, m = map(int, stdin.readline().split())
houses = sorted([int(stdin.readline()) for _ in range(n)])

start, end = 1, (houses[-1] - houses[0])
answer = 0
while start <= end:
    mid = (start + end) // 2
    total = 1
    tmp = houses[0]
    for house in houses[1:]:
        if house < tmp + mid:
            continue
        total += 1
        tmp = house

    if total >= m:
        start = mid + 1
        answer = max(answer, mid)
    else:
        end = mid - 1
print(answer)
        
