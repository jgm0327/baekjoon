n = int(input())

tri = [list(map(int, input().split(' '))) for _ in range(n)]
dp = [[0]*len(tri[i]) for i in range(n)]

dp[-1] = tri[-1]

for i in range(n - 2, -1, -1):
    for j in range(len(tri[i])):
        dp[i][j] = max(dp[i+1][j], dp[i+1][j+1]) + tri[i][j]
print(*dp[0])
