import sys

input = sys.stdin

n = int(input.readline())
levels = []
for _ in range(n):
    levels.append(int(input.readline()))

answer = 0
for idx in range(n - 2, -1, -1):
    diff = levels[idx] - levels[idx + 1]
    if diff < 0:
        continue
    levels[idx] -= (diff + 1)
    answer += (diff + 1)

print(answer)