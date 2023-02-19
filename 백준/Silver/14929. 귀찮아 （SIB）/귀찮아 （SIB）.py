from sys import stdin

n = int(stdin.readline())
numbers = list(map(int, stdin.readline().split()))
total = sum(numbers)
answer = 0
for i in range(n):
    total -= numbers[i]
    answer += total * numbers[i]
print(answer)
