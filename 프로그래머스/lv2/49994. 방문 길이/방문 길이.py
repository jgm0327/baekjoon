def solution(dirs):
    answer = 0
    dir_dict = {'U': 0, 'D': 1, 'R':2, 'L': 3}
    reverse_dict = {'U': 1, 'D': 0, 'R':3, 'L': 2}
    dy, dx = [-1, 1, 0, 0], [0, 0, 1, -1]
    y = x = 5
    graph = [[[False, False, False, False] for j in range(11)]  for _ in range(11)]
    
    for direc in dirs:
        idx = dir_dict[direc]
        reverse_idx = reverse_dict[direc]
        next_y, next_x = dy[idx] + y, dx[idx] + x
        if (next_y < 0 or next_y > 10) or (next_x < 0 or next_x > 10):
            continue
            
        if not graph[y][x][idx]:
            answer += 1
            graph[y][x][idx] = True
            graph[next_y][next_x][reverse_idx] = True
        y, x = next_y, next_x
    
    
    return answer