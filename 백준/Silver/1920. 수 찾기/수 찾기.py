import sys

input = sys.stdin

n = int(input.readline())
numbers = {}.fromkeys(list(map(int, input.readline().split())), True)
m = int(input.readline())
targets = list(map(int, input.readline().split()))

for target in targets:
    print(1 if numbers.get(target) is not None else 0)
