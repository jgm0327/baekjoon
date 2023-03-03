n, m = map(int, input().split())
icecreams = [dict() for _ in range(n+1)]
for _ in range(m):
    sour, des = map(int, input().split())
    icecreams[sour][des] = icecreams[des][sour] = True

visit = [False] * (n + 1)
answer = 0
def recur(depth: int, start: int, path: list):
    global visit, icecreams, n, answer
    if depth == 3:
        answer += 1
        return
    for i in range(start, n + 1):
        flag = True
        for s in path:
            if icecreams[i].get(s) is not None:
                flag = False
                break
        if not visit[i] and flag:
            visit[i] = True
            path.append(i)
            recur(depth + 1, i, path)
            path.pop()
            visit[i] = False

recur(0, 1, [])
print(answer)
