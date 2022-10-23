def solution(answers):
    answer = []
    method = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]]
    students = [0,0,0]
    rotate = [5, 8, 10]
    for i in range(len(answers)):
        for j in range(3):
            if method[j][i % rotate[j]] == answers[i]:
                students[j] += 1
    
    max_value = max(students)
    for i in range(3):
        if students[i] == max_value:
            answer.append(i+1)
    return answer