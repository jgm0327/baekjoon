def solution(n):
    answer = 0
    trinary_digit = []
    
    while n > 0:
        trinary_digit.append(n % 3)
        n //= 3
    
    digit = 1
    
    for number in trinary_digit[::-1]:
        answer += digit * number
        digit *= 3
    
    return answer