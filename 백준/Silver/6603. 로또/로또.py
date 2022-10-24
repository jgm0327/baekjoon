import sys


def combination(depth: int, start: int, path: list) -> None:
    global visit, n
    if depth == 6:
        for data in path:
            print(data, end=' ')
        print()
        return

    for i in range(start, n):
        if visit[i]:
            continue
        visit[i] = True
        path.append(numbers[i])
        combination(depth + 1, i + 1, path)
        visit[i] = False
        path.pop()


while True:
    numbers = list(map(int, sys.stdin.readline().split()))
    n = numbers[0]
    numbers.pop(0)
    if n == 0:
        break
    visit = [False] * n
    combination(0, 0, [])
    print()
