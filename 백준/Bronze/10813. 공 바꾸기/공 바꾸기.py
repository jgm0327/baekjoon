n, m = map(int, input().split())
b = [num for num in range(n+1)]
for i, j in list(map(int, input().split()) for _ in range(m)):
    b[i], b[j] = b[j], b[i]
print(*b[1:])

