from sys import stdin

n,m = map(int, stdin.readline().split())
titles = {}
powers = []
max_value = 0
for _ in range(n):
    title, power = stdin.readline().rstrip().split()
    power = int(power)
    powers.append(power)
    if titles.get(power) is None:
        titles[power] = title
        max_value = power

for player in [int(stdin.readline()) for _ in range(m)]:
    start, end = 0, n - 1
    result = 0
    while start <= end:
        mid = (start + end) // 2
        if powers[mid] < player:
            start = mid + 1
        else:
            result = mid
            end = mid - 1
    print(titles[powers[result]])
