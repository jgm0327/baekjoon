from sys import stdin
from collections import deque

n = int(stdin.readline())
m = int(stdin.readline())

target = 'IOI' + 'OI' * (n - 1)
s = stdin.readline().rstrip()
end = len(target)
answer = 0
comp = deque(list(s[:end]))
while True:
    if ''.join(comp) == target:
        answer += 1
    if end >= m:
        break
    comp.popleft()
    comp.append(s[end])
    end += 1
print(answer)
    
