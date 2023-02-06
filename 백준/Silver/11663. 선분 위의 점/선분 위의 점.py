from sys import stdin


n, m = map(int, stdin.readline().split())
spots = sorted(list(map(int, stdin.readline().split())))

for s, e in [list(map(int, stdin.readline().split())) for _ in range(m)]:
    total = 0
    start, end = 0, n - 1
    while start <= end:
        mid = (start + end) // 2
        if spots[mid] < s:
            start = mid + 1
        else:
            end = mid - 1
    first_index = end + 1
            
    start, end = 0, n - 1
    while start <= end:
        mid = (start + end) // 2
        if spots[mid] > e:
            end = mid - 1
        else:
            start = mid + 1
    last_index = end

    print(last_index - first_index + 1)
