from sys import stdin

while True:
    pwd = stdin.readline().rstrip()
    if pwd == 'end':
        break

    first = False
    for ch in ['a', 'e', 'i', 'o', 'u']:
        if ch in pwd:
            first = True
            break

    second = True
    prev = pwd[0]
    cnt = 1
    for ch in pwd[1:]:
        if ch in ['a', 'e', 'i', 'o', 'u'] and prev in ['a', 'e', 'i', 'o', 'u']:
            cnt += 1
        elif ch not in ['a', 'e', 'i', 'o', 'u'] and prev not in ['a', 'e', 'i', 'o', 'u']:
            cnt += 1
        else:
            cnt = 1
            prev = ch
        if cnt >= 3:
            second = False
            break

    third = True
    prev = pwd[0]
    cnt = 1
    for ch in pwd[1:]:
        if prev == ch:
            cnt += 1
        else:
            cnt = 1
            prev = ch
        if ch not in ['e', 'o'] and cnt >= 2 or cnt >= 3:
            third = False
            break

    print('<%s> is ' % pwd, end='acceptable.\n' if first and second and third else 'not acceptable.\n')
