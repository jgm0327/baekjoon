from sys import stdin

words = stdin.readline().rstrip()
answer = ''
stack = []
tmp = ''
for ch in words:
    if ch == '>':
        answer += (''.join(stack) + ch)
        stack = []
    elif ch == '<' or stack:
        answer += tmp[::-1]
        tmp = ''
        stack.append(ch)
    elif ch == ' ':
        answer += (tmp[::-1] + ' ')
        tmp = ''
    else:
        tmp += ch
print(answer + tmp[::-1])
