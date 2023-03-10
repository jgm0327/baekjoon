stoku = [list(map(int, input().split())) for _ in range(9)]
pos = []
for i in range(9):
    for j in range(9):
        if stoku[i][j] == 0:
            pos.append([i,j])
n = len(pos)


def check_vh(s: int, value: int, is_v: bool) -> bool:
    global stoku
    for i in range(9):
        if is_v and stoku[i][s] == value:
            return False
        elif not is_v and stoku[s][i] == value:
            return False
    return True


def check_square(y: int, x: int, value: int) -> bool:
    global stoku
    ey, ex = (y // 3) * 3, (x // 3) * 3
    for i in range(3):
        for j in range(3):
            if value == stoku[ey+i][ex+j]:
                return False
    return True


def recur(depth: int):
    global n, stoku, pos
    if n == depth:
        for s in stoku:
            print(*s)
        exit(0)
        
    y, x = pos[depth]
    for i in range(1, 10):
        if not check_vh(x, i, True) or not check_vh(y, i, False) or not check_square(y, x, i):
            continue
        stoku[y][x] = i
        recur(depth+1)
        stoku[y][x] = 0

recur(0)
