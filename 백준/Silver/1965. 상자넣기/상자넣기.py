import sys

input = sys.stdin

n = int(input.readline())
boxes = list(map(int, input.readline().split()))
dp = [[0, data] for data in boxes] + [[0, 0]]
dp[0][0] = 1
max_value = 0
for i in range(1, n + 1):
    for j in range(i):
        if dp[j][0] >= dp[i][0] and dp[i][1] > dp[j][1]:
            dp[i] = [dp[j][0], dp[i][1]]
    dp[i][0] += 1
    max_value = max_value if max_value > dp[i][0] else dp[i][0]
print(max_value)

