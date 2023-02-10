from sys import stdin

n, m = map(int, stdin.readline().split())
numbers = sorted(stdin.readline().rstrip().split(), key=lambda x: int(x))
count = {}.fromkeys(numbers, 0)
visit = [False] * n

def backtracking(depth: int, path: list) -> None:
    global n, m, numbers, count
    if depth == m:
        print(' '.join(path))
        return
    temp = 0
    for idx, number in enumerate(numbers):
        if count[number] >= m or visit[idx] or temp == number:
            continue
        count[number] += 1
        visit[idx] = True
        path.append(number)
        temp = number
        backtracking(depth + 1, path)
        path.pop()
        visit[idx] = False
        count[number] -= 1

backtracking(0, [])
