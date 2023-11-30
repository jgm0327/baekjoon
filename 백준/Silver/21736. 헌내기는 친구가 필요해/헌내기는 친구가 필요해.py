from collections import deque

n, m = map(int, input().split())

campus = [list(input()) for _ in range(n)]

def findDoyeon():
    global campus, n, m

    for i in range(n):
        for j in range(m):
            if campus[i][j] == 'I':
                return (i, j)


def bfs(sy, sx):
    global campus, n, m
    
    que = deque()
    que.append((sy, sx))
    
    visit = [[False] * m for _ in range(n)]
    visit[sy][sx] = True    

    dy, dx = (0,0,1,-1), (1,-1,0,0)

    people_count = 0

    while que:
        y, x = que.popleft()

        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            
            if 0 > ny or ny >= n or 0 > nx or nx >= m or visit[ny][nx] or campus[ny][nx] == 'X':
                continue
            
            if campus[ny][nx] == 'P':
                people_count += 1
                
            visit[ny][nx] = True
            que.append((ny, nx))
            
    return people_count
       
    
sy, sx = findDoyeon()
people_count = bfs(sy, sx)
print(people_count if people_count else 'TT')
