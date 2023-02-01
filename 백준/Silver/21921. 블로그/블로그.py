import sys

input = sys.stdin

n, m = map(int, input.readline().split())
visitors = list(map(int, input.readline().split()))
answer, cnt = sum(visitors[0:m]), 1
prev = answer
start, end = 0, m
while end < n:
    next_value = prev + (visitors[end] - visitors[start])
    if next_value > answer:
        answer = next_value
        cnt = 1
    elif next_value == answer:
        cnt += 1
    prev = next_value
    end += 1
    start += 1
if answer == 0:
    print('SAD')
    exit(0)
print(answer)
print(cnt)
