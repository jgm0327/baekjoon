from sys import stdin

n = int(stdin.readline())
people = sorted([int(stdin.readline()) for _ in range(n)], reverse=True)
answer = 0
for idx, person in enumerate(people):
    tip = person - idx
    if tip > 0:
        answer += tip
print(answer)

