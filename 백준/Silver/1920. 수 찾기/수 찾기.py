import sys


def solution():
    n = int(sys.stdin.readline())
    s = list(sys.stdin.readline().split())
    numbers = {}.fromkeys(s, 0)
    m = int(sys.stdin.readline())
    targets = list(sys.stdin.readline().split())
    for target in targets:
        if numbers.get(target) != None:
            print(1)
        else:
            print(0)


solution()
