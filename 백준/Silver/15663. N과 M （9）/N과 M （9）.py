from sys import stdin

n, m = map(int, stdin.readline().split())
numbers = sorted(stdin.readline().rstrip().split(), key=lambda x: int(x))
count = {}.fromkeys(numbers, 0)
visit_result = {}
visit_idx = [False] * n

def backtracking(depth: int, path: list) -> None:
    global n, m, numbers, count
    if depth == m:
        result = ' '.join(path)
        if visit_result.get(result) is None:
            print(result)
        visit_result[result] = True
        return

    for idx, number in enumerate(numbers):
        if count[number] >= m or visit_idx[idx]:
            continue
        count[number] += 1
        visit_idx[idx] = True
        path.append(number)
        backtracking(depth + 1, path)
        path.pop()
        visit_idx[idx] = False
        count[number] -= 1

backtracking(0, [])
