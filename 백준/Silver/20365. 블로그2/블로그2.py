from sys import stdin

n = int(stdin.readline())
colors = list(stdin.readline().rstrip())
count = {'B':0, 'R':0}
count[colors[0]] += 1
for i in range(1, n):
    if colors[i] != colors[i - 1]:
        count[colors[i]] += 1
print(min(count['B'], count['R']) + 1)
