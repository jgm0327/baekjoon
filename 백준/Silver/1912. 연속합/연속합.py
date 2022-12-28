import sys

input = sys.stdin
n = int(input.readline())
num_list = list(map(int, input.readline().split()))

dp = [0] * (n + 1)
dp[0] = num_list[0]
answer = num_list[0]
for i in range(1, n):
    dp[i] = max(num_list[i], dp[i-1] + num_list[i])
    answer = max(dp[i], answer)

print(answer)