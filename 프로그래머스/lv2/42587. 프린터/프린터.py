from collections import deque

def solution(priorities, location):
    answer = 0
    que = deque([(idx, priority) for (idx, priority) in enumerate(priorities)])
    n = len(priorities)
    while que:
        flag = True
        cur_loc = que[0]
        que.popleft()
        for idx in range(n):
            if priorities[idx] > cur_loc[1]:
                que.append(cur_loc)
                flag = False
                break
        if flag:
            priorities[cur_loc[0]] = -1
            answer += 1
            if cur_loc[0] == location:
                break
    return answer