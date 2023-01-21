def solution(num, total):
    answer = []
    a = ((2 * total // num) - (num - 1)) // 2
    for i in range(a, a + num):
        answer.append(i)
    return answer