import sys

input = sys.stdin

n = int(input.readline())
num_list = list(map(int, input.readline().split()))
dp = [0] * n
dp[0] = num_list[0]
asc = desc = 1
max_value = 1

for i in range(1, n):
    if dp[i - 1] == num_list[i]:
        asc += 1
        desc += 1
    elif dp[i - 1] > num_list[i]:
        asc += 1
        desc = 1
    else:
        asc = 1
        desc += 1
    dp[i] = num_list[i]
    max_value = max(max_value, asc, desc)
print(max_value)
