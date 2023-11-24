from collections import deque

n, q = map(int, input().split())

size = 2 ** n

board = [list(map(int, input().split())) for _ in range(size)]

queries = list(map(int, input().split()))


def rotation_90_degree(_l, _y, _x):
    global board
    
    ret = [arr[_x : _x + _l] for arr in board[_y : _y + _l]]
    ret = list(map(list, zip(*ret[::-1])))

    
    for y in  range(_y, _y + _l):
        for x in range(_x, _x + _l):
            board[y][x] = ret[y - _y][x - _x]
            

def divide_L(_size, _l):
    L = 2 ** _l
    
    for y in range(0, _size, L):
        for x in range(0, _size, L):
            rotation_90_degree(L, y, x)


def is_in(y, x):
    global size
    return 0 <= y < size and 0 <= x < size


def get_max_chunk(_size, y, x):
    global board, visit, max_chunk, total
    
    que = deque()
    que.append((y, x))
    
    visit[y][x] = True

    dy, dx = (0,0,1,-1), (1,-1,0,0)

    ret = 0
    while que:
        
        cur_y, cur_x = que.popleft()
        
        total += board[cur_y][cur_x]
        ret += 1
        
        for i in range(4):
            ny, nx = cur_y + dy[i], cur_x + dx[i]
            
            if not is_in(ny, nx) or visit[ny][nx] or not board[ny][nx]:
                continue
            
            visit[ny][nx] = True
            que.append((ny, nx))
            
    max_chunk = max(max_chunk, ret)
            
            
def melting_ice(_size):
    global board, visit

    dy, dx = (0,0,1,-1), (1,-1,0,0)

    melt = []
    for y in range(_size):
        for x in range(_size):
            cnt = 0
            
            for i in range(4):
                ny, nx = y + dy[i], x + dx[i]
                
                if not is_in(ny, nx) or not board[ny][nx]:
                    continue
                
                cnt += 1
                
            if cnt < 3 and board[y][x]:
                melt.append((y, x))

    for y, x in melt:
        board[y][x] -= 1
                

for query in queries:
    divide_L(size, query)

    melting_ice(size)


visit = [[False] * size for _ in range(size)]
max_chunk = 0
total = 0

for y in range(size):
    for x in range(size):
        
        if visit[y][x] or not board[y][x]:
            continue
        
        get_max_chunk(size, y, x)
        
print(total)
print(max_chunk)

