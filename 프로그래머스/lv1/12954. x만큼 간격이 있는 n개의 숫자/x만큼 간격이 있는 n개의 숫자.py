def solution(x, n):
    answer = []
    if x == 0:
        return [0] * n
    end = x * n + 1 if x >= 0 else x * n - 1
    for number in range(x, end, x):
        answer.append(number)
    return answer