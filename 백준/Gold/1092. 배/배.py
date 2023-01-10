import sys
from collections import deque

input = sys.stdin

n = int(input.readline())
cranes = sorted(list(map(int, input.readline().split())), reverse=True)
m = int(input.readline())
boxes = deque(sorted(list(map(int, input.readline().split())), reverse=True))
answer = 0

if cranes[0] < boxes[0]:
    print(-1)
    exit(0)
while boxes:
    for crane in cranes:
        for box in boxes:
            if box <= crane:
                boxes.remove(box)
                break
    answer += 1
print(answer)