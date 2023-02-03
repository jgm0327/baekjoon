from sys import stdin

n = int(stdin.readline())
numbers = list(map(int, stdin.readline().split()))
op_cnt = list(map(int, stdin.readline().split()))
op = {'+': op_cnt[0], '-': op_cnt[1], '*': op_cnt[2], '/': op_cnt[3]}
max_value = -int(1e9)
min_value = int(1e9)


def dfs(depth: int, total: int) -> None:
    global numbers, max_value, min_value, op, n
    if depth == n:
        max_value = max_value if max_value > total else total
        min_value = min_value if min_value < total else total
        return
    if op['+']:
        op['+'] -= 1
        dfs(depth + 1, total + numbers[depth])
        op['+'] += 1
    if op['-']:
        op['-'] -= 1
        dfs(depth + 1, total - numbers[depth])
        op['-'] += 1
    if op['*']:
        op['*'] -= 1
        dfs(depth + 1, total * numbers[depth])
        op['*'] += 1
    if op['/']:
        op['/'] -= 1
        dfs(depth + 1, int(total / numbers[depth]))
        op['/'] += 1


dfs(1, numbers[0])
print(max_value)
print(min_value)
