answer = 0
cur = 0
for _ in range(4):
    a, b = map(int, input().split())
    cur += b - a
    answer = max(answer, cur)
print(answer)
