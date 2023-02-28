from sys import stdin


def recur(s: str, l: int, r: int) -> int:
    global cnt
    cnt += 1
    if l >= r:
        return 1
    elif s[l] != s[r]:
        return 0
    else:
        return recur(s, l+1, r-1)

for _ in range(int(stdin.readline())):
    s = stdin.readline().rstrip()
    cnt = 0
    print(recur(s, 0, len(s) - 1), cnt)
