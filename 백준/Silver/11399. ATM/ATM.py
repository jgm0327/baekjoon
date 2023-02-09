import sys

input = sys.stdin

n = int(input.readline())
atm = sorted(list(map(int, input.readline().split())))
answer = temp = 0
for person in atm:
    temp += person
    answer += temp
print(answer)
