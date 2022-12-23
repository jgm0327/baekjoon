def gcd(m, n):
    if n == 0:
        return m
    if m % n == 0:
        return n
    return gcd(n, m%n)

def solution(n, m):
    answer = [0, 0]
    if n > m:
        n, m = m, n
    answer[0] = gcd(m, n)
    answer[1] = m if m % n == 0 else (m * n) // answer[0]
    
    
    return answer