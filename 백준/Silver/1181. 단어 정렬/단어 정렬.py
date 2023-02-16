from sys import stdin

n = int(stdin.readline())
words = sorted(set([stdin.readline() for _ in range(n)]), key=lambda x: [len(x), x])
print(''.join(words))