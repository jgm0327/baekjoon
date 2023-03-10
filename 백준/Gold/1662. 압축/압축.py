compression = input().rstrip()
stack = []
n = len(compression)
answer = 0
cnt = 0
for idx, ch in enumerate(compression):
    if '0' <= ch <= '9':
        if stack and stack[-1] != '(':
            stack[-1] += 1
        else:
            stack.append(1)
    elif ch == '(':
        if stack and stack[-1] != '(':
            stack[-1] -= 1
        if idx > 0:
            stack.append(int(compression[idx-1]))
        stack.append(ch)
        cnt = 0
    else:
        tmp = 0
        stack.append(cnt)
        while stack:
            if stack[-1] == '(':
                stack.pop()
                mul = int(stack.pop())
                stack.append(mul * tmp)
                break
            else:
                tmp += stack.pop()


print(sum(stack))
