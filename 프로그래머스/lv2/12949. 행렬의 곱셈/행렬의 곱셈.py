def solution(arr1, arr2):
    #3x2  2x2
    n, m = len(arr1), len(arr2[0])
    size = len(arr1[0])
    answer = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            value = 0
            for idx in range(size):
                value += arr1[i][idx] * arr2[idx][j]
            answer[i][j] = value
    return answer