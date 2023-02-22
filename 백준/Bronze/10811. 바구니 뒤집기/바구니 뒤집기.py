n, m = map(int, input().split())
b = [a for a in range(n+1)]
for i, j in list(map(int, input().split()) for _ in range(m)):
    b[i:j+1] = b[j:i-1:-1]
print(*b[1:])

