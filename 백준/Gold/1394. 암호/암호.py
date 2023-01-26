import sys


def solution():
    input_data = sys.stdin.readline().rstrip()
    alphabets = {}
    for i in range(len(input_data)):
        alphabets[input_data[i]] = (i + 1)

    target = list(sys.stdin.readline().rstrip())
    n = 1
    length = len(input_data)
    result = 0

    for i in range(len(target) - 1, -1, -1):
        result = (result + (n * alphabets[target[i]]))
        n = (n * length) % 900528

    print(result % 900528)


solution()
