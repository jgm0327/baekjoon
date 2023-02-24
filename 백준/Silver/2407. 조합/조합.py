n, m = map(int, input().split())
dp = [[0]*(n+1) for _ in range(n+1)]
def combination(n: int, m: int) -> int:
    global dp
    if n == m or m == 0:
        return 1
    if dp[n][m]:
        return dp[n][m]
    dp[n][m] = combination(n - 1, m - 1) + combination(n - 1, m)
    return dp[n][m]

print(combination(n, m))
