import sys

n = int(sys.stdin.readline())

n1, n2 = 3, 7
result = n1 if n == 1 else n2
for i in range(2, n):
    result = (n1 + 2*n2) % 9901
    n1 = n2
    n2 = result
print(result)