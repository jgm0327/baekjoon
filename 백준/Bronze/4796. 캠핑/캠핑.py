from sys import stdin

idx = 1
while True:
    L, P, V = map(int, stdin.readline().split())
    if L == 0 and P == 0 and V == 0:
        break
    answer = 0
    for i in range(1, V + 1, P):
        answer += (L if i + L - 1 <= V else V - i + 1)
    print('Case %d: %d' % (idx, answer))
    idx += 1
