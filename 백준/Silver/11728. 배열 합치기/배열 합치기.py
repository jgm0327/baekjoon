from sys import stdin

n, m = map(int, stdin.readline().split())
A = list(map(int, stdin.readline().split()))
B = list(map(int, stdin.readline().split()))
for data in sorted(A + B):
    print(data, end=' ')