def solution(num):
    answer = 0
    for i in range(500):
        if num == 1:
            return i
        if num % 2:
            num = num * 3 + 1
        else:
            num //= 2
    return -1