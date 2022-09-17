import sys

read = sys.stdin
n, m = map(int, read.readline().split())
pipe = list(map(int, read.readline().split()))
pipe.sort()
temp = 0
answer = 1
for i in range(1, n):
    dist = pipe[i] - pipe[i - 1]
    if temp + dist < m:
        temp += dist
    else:
        temp = 0
        answer += 1

print(answer)
