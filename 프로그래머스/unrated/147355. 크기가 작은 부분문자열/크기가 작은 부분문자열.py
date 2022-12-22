def solution(t, p):
    answer = 0
    numbers = []
    length = len(p)
    for i in range(0, len(t) - length + 1):
        numbers.append(int(t[i : (i + length)]))
    for number in numbers:
        if number <= int(p):
            answer += 1
    return answer