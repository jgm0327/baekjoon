def solution(land):
    n, m = len(land), 4
    answer = [[[0, -1]] * m for _ in range(n)] # 점수, 전에 밟은 열의 인덱스
    
    for j in range(m):
        answer[0][j] = [land[0][j], j]
        
    for i in range(1, n):
        for j in range(m):
            cnt, idx = 0, 0
            for k in range(m):
                if cnt < answer[i-1][k][0] and answer[i-1][k][1] != j:
                    cnt = answer[i-1][k][0]
                    idx = k
            answer[i][j] = [(land[i][j] + answer[i-1][idx][0]), j]
            
            
    return max(answer[i])[0]