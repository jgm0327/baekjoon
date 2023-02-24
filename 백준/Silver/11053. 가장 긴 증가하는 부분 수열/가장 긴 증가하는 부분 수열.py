n = int(input())
num_list = list(map(int, input().split()))
dp = [1] * n
for i in range(n):
    for j in range(i + 1, n):
        if num_list[i] < num_list[j]:
            dp[j] = max(dp[j], dp[i] + 1)

print(max(dp))
