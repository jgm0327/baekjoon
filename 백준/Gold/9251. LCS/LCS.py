A = [''] + list(input())
B = [''] + list(input())

n = len(A)
m = len(B)

dp = [[0] * m for _ in range(n)]

for i in range(1, n):
    for j in range(1, m):
        if A[i] == B[j]:
            dp[i][j] = dp[i-1][j-1] + 1
            continue
        
        dp[i][j] = max(dp[i-1][j], dp[i][j - 1])


print(dp[-1][-1])
