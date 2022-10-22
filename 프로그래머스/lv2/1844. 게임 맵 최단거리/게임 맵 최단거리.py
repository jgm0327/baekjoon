from collections import deque

def solution(maps):
    que = deque()
    que.append([0,0,1])
    dy, dx = [0,0,1,-1], [1,-1,0,0]
    n = len(maps)
    m = len(maps[0])
    visit = [[False] * m for _ in range(n)]
    visit[0][0] = True
    
    while que:
        cur_y, cur_x, cur_cnt = que.popleft()
        
        for i in range(4):
            next_y, next_x, next_cnt = cur_y + dy[i], cur_x + dx[i], cur_cnt + 1
            
            if 0 <= next_x < m and 0 <= next_y < n and\
            maps[next_y][next_x] and not visit[next_y][next_x]:
                if next_y == n-1 and next_x == m-1:
                    return next_cnt
                visit[next_y][next_x] = True
                que.append([next_y, next_x, next_cnt])
    
    return -1