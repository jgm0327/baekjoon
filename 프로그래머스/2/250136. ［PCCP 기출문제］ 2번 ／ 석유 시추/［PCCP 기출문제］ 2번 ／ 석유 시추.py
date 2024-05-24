from collections import deque

def bfs(land, number, y, x, n, m):
    que = deque()
    que.append((y, x))
    
    dy, dx = (0,0,1,-1), (1,-1,0,0)
    
    cnt = 1
    land[y][x] = number
    
    while que:
        cur_y, cur_x = que.pop()
        
        for i in range(4):
            next_y, next_x = cur_y + dy[i], cur_x + dx[i]
            
            if not (0 <= next_y < n and 0 <= next_x < m) \
            or land[next_y][next_x] != 1:
                continue
                
            cnt += 1
            que.append((next_y, next_x))
            land[next_y][next_x] = number
            
    return cnt


def solution(land):
    answer = 0
    
    n = len(land)
    m = len(land[0])
    oil = [0] * (n * m)
    number = 2
    
    for y in range(n):
        for x in range(m):
            if land[y][x] != 1:
                continue
            
            oil[number] = bfs(land, number, y, x, n, m)
            number += 1
            
    for x in range(m):
        total = 0
        visit = {}
        for y in range(n):
            if land[y][x] == 0 or visit.get(land[y][x]):
                continue
            
            total += oil[land[y][x]]
            visit[land[y][x]] = True
            
        answer = max(answer, total)
    
        
    return answer