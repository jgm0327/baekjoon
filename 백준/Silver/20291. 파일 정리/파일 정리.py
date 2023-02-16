from sys import stdin
from collections import defaultdict

n = int(stdin.readline())
filenames = [stdin.readline().rstrip().split('.')[1] for _ in range(n)]
count = defaultdict(int)
for filename in filenames:
    count[filename] += 1
for key in sorted(count.keys()):
    print(key, count[key])
