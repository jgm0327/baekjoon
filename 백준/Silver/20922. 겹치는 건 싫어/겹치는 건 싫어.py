from sys import stdin
from collections import defaultdict

n, k = map(int, stdin.readline().split())
numbers = list(map(int, stdin.readline().split()))
start = end = 0
count = defaultdict(int)
answer = 0
while end < n:
    if count[numbers[end]] + 1 <= k:
        count[numbers[end]] += 1
        end += 1
    else:
        count[numbers[start]] -= 1
        start += 1
    result = (end - start)
    answer = answer if answer > result else result

print(answer)