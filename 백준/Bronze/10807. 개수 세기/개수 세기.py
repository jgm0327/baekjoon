from sys import stdin

cnt = [0] * 201
n = int(stdin.readline())
for num in list(map(int, stdin.readline().split())):
    cnt[num] += 1
print(cnt[int(stdin.readline())])
