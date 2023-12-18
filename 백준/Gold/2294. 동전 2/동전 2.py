n, k = map(int, input().split())

coins = sorted([int(input()) for _ in range(n)])

dp = [100001] * (k + 1)
dp[0] = 0

for coin in coins:
    for i in range(coin, k + 1):
        dp[i] = min(dp[i], dp[i - coin] + 1)

print(dp[k] if dp[k] != 100001 else '-1')