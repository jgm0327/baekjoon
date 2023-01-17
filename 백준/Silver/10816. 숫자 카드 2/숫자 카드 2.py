import sys


def solution():
    n = int(sys.stdin.readline())
    s = list(sys.stdin.readline().split())
    numbers = {}
    for num in s:
        if numbers.get(num) != None:
            numbers[num] += 1
        else:
            numbers[num] = 1

    m = int(sys.stdin.readline())
    targets = list(sys.stdin.readline().split())
    for target in targets:
        if numbers.get(target) != None:
            print(numbers[target], end=' ')
        else:
            print(0, end= ' ')

solution()
