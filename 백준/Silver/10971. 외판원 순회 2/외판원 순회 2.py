from sys import stdin

n = int(stdin.readline())
graph = [list(map(int, stdin.readline().split())) for _ in range(n)]
answer = int(1e9)


def backtracking(depth: int, sour: int, total: int) -> None:
    global graph, n, visit, answer, start
    if depth >= n:
        answer = answer if answer < total else total
        return

    for des in range(n):
        if answer > total and graph[sour][des] and (not visit[des] or (des == start and depth == n - 1)):
            total += graph[sour][des]
            visit[des] = True
            backtracking(depth + 1, des, total)
            total -= graph[sour][des]
            visit[des] = False
            visit[start] = True


for start in range(n):
    visit = [False] * n
    visit[start] = True
    backtracking(0, start, 0)

print(answer)
