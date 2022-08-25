import sys

n, k, m = map(int, sys.stdin.readline().split())
kimbab = []

for _ in range(n):
    data = int(sys.stdin.readline())
    kimbab.append([data, data])

start, end = 1, int(1e9) * 2
result = 0

while start <= end:
    mid = (start + end) // 2
    cnt = 0

    for i in range(n):
        if mid == 0:
            break
        if kimbab[i][0] >= 2 * k:
            kimbab[i][0] -= 2 * k
        elif k < kimbab[i][0] < 2 * k:
            kimbab[i][0] -= k
        else:
            kimbab[i][0] = 0
        if kimbab[i][0]:
            cnt += kimbab[i][0] // mid
        kimbab[i][0] = kimbab[i][1]

    if cnt < m:
        end = mid - 1
    else:
        result = result if mid < result else mid
        start = mid + 1

if result:
    print(result)
else:
    print(-1)
