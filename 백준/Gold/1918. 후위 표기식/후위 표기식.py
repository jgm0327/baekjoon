postfix_notation = input()

stack = []

answer = ''

for ch in postfix_notation:
    if 'A' <= ch <= 'Z':
        answer += ch
        continue

    if ch == '(':
        stack.append(ch)

    elif ch == '*' or ch == '/':
        while stack and (stack[-1] == '*' or stack[-1] == '/'):
            answer += stack.pop()
        stack.append(ch)

    elif ch == '+' or ch == '-':
        while stack and stack[-1] != '(':
            answer += stack.pop()
        stack.append(ch)

    elif ch == ')':
        while stack and stack[-1] != '(':
            answer += stack.pop()
        stack.pop()

while stack:
    answer += stack.pop()
print(answer)
