import sys

input = sys.stdin.readline

n = int(input())


def backtracking(depth, path):
    global word, answer, visit, exist

    if depth == len(word):
        answer.append(''.join(path))
        return

    for i in range(len(word)):
        if visit[i]:
            continue
        
        visit[i] = True
        path.append(word[i])
        ret = ''.join(path)
        if exist.get(ret) is None:
            exist[ret] = True
            backtracking(depth + 1, path)
        path.pop()
        visit[i] = False


for _ in range(n):
    answer = []
    word = sorted(list(input().rstrip()))
    visit = [False] * len(word)
    exist = {}
    
    backtracking(0, [])
    
    print('\n'.join(answer))
