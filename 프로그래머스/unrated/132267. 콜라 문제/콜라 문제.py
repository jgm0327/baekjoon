def solution(a, b, n):
    answer = 0
    while True:
        mod = n % a
        bottle = (n // a) * b
        answer += bottle
        n = bottle + mod
        if bottle == 0 or n < 2:
            break
        
    return answer