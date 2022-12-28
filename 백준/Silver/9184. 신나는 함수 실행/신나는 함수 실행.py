import sys


def recur(a, b, c):
    global dp
    if dp[a][b][c]:
        return dp[a][b][c]
    if a <= 0 or b <= 0 or c <= 0:
        dp[a][b][c] = 1
    elif a > 20 or b > 20 or c > 20:
        dp[a][b][c] = recur(20, 20, 20)
    elif a < b < c:
        dp[a][b][c] = recur(a, b, c - 1) + recur(a, b - 1, c - 1) - recur(a, b - 1, c)
    else:
        dp[a][b][c] = recur(a - 1, b, c) + recur(a - 1, b - 1, c) + recur(a - 1, b, c - 1) - recur(a - 1, b - 1, c - 1)
    return dp[a][b][c]


dp = [[[0] * 101 for j in range(101)] for i in range(101)]
while True:
    A, B, C = map(int, sys.stdin.readline().split())
    if A == -1 and B == -1 and C == -1:
        break
    print('w(%d, %d, %d) = %d' % (A, B, C, recur(A, B, C)))
