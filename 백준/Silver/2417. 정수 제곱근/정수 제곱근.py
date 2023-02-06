from sys import stdin

n = int(stdin.readline())
start, end = 0, n
answer = n + 1
while start <= end:
    mid = (start+end) // 2
    if mid * mid >= n:
        end = mid - 1
        answer = answer if answer < mid else mid
    else:
        start = mid + 1
print(answer)

