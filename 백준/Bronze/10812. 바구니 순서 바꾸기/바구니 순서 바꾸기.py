n, m = map(int, input().split())
b = [data for data in range(n + 1)]
for i, j, k in list(map(int, input().split()) for _ in range(m)):
    b[i:j+1] = b[k:j+1] + b[i:k]
print(*b[1:])
