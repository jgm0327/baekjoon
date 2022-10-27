answer = 0
n = 0
visit = []
path = []

def recur(depth: int, k: int, cnt: int) -> None:
    global answer, n, path, visit
    if n == depth:
        answer = answer if cnt < answer else cnt
        return
    
    for i in range(n):
        if k < path[i][0] or visit[i]:
            continue
        visit[i] = True
        k -= path[i][1]
        recur(depth+1, k, cnt+1)
        k += path[i][1]
        visit[i] = False
    answer = answer if cnt < answer else cnt
    

def solution(k, dungeons):
    global answer, n, path, visit
    path = dungeons
    n = len(dungeons)
    visit = [False]  * n
    recur(0, k, 0)
    return answer