def binary_num(n):
    one_cnt = 0
    while n:
        if n % 2 == 1:
            one_cnt += 1
        n //= 2
        
    return one_cnt

def solution(n):
    first = binary_num(n)
    for i in range(n+1, 1000001):
        compare = binary_num(i)
        if first == compare:
            return i
    