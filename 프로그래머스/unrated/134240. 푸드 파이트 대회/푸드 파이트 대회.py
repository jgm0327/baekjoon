def solution(food):
    answer = ''
    temp = ''
    for idx in range(1, len(food)):
        if food[idx] < 2:
            continue
        for i in range(food[idx]//2):
            temp += str(idx)
    answer = temp + '0' + temp[::-1]
    return answer