import sys

n = int(sys.stdin.readline())
answer = 0
dp = [int(1e9)] * (n + 7)
dp[2] = dp[5] = 1

for i in range(3, n + 1):
    dp[i] = min(dp[i - 2] + 1, dp[i - 5] + 1, dp[i])
print(dp[n] if int(1e9) > dp[n] else -1)
