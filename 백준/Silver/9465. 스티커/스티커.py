import sys

input = sys.stdin
T = int(input.readline())

for _ in range(T):
    n = int(input.readline())
    dp = [[0] * n for i in range(2)]
    stickers = []
    for i in range(2):
        stickers.append(list(map(int, input.readline().split())))

    dp[0][0], dp[1][0] = stickers[0][0], stickers[1][0]
    if n > 1:
        dp[0][1] = stickers[0][1] + dp[1][0]
        dp[1][1] = stickers[1][1] + dp[0][0]
    for i in range(2, n):
        max_value = dp[0][i - 2] if dp[1][i - 2] < dp[0][i - 2] else dp[1][i - 2]
        dp[0][i] = max_value + stickers[0][i] if dp[1][i - 1] + stickers[0][i] < max_value + stickers[0][i] \
            else dp[1][i - 1] + stickers[0][i]
        dp[1][i] = max_value + stickers[1][i] if dp[0][i - 1] + stickers[1][i] < max_value + stickers[1][i] \
            else dp[0][i - 1] + stickers[1][i]
    print(dp[0][-1] if dp[0][-1] > dp[1][-1] else dp[1][-1])
