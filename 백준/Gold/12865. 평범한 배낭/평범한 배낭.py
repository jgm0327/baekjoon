import sys


def solution():
    n, k = map(int, sys.stdin.readline().split())
    back_pack = [[]]
    dp = [[0]*(k+1) for _ in range(n+1)]

    for _ in range(n):
        back_pack.append(list(map(int, sys.stdin.readline().split())))

    for i in range(1, n+1):
        weight, value = back_pack[i]
        for j in range(1, k+1):
            if weight <= j:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight] + value)
            else:
                dp[i][j] = dp[i-1][j]

    print(dp[n][k])


solution()
