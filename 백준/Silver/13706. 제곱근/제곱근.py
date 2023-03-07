from math import sqrt
n = int(input())

start, end = 0, n
while start <= end:
    mid = (start+end)//2
    value = mid * mid
    if value < n:
        start = mid + 1
    elif value > n:
        end = mid - 1
    else:
        print(mid)
        break