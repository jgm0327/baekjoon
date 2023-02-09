from sys import stdin

n = int(stdin.readline())
losses = sorted(list(map(int, stdin.readline().split())))
tmp1 = tmp2 = 0
for i in range(n//2):
    value = losses[i] + losses[-(i + 1)]
    tmp1 = max(tmp1, value)

idx = 0
while n % 2 and idx < n // 2 - 1:
    value = losses[idx] + losses[-(idx+2)]
    idx += 1
    tmp2 = max(tmp2, value)
    
print(min(tmp1, tmp2) if n%2 else tmp1)
