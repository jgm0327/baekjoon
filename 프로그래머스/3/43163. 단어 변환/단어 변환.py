from collections import deque


def comp(a, b):
    cnt = 0
    
    for i in range(len(a)):
        if a[i] != b[i]:
            cnt += 1
    
    return cnt == 1


def bfs(begin, target, words):
    que = deque()
    que.append((begin, 0))
    
    visit = {}
    
    while que:
        cur, cnt = que.popleft()
        
        for word in words:
            if visit.get(word) is not None or not comp(word, cur):
                continue
                
            if word == target:
                return cnt + 1
            
            visit[word] = True
            que.append((word, cnt + 1))
            
    return 0

def solution(begin, target, words):
    return bfs(begin, target, words)