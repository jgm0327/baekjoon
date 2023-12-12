import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())

students = [[] for _ in range(n + 1)]
preceding_count = [0] * (n + 1)
answer = []

for sour, des in [list(map(int, input().split())) for _ in range(m)]:
    students[sour].append(des)
    preceding_count[des] += 1


def topology_sort():
    global n, students, preceding_count
    
    que = deque()
    finished = [False] * (n + 1)

    for sour in range(1, n + 1):
        if preceding_count[sour] == 0:
            finished[sour] = True
            que.append(sour)

    while que:
        sour = que.popleft()
        print(sour, end=' ')
        
        for des in students[sour]:
            if finished[des]:
                continue
            
            preceding_count[des] -= 1

            if preceding_count[des] == 0:
                que.append(des)
                finished[des] = True

topology_sort()
