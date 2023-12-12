n, m = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(n)]

chicken = []
house = []

for i in range(n):
    for j in range(n):
        if board[i][j] == 1:
            house.append((i, j))
        elif board[i][j] == 2:
            chicken.append((i, j))

chicken_count = len(chicken)
visit = [False] * chicken_count


def find_shortest_distance(opened):
    global house, answer

    total = 0
    for hy, hx in house:
        min_value = n * n
        
        for cy, cx in opened:
            min_value = min(min_value, abs(hy-cy) + abs(hx-cx))

        total += min_value
        if total > answer:
            return
        
    answer = min(answer, total)
            

def backtracking(start, opened):
    global visit, m, chicken, house, chicken_count
    
    if len(opened) == m:
        find_shortest_distance(opened)
        return
    
    for i in range(start, chicken_count):
        y, x = chicken[i]
        
        if visit[i]:
            continue
        
        visit[i] = True
        opened.append((y, x))
        
        backtracking(i + 1, opened)

        opened.pop()
        visit[i] = False


answer = int(1e4)
backtracking(0, [])
print(answer)
