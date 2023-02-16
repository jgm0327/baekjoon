from sys import stdin
from collections import deque

while True:
    try:
        s, t = stdin.readline().rstrip().split()
        s = deque(s)
        idx, n = 0, len(t)
        while s and idx < n:
            if t[idx] == s[0]:
                s.popleft()
            idx += 1
        print('No' if s else 'Yes')
    except:
        break
