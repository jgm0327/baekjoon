from sys import stdin

n = int(stdin.readline())
words = [stdin.readline() for _ in range(n)]
answer = 0
for word in words:
    stack = []
    visit = {word[0]: True}
    prev = word[0]
    for ch in word[1:]:
        if prev != ch and visit.get(ch) is not None:
            answer -= 1
            break
        visit[ch] = True
        prev = ch
    answer += 1
print(answer)