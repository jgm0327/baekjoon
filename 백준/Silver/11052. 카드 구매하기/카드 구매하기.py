import sys

input = sys.stdin
n = int(input.readline())
card_packs = [0] + list(map(int, input.readline().split()))
dp = [0] * (n + 1)
answer = 0

for i in range(1, n + 1):
    dp[i] = card_packs[i]
    for j in range(1, i):
        if i % j == 0:
            dp[i] = max(dp[i], dp[j] * (i // j))
        dp[i] = max(dp[i], dp[j] + dp[i - j])
print(dp[n])