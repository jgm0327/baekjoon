import math
from collections import deque

def solution(progresses, speeds):
    answer = []
    progresses = deque(progresses)
    speeds = deque(speeds)
    
    for day in range(101):
        cnt = 0
        while progresses and progresses[0] + speeds[0] * day >= 100:
            progresses.popleft()
            speeds.popleft()
            cnt += 1
        if cnt:
            answer.append(cnt)
        if not progresses:
            break
    
    return answer