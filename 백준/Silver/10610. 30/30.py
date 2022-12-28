import sys

digits = sorted(list(sys.stdin.readline().rstrip()), reverse=True)
if digits[-1] != '0' or int(''.join(digits)) % 3 != 0:
    print(-1)
    exit(0)
print(''.join(digits))
