from collections import deque

n = int(input())
numbers = list(map(int, input().split()))

ballons = deque()

for i in range(n):
    ballons.append((numbers[i], (i + 1)))

while ballons:
    move_cnt, idx = ballons.popleft()
    
    print(idx, end=' ')
    
    if not ballons:
        break

    if move_cnt > 0:
        for _ in range(move_cnt - 1):
            ballons.append(ballons.popleft())
        continue
    
    for _ in range(-move_cnt):
        ballons.appendleft(ballons.pop())
