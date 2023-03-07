n = int(input())
names = list(input().rstrip() for _ in range(n))
answer = list(names[0])

for i in range(1, n):
    for j in range(len(answer)):
        if answer[j] != names[i][j]:
            answer[j] = '?'
print(''.join(answer))