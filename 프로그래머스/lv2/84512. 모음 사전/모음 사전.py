answer = 0
cnt = 0
vowls = ['A', 'E', 'I', 'O', 'U']

def recur(depth: int, path: list, word: str) -> None:
    global answer, vowls, cnt
    if ''.join(path) == word and answer == 0:
        answer = cnt
        return
    if depth == 5:
        return
    for i in range(5):
        cnt += 1
        path.append(vowls[i])
        recur(depth+1, path, word)
        path.pop()

def solution(word):
    global answer
    recur(0, [], word)
    return answer