from sys import stdin

n = int(stdin.readline())
dairy_products = sorted(list(int(stdin.readline()) for _ in range(n)), reverse=True)
answer = 0
for i in range(0, n, 3):
    answer += sum(dairy_products[i:i+2])
print(answer)
