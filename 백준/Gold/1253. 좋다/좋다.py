import sys


def solution():
    n = int(sys.stdin.readline())

    numbers = list(map(int, sys.stdin.readline().split()))
    numbers.sort()

    result = 0

    for i in range(n):
        temp = numbers[:i] + numbers[i + 1:]
        start, end = 0, len(temp) - 1
        while start < end:
            n1, n2 = temp[start], temp[end]
            if numbers[i] == (n1 + n2):
                result += 1
                break
            if numbers[i] > (n1 + n2):
                start += 1
            else:
                end -= 1
    print(result)


solution()
