from collections import deque

visit = [False]

def bfs(n, computers, start):
    global visit
    que = deque()
    que.append(start)
    visit[start] = True
    
    while que:
        cur = que.popleft()
        for i in range(len(computers[cur])):
            if computers[cur][i] and not visit[i]:
                visit[i] = True
                que.append(i)
    

def solution(n, computers):
    global visit
    answer = 0
    visit = [False] * n
    
    for i in range(n):
        if not visit[i]:
            bfs(n, computers, i)
            answer += 1
    
    return answer