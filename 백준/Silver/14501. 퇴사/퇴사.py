import sys

input = sys.stdin

n = int(input.readline())
days = [list(map(int, input.readline().split())) for _ in range(n)]
answer = 0


def backtracking(start: int, total: int) -> None:
    global answer, n, days
    if start >= n:
        answer = answer if answer > total else total
        return
    for i in range(start, n):
        if i + days[i][0] > n:
            continue
        total += days[i][1]
        backtracking(days[i][0] + i, total)
        total -= days[i][1]
    answer = answer if answer > total else total


backtracking(0, 0)
print(answer)
