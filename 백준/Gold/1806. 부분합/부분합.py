from sys import stdin

n, target = map(int, stdin.readline().split())
numbers = list(map(int, stdin.readline().split()))

start = end = 0
total = 0
answer = int(1e9)
while start <= end:
    if total >= target:
        comp = end - start
        answer = answer if answer < comp else comp
        total -= numbers[start]
        start += 1
    else:
        if end >= n:
            break
        total += numbers[end]
        end += 1

print(answer if answer != int(1e9) else 0)
