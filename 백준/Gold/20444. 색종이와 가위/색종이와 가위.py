n, m = map(int, input().split())

start, end = 0, n // 2
flag = False
while start <= end:
    mid = (start + end) // 2
    tmp = n - mid
    piece = (tmp + 1) * (mid + 1)
    if piece == m:
        flag = True
        break
    if piece > m:
        end = mid - 1
    elif piece < m:
        start = mid + 1
print('YES' if flag else 'NO')
