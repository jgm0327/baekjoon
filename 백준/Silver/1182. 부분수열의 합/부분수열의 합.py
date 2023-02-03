from sys import stdin

n, m = map(int, stdin.readline().split())
numbers = list(map(int, stdin.readline().split()))
answer = 0


def backtracking(start: int, total: int) -> None:
    global answer, numbers, n, m
    if start >= n:
        return
    for i in range(start, n):
        total += numbers[i]
        if total == m:
            answer += 1
        backtracking(i + 1, total)
        total -= numbers[i]


backtracking(0, 0)
print(answer)