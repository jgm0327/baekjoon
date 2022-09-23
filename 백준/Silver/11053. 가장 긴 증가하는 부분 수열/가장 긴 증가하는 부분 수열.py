import sys

n = int(sys.stdin.readline())
num_list = list(map(int, sys.stdin.readline().split()))
dp = [1] * n

for i in range(n):
    for j in range(i + 1, n):
        if num_list[i] < num_list[j]:
            dp[j] = dp[i] + 1 if dp[j] < (dp[i] + 1) else dp[j]

print(max(dp))