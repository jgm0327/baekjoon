import sys

n, m = map(int, sys.stdin.readline().split())
number_list = list(map(int, sys.stdin.readline().split()))
number_list.sort()
digit = {}


def dfs(depth: int, p: list, idx_list: list):
    global n, m, number_list, digit

    if depth == m:
        temp = ''.join(map(str, p))
        if digit.get(temp) != None:
            return

        for i in range(m):
            print(p[i], end=' ')
        print()
        digit[temp] = 1
        return

    for i in range(len(number_list)):
        if i not in idx_list:
            p[depth] = number_list[i]
            idx_list.append(i)
            dfs(depth + 1, p, idx_list)
            idx_list.pop()
            p[depth] = 0


dfs(0, [0] * (n + 2), [])
