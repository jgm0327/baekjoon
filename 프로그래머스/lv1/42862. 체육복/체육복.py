def solution(n, lost, reserve):
    reserved_student = dict.fromkeys(reserve, 0)
    visit = [False] * (n + 1)
    answer = n - len(lost)
    lost.sort()
    
    for student in lost:
        if reserved_student.get(student) != None:
            answer += 1
            reserved_student.pop(student)
            visit[student] = True
            
    for lost_student in lost:
        cur = lost_student
        prev, next_ = cur - 1, cur + 1
        if reserved_student.get(prev) != None and not visit[cur]:
            reserved_student.pop(prev)
            answer += 1
        elif reserved_student.get(next_) != None and not visit[cur]:
            reserved_student.pop(next_)
            answer += 1
    return answer