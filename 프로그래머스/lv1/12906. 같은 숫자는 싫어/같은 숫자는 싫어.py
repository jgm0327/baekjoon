def solution(arr):
    answer = []
    for number in arr:
        if answer and answer[-1] == number:
            continue
        answer.append(number)
    return answer