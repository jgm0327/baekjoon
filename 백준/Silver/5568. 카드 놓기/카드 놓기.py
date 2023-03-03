n = int(input())
k = int(input())
num = [int(input()) for _ in range(n)]
answer = dict()
visit = [False]*n

def recur(depth: int, path: list):
    global visit, k, num, answer, visit, n
    if depth == k:
        answer[''.join(path)] = True
        return
    for i in range(n):
        if not visit[i]:
            visit[i] = True
            path.append(str(num[i]))
            recur(depth+1, path)
            visit[i] = False
            path.pop()

recur(0, [])
print(len(answer))
