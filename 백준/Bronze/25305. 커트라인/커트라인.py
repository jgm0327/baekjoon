n, m = map(int, input().split())
scores = [0] + sorted(list(map(int, input().split())), reverse=True)
print(scores[m])
