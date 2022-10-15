def solution(x):
    answer = True
    temp, total = x, 0
    
    while temp:
        total += temp % 10
        temp //= 10
    if x % total:
        answer = False
    return answer