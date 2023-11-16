n, m, l = map(int, input().split())

location = [0] + list(map(int, input().split())) + [l]
location.sort()

start, end = 1, l - 1

answer = 1000
while start <= end:
    mid = (start + end) // 2
    cnt = 0

    for i in range(1, len(location)):
        dist = location[i] - location[i - 1]
        if dist <= mid:
            continue
        cnt += (dist - 1) // mid

    if m < cnt:
        start = mid + 1
    else:
        answer = min(answer, mid)
        end = mid - 1

print(answer)
