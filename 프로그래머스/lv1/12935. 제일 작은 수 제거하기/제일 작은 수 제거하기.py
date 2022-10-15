def solution(arr):
    answer = []
    min_value = min(arr)
    for data in arr:
        if data != min_value:
            answer.append(data)
    return answer if answer else [-1]