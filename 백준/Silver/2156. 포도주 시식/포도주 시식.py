import sys

input = sys.stdin
n = int(input.readline())
wines = []
for _ in range(n):
    wines.append(int(input.readline()))
dp = [[0] * 2 for _ in range(n)]  # [바로 앞 마시지 안읂거 바로 앞 마신거]
dp[0] = [wines[0], wines[0]]
if n > 1:
    dp[1] = [wines[1], wines[0] + wines[1]]

for i in range(2, n):
    dp[i][0] = max(dp[i - 2][0], dp[i - 2][1]) + wines[i]
    dp[i][1] = max(dp[i - 1][0] + wines[i], dp[i - 1][1])

print(max(dp[n - 1]))
