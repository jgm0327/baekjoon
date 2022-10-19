def solution(array, commands):
    answer = []
    for command in commands:
        start, end, idx = command
        temp = sorted([data for data in array[start-1:end]])[idx-1]
        answer.append(temp)
    return answer