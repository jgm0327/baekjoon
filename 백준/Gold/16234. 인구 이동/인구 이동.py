from collections import deque

n, l, r = map(int, input().split())

population = [list(map(int, input().split())) for _ in range(n)]


def change_population(loc):
    global population

    change_value = loc[0]
    ret = 0
    
    for y, x in loc[1:]:
        if population[y][x] == change_value:
            continue
        population[y][x] = change_value
        ret = 1

    return ret

    
def bfs(y, x, _visit, num):
    global population, visit, n, flag, location

    que = deque()
    que.append((y, x))
    _visit[y][x] = True

    dy, dx = (0,0,1,-1), (1,-1,0,0)

    total = 0
    ret = []

    while que:
        cur_y, cur_x = que.popleft()
        ret.append((cur_y, cur_x))
        total += population[cur_y][cur_x]
        
        for i in range(4):
            next_y, next_x = cur_y + dy[i], cur_x + dx[i]

            if 0 > next_y or next_y >= n or 0 > next_x or next_x >= n:
                continue

            if _visit[next_y][next_x] or\
               not (l <= abs(population[next_y][next_x] - population[cur_y][cur_x])<= r):
                continue

            que.append((next_y, next_x))
            _visit[next_y][next_x] = True
            
    if len(ret) == 1:
        return
    
    location[num] = [total // len(ret)] + ret

    
def solution():
    global population, flag
    
    visit = [[False] * n for _ in range(n)]
    number = 1
    for i in range(n):
        for j in range(n):
            if not visit[i][j]:             
                bfs(i, j, visit, number)
                number += 1
                
    
count = 0
while True:
    location = {}
    
    solution()

    change_count = 0

    for key in location.keys():
        change_count += change_population(location[key])
        
    if change_count == 0:
        break
    
    count += 1
        
print(count)
