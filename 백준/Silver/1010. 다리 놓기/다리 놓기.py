from sys import stdin


def combination(r, s):
    if dp[r][s]:
        return dp[r][s]
    if r == s or s == 0:
        dp[r][s] = 1
        return dp[r][s]
    dp[r][s] = combination(r - 1, s - 1) + combination(r - 1, s)
    return dp[r][s]


T = int(stdin.readline())
dp = [[0] * 30 for _ in range(30)]
for _ in range(T):
    n, m = map(int, stdin.readline().split())
    print(combination(m, n))