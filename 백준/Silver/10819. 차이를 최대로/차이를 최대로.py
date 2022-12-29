import sys

input = sys.stdin
n = int(input.readline())
num_list = list(map(int, input.readline().split()))
answer = 0
visit = [0] * n
path = []


def recur(depth: int, cur: int, total: int) -> None:
    global answer, num_list, n, path
    if depth + 1 == n:
        answer = max(answer, total)
        return

    for idx in range(n):
        if visit[idx]:
            continue
        data = abs(cur - num_list[idx])
        visit[idx] = True
        total += data
        recur(depth + 1, num_list[idx], total)
        visit[idx] = False
        total -= data


for i in range(n):
    visit[i] = True
    recur(0, num_list[i], 0)
    visit[i] = False
print(answer)
