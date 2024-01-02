import sys

input = sys.stdin.readline

n = int(input())

words = [sorted(list(input().rstrip())) for _ in range(n)]


def backtracking(depth, path):
    global word_len, visit, exist, answer, word

    if depth == word_len:
        answer.append(''.join(path))
        return

    for i in range(word_len):
        if visit[i]:
            continue

        visit[i] = True
        path.append(word[i])
        if exist.get(''.join(path)) is None:
            exist[''.join(path)] = True
            backtracking(depth + 1, path)
        
        path.pop()
        visit[i] = False
            

for word in words:
    word_len = len(word)
    visit = [False] * word_len
    exist = {}

    answer = []
    backtracking(0, [])

    print('\n'.join(answer))
    
    
