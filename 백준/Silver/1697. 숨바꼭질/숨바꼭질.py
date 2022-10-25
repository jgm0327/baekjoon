import sys
from collections import deque
from collections import defaultdict

n, m = map(int, sys.stdin.readline().split())


def bfs(start, target):
    que = deque()
    que.append([start, 0])
    dx = [-1, 1, 2]
    answer = abs(target - start)
    visit = defaultdict(bool)
    visit[start] = True
    while que:
        cur_pos, cur_cnt = que.popleft()
        if cur_pos == target:
            answer = answer if cur_cnt > answer else cur_cnt
        for i in range(3):
            next_pos = cur_pos + dx[i] if i < 2 else cur_pos * dx[i]
            if 0 <= next_pos <= target * 2 and not visit[next_pos]:
                que.append([next_pos, cur_cnt + 1])
                visit[next_pos] = True

    return answer

print(bfs(n, m))