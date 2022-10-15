def solution(n):
    answer = 0
    end = 7071067
    for i in range(1, end+1):
        if i > n:
            break
        if int(i * i) == n:
            return (i+1) * (i+1)
    return -1