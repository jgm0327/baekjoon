input()
arr = list(map(int, input().split()))
rank = {}
for i, num in enumerate(sorted(set(arr), reverse=True)):
    rank[num] = i + 1
n = len(rank)
for num in arr:
    print(n - rank[num], end=' ')

