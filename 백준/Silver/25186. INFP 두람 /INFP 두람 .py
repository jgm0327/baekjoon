import sys


def solution():
    n = int(sys.stdin.readline())
    friends = list(map(int, sys.stdin.readline().split()))
    Sum = sum(friends)
    if n == 1 and Sum < 2:
        print('Happy')
        return
    halfOfPeople = Sum // 2

    for i in range(n):
        if friends[i] > halfOfPeople:
            print('Unhappy')
            return
    print('Happy')


solution()
