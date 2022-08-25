import sys


def solution():
    k, n = map(int, sys.stdin.readline().split())
    lan_cables = []
    for _ in range(k):
        lan_cables.append(int(sys.stdin.readline()))

    start, end = 0, (2**31 - 1)
    result = 0

    while start <= end:
        total_cut_cable = 0
        mid = int((start + end) / 2)

        for cable in lan_cables:
            if mid:
                total_cut_cable += int(cable / mid)

        if n > total_cut_cable:
            end = mid - 1
        else:
            start = mid + 1
            result = result if result > mid else mid

    print(result)


solution()
