import sys
from collections import deque

input = sys.stdin

size = int(input.readline())
que = deque()
cnt = 0

while True:
    packet = int(input.readline())
    if packet == -1:
        break
    if packet == 0:
        if que:
            que.popleft()
        cnt -= 1
        continue
    if size <= cnt:
        continue
    que.append(str(packet))
    cnt += 1

if cnt == 0:
    print('empty')
else:
    print(' '.join(que))