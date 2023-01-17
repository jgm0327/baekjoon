import sys


def solution():
    n, m = map(int, sys.stdin.readline().split())
    woods = list(map(int, sys.stdin.readline().split()))

    start, end = 0, int(1e9)
    mid = 0
    cache = 0

    while start <= end:
        Sum = 0
        cnt = 0
        mid = (start + end) // 2
        for wood in woods:
            if wood >= mid:
                Sum += (wood - mid)
                cnt += 1
        if m > Sum:
            end = mid - 1
        else:
            start = mid + 1
            cache = cache if cache > mid else mid
    print(cache)




solution()
