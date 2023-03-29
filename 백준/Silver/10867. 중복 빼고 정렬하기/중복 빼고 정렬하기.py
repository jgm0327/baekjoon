from sys import stdin

input()
print('\n'.join(sorted(list(set(stdin.readline().split())), key=lambda x: int(x))))

