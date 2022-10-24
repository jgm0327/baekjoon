import sys


def combination(depth: int, start: int, path: list) -> None:
    global n, password, m, cnt
    if depth == n and cnt[0] >= 1 and cnt[1] >= 2:
        print(''.join(path))
        return

    for i in range(start, m):
        idx = 1
        if visit[i]:
            continue
        if password[i] in ['a', 'e', 'i', 'o', 'u']:
            idx = 0
        visit[i] = True
        path.append(password[i])
        cnt[idx] += 1
        combination(depth + 1, i + 1, path)
        path.pop()
        cnt[idx] -= 1
        visit[i] = False


n, m = map(int, sys.stdin.readline().split())
password = sorted(list(sys.stdin.readline().split()))
visit = [False] * m
cnt = [0, 0] # 모음 개수, 자음 개수
combination(0, 0, [])
