import sys

input = sys.stdin
n, m = map(int, input.readline().split())
number = sys.stdin.readline().rstrip()
stack = []
M = m
for num in number:
    while M > 0 and stack and stack[-1] < num:
        stack.pop()
        M -= 1
    stack.append(num)
print(''.join(stack[:n-m]))