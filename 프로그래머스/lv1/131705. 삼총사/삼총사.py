answer = 0
visit = []
def recur(depth: int, start: int, total: int, number: list, length: int) -> None:
    global answer, visit
    if depth == 3:
        if total == 0:
            answer += 1
    for i in range(start, length):
        if visit[i]:
            continue
        visit[i] = True
        total += number[i]
        recur(depth+1, i+1, total, number, length)
        total -= number[i]
        visit[i] = False
        
def solution(number):
    global answer, visit
    visit = [False] * len(number)
    recur(0, 0, 0, number, len(number))
    return answer