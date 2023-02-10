from sys import stdin

coins = [25, 10, 5, 1]
n = int(stdin.readline())
for money in [int(stdin.readline()) for _ in range(n)]:
    for coin in coins:
        print(money // coin, end=' ')
        money %= coin
    print()
