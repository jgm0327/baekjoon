n = int(input())

for a, b in [map(int, input().split()) for _ in range(n)]:
    print(a + b)
