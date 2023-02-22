answer =[1, 1, 2, 2, 2, 8]
for i, a in enumerate(list(map(int, input().split()))):
    answer[i] -= a
print(*answer)
