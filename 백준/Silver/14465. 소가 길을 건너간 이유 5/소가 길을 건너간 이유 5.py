from sys import stdin

n, k, b = map(int, stdin.readline().split())
signals = [data for data in range(n + 1)]
broken = {}.fromkeys([int(stdin.readline()) for _ in range(b)], True)
start, end = 1, k + 1

total = 0
for i in range(1, k + 1):
    if broken.get(i) is not None:
        total += 1
        
answer = total
while end <= n:
    if broken.get(start) is not None:
        total -= 1
    if broken.get(end) is not None:
        total += 1
    start += 1    
    end += 1
    answer = min(answer, total)
print(answer)
