from sys import stdin

n, m = map(int, stdin.readline().split())
hear = {}.fromkeys([stdin.readline() for _ in range(n)], True)
look = [stdin.readline() for _ in range(m)]

answer = []
for data in look:
    if hear.get(data) is not None:
        answer.append(data)
print(len(answer))
print(''.join(sorted(answer)))
