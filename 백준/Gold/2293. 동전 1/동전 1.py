from sys import stdin

n, k = map(int, input().split())
coins = sorted(list(int(stdin.readline()) for _ in range(n)))
dp = [0] * (k+1)
dp[0] = 1
for i in range(n):
    coin = coins[i]
    for j in range(coin, k+1):
        dp[j] += dp[j - coin]
print(dp[k])

