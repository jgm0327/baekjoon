import sys

input = sys.stdin

paragraph1 = input.readline().rstrip()
paragraph2 = input.readline().rstrip()

n1, n2 = len(paragraph1), len(paragraph2)

dp = [[0] * (n2 + 1) for _ in range(n1 + 1)]

for i in range(1, n1 + 1):
    for j in range(1, n2 + 1):
        dp[i][j] = dp[i - 1][j - 1] + 1 if paragraph1[i - 1] == paragraph2[j - 1] else max(dp[i - 1][j], dp[i][j - 1])
print(dp[-1][-1])
