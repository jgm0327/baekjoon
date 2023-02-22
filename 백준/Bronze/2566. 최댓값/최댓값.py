answer = 0
idx = [1, 1]

arr = [list(map(int, input().split())) for _ in range(9)]
for i in range(9):
    for j in range(9):
        if arr[i][j] > answer:
            answer = arr[i][j]
            idx = [i + 1, j + 1]
print(answer)
print(*idx)

