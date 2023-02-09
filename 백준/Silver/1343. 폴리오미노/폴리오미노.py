from sys import stdin

board = list(stdin.readline().rstrip())
cnt = 0
answer=''

for ch in board:
    if ch == 'X':
        cnt += 1
    else:
        answer += 'AAAA' * (cnt // 4)
        cnt %= 4
        answer += 'BB'*(cnt//2)
        cnt %= 2
        if cnt:
            break
        answer += '.'
answer += 'AAAA' * (cnt // 4)
cnt %= 4
answer += 'BB'*(cnt//2)
cnt %= 2
print(answer if cnt == 0 else -1)
