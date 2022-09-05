import sys

while True:
    try:
        n = int(sys.stdin.readline())
    except EOFError:
        break
    except ValueError:
        break

    numbers = []
    for i in range(n):
        numbers.append(sys.stdin.readline().rstrip())
    result = {}
    for number in numbers:
        number = sorted(set(number))
        result[''.join(number)] = 1
    print(len(result))