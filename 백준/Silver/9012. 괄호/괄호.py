import sys

T = int(sys.stdin.readline())

for _ in range(T):
    s = sys.stdin.readline()
    stack = []

    flag = True
    for ch in s:
        if ch == '(':
            stack.append(ch)
        elif ch == ')':
            if stack:
                stack.pop()
            else:
                flag = False
                break

    print('YES' if flag and not stack else 'NO')
