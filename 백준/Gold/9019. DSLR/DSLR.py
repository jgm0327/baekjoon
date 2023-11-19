from collections import deque
from sys import stdin

input = stdin.readline

T = int(input())


def bfs(start, target):
    que = deque()
    que.append((start, ''))
    visit = [False] * 10000
    
    while que:
        cur, path = que.popleft()
        #print(path, cur)
        
        D = (2 * cur) % 10000
        if D == target:
            return path + 'D'
        if not visit[D]:
            visit[D] = True
            que.append((D, path + 'D'))

        S = cur - 1 if cur else 9999
        if S == target:
            return path + 'S'
        if not visit[S]:
            visit[S] = True
            que.append((S, path + 'S'))

        str_cur = str(cur)
        L = int(str_cur[1:] + str_cur[0]) if len(str_cur) == 4 else int(str_cur) * 10
        if L == target:
            return path + 'L'
        if not visit[L]:
            visit[L] = True
            que.append((L, path + 'L'))

        R = int(str_cur[-1] + str_cur[:-1]) if len(str_cur) == 4 else int(str_cur[-1] + '0' * (4 - len(str_cur)) + str_cur[:-1])
        if R == target:
            return path + 'R'
        if not visit[R]:
            visit[R] = True
            que.append((R, path + 'R'))


for _ in range(T):
    s, t = map(int, input().split())
    print(bfs(s, t))


