import sys

paragraph = sys.stdin.readline().rstrip()
minus = 1
number = ''
answer = 0
for ch in paragraph:
    if '0' <= ch <= '9':
        number += ch
    else:
        answer += minus * int(number)
        if ch == '-':
            minus = -1
        number = ''
answer += minus * int(number)
print(answer)