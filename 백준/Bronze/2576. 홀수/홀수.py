answer = [0,101]
for _ in range(7):
    n = int(input())
    if n % 2:
        answer[0] += n
        answer[1] = min(answer[1], n)
print(str(answer[0]) + '\n' + str(answer[1]) if answer[1] != 101 else -1)
