from collections import deque

def solution(queue1, queue2):
    answer = 0
    queue1, queue2 = deque(queue1), deque(queue2)
    sum1, sum2 = sum(queue1), sum(queue2)
    flag = False
    for _ in range(300000):
        while queue1 and sum1 > sum2:
            data = queue1.popleft()
            queue2.append(data)
            answer += 1
            sum1, sum2 = sum1 - data, sum2 + data
            
        while queue2 and sum1 < sum2:
            data = queue2.popleft()
            queue1.append(data)
            answer += 1
            sum1, sum2 = sum1 + data, sum2 - data
            
        if sum1 == sum2:
            flag = True
            break
        if not sum1 or not sum2:
            break
            
    if not flag:
        answer = -1
    return answer