from sys import stdin

n, m = map(int, stdin.readline().split())
coins = [int(stdin.readline()) for _ in range(n)]
answer = 0
for coin in coins[::-1]:
    if m == 0:
        break
    answer += m // coin
    m %= coin
print(answer)

