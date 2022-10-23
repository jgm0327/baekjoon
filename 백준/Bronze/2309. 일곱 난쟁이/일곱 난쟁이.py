import sys


def recur(depth, total, dwarfs: list):
    global people, visit
    if depth == 7:
        if total == 100:
            dwarfs.sort()
            for dwarf in dwarfs:
                print(dwarf)
            exit(0)
    for i in range(9):
        if visit[i]:
            continue
        visit[i] = True
        dwarfs.append(people[i])
        recur(depth + 1, total + people[i], dwarfs)
        dwarfs.pop()
        visit[i] = False


people = []

visit = [False] * 9
for _ in range(9):
    people.append(int(sys.stdin.readline()))
recur(0, 0, [])