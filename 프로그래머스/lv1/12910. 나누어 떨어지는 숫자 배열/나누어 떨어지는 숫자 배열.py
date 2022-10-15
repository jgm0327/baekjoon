def solution(arr, divisor):
    answer = []
    arr.sort()
    for data in arr:
        if data % divisor == 0:
            answer.append(data)
    return answer if answer else [-1]