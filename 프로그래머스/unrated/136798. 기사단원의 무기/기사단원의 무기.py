def solution(number, limit, power):
    answer = 0
    divisor = [1]
    
    for i in range(2, number + 1):
        cnt = 0
        for j in range(1, int(i**(1/2)) + 1):
            if i % j == 0:
                cnt += 1
                if j**2 != i:
                    cnt += 1
        divisor.append(cnt)
    for number in divisor:
        answer += number if number <= limit else power
    return answer