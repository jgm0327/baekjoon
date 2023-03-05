from sys import stdin
stack = []
for _ in range(int(input())):
    num = int(stdin.readline())
    if stack and num == 0:
        stack.pop()
    else:
        stack.append(num)
print(sum(stack))

