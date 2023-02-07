from sys import stdin

n = int(stdin.readline())
stones = list(map(int, stdin.readline().split()))
INF = int(1e10)
dp = [INF] * n
dp[0] = 0
for i in range(1, n):
    for j in range(i):
        power = (i - j) * (1 + abs(stones[i] - stones[j]))
        comp = dp[j] if dp[j] > power else power
        dp[i] = dp[i] if dp[i] < comp else comp
print(dp[-1])
